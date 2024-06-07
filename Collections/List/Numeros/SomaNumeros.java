import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.numeros.add(numero);
    }

    public int calcularSoma() {
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }

    public int encontrarMaiorNumero() {
        return numeros.stream().max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("A lista está vazia!"));
    }

    public int encontrarMenorNumero() {
        return numeros.stream().min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("A lista está vazia!"));
    }

    public void exibirNumeros() {
        if (!numeros.isEmpty()) {
            System.out.println(numeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
