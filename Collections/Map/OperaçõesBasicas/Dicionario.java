import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionario.isEmpty()) {
            if (dicionario.remove(palavra) == null) {
                System.out.println("Palavra não encontrada no dicionário.");
            }
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = dicionario.get(palavra);
        if (definicao != null) {
            return definicao;
        }
        return "Palavra não encontrada no dicionário.";
    }

    public void exibirPalavras() {
        if (!dicionario.isEmpty()) {
            for (Map.Entry<String, String> entrada : dicionario.entrySet()) {
                System.out.println("Palavra: " + entrada.getKey() + " - Definição: " + entrada.getValue());
            }
        } else {
            System.out.println("O dicionário está vazio.");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras (linguagens de programação)
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        // Exibir todas as palavras
        System.out.println("Palavras no dicionário:");
        dicionario.exibirPalavras();

        // Pesquisar palavras
        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
        System.out.println("Definição da linguagem 'csharp': " + definicaoCSharp);

        // Remover uma palavra
        dicionario.removerPalavra("typescript");
        System.out.println("Palavras no dicionário após remoção:");
        dicionario.exibirPalavras();
    }
}
