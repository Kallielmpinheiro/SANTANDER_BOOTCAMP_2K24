import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
  private Set<String> palavrasUnicasSet;

  public ConjuntoPalavrasUnicas() {
    this.palavrasUnicasSet = new HashSet<>();
  }

  public void adicionarPalavra(String palavra) {
    if (palavrasUnicasSet.add(palavra)) {
      System.out.println("Palavra adicionada com sucesso.");
    } else {
      System.out.println("A palavra já existe no conjunto.");
    }
  }

  public void removerPalavra(String palavra) {
    if (palavrasUnicasSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
    } else if (palavrasUnicasSet.remove(palavra)) {
      System.out.println("Palavra removida com sucesso.");
    } else {
      System.out.println("Palavra não encontrada no conjunto!");
    }
  }

  public boolean verificarPalavra(String palavra) {
    return palavrasUnicasSet.contains(palavra);
  }

  public void exibirPalavrasUnicas() {
    if (palavrasUnicasSet.isEmpty()) {
      System.out.println("O conjunto está vazio!");
    } else {
      System.out.println(palavrasUnicasSet);
    }
  }

  public static void main(String[] args) {
    ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

    conjuntoLinguagens.adicionarPalavra("Java");
    conjuntoLinguagens.adicionarPalavra("Python");
    conjuntoLinguagens.adicionarPalavra("JavaScript");
    conjuntoLinguagens.adicionarPalavra("Python");
    conjuntoLinguagens.adicionarPalavra("C++");
    conjuntoLinguagens.adicionarPalavra("Ruby");

    System.out.println("Conjunto de palavras únicas:");
    conjuntoLinguagens.exibirPalavrasUnicas();

    conjuntoLinguagens.removerPalavra("Python");
    conjuntoLinguagens.exibirPalavrasUnicas();

    conjuntoLinguagens.removerPalavra("Swift");

    System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
    System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));

    conjuntoLinguagens.exibirPalavrasUnicas();
  }
}
