import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DesafiosStreamAPI {
    public static void main(String[] args) {
        // Desafio 1 - Mostrar a lista na ordem numérica
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosOrdenados = numeros.stream()
                                                .sorted()
                                                .collect(Collectors.toList());
        System.out.println("Desafio 1 - Lista ordenada: " + numerosOrdenados);

        // Desafio 2 - Imprimir a soma dos números pares da lista
        int somaPares = numeros.stream()
                               .filter(n -> n % 2 == 0)
                               .mapToInt(Integer::intValue)
                               .sum();
        System.out.println("Desafio 2 - Soma dos números pares: " + somaPares);

        // Desafio 3 - Verificar se todos os números da lista são positivos
        boolean todosPositivos = numeros.stream()
                                       .allMatch(n -> n > 0);
        System.out.println("Desafio 3 - Todos os números são positivos? " + todosPositivos);

        // Desafio 4 - Remover todos os valores ímpares
        List<Integer> listaSemImpares = numeros.stream()
                                               .filter(n -> n % 2 == 0)
                                               .collect(Collectors.toList());
        System.out.println("Desafio 4 - Lista sem números ímpares: " + listaSemImpares);

        // Desafio 5 - Calcular a média dos números maiores que 5
        double mediaMaioresQue5 = numeros.stream()
                                         .filter(n -> n > 5)
                                         .mapToInt(Integer::intValue)
                                         .average()
                                         .orElse(0);
        System.out.println("Desafio 5 - Média dos números maiores que 5: " + mediaMaioresQue5);

        // Desafio 6 - Verificar se a lista contém algum número maior que 10
        boolean temMaiorQue10 = numeros.stream()
                                      .anyMatch(n -> n > 10);
        System.out.println("Desafio 6 - A lista contém algum número maior que 10? " + temMaiorQue10);

        // Desafio 7 - Encontrar o segundo número maior da lista
        List<Integer> numerosOrdenadosDesc = numeros.stream()
                                                    .distinct()
                                                    .sorted((a, b) -> b.compareTo(a))
                                                    .collect(Collectors.toList());
        int segundoMaior = numerosOrdenadosDesc.get(1);
        System.out.println("Desafio 7 - Segundo número maior da lista: " + segundoMaior);

        // Desafio 8 - Somar os dígitos de todos os números da lista
        int somaDigitos = numeros.stream()
                                .mapToInt(n -> String.valueOf(n).chars().map(Character::getNumericValue).sum())
                                .sum();
        System.out.println("Desafio 8 - Soma dos dígitos: " + somaDigitos);

        // Desafio 9 - Verificar se todos os números da lista são distintos
        boolean saoDistintos = numeros.stream().distinct().count() == numeros.size();
        System.out.println("Desafio 9 - Todos os números são distintos? " + saoDistintos);

        // Desafio 10 - Agrupar os valores ímpares múltiplos de 3 ou de 5
        Map<Boolean, List<Integer>> agrupamento = numeros.stream()
                .filter(n -> n % 2 != 0 && (n % 3 == 0 || n % 5 == 0))
                .collect(Collectors.partitioningBy(n -> n % 2 != 0));
        System.out.println("Desafio 10 - Agrupamento: " + agrupamento);

        // Desafio 11 - Encontrar a soma dos quadrados de todos os números da lista
        int somaQuadrados = numeros.stream()
                                  .mapToInt(n -> n * n)
                                  .sum();
        System.out.println("Desafio 11 - Soma dos quadrados: " + somaQuadrados);

        // Desafio 12 - Encontrar o produto de todos os números da lista
        int produto = numeros.stream()
                            .reduce(1, (a, b) -> a * b);
        System.out.println("Desafio 12 - Produto: " + produto);

        // Desafio 13 - Filtrar os números que estão dentro de um intervalo
        List<Integer> dentroIntervalo = numeros.stream()
                                               .filter(n -> n >= 5 && n <= 10)
                                               .collect(Collectors.toList());
        System.out.println("Desafio 13 - Números dentro do intervalo: " + dentroIntervalo);

        // Desafio 14 - Encontrar o maior número primo da lista
        int maiorPrimo = numeros.stream()
                                .filter(n -> {
                                    if (n <= 1) return false;
                                    for (int i = 2; i <= Math.sqrt(n); i++) {
                                        if (n % i == 0) return false;
                                    }
                                    return true;
                                })
                                .max(Integer::compareTo)
                                .orElse(0);
        System.out.println("Desafio 14 - Maior número primo: " + maiorPrimo);

        // Desafio 15 - Verificar se a lista contém pelo menos um número negativo
        boolean temNegativo = numeros.stream()
                                    .anyMatch(n -> n < 0);
        System.out.println("Desafio 15 - A lista contém algum número negativo? " + temNegativo);

        // Desafio 16 - Agrupar os números em pares e ímpares
        Map<Boolean, List<Integer>> numerosParesImpares = numeros.stream()
                                                                 .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Desafio 16 - Números pares e ímpares: " + numerosParesImpares);

        // Desafio 17 - Filtrar os números primos da lista
        List<Integer> primos = numeros.stream()
                                      .filter(n -> {
                                          if (n <= 1) return false;
                                          for (int i = 2; i <= Math.sqrt(n); i++) {
                                              if (n % i == 0) return false;
                                          }
                                          return true;
                                      })
                                      .collect(Collectors.toList());
        System.out.println("Desafio 17 - Números primos: " + primos);

        // Desafio 18 - Verificar se todos os números da lista são iguais
        boolean saoIguais = numeros.stream().distinct().count() == 1;
        System.out.println("Desafio 18 - Todos os números são iguais? " + saoIguais);

        // Desafio 19 - Encontrar a soma dos números divisíveis por 3 e 5
        int somaDivisiveis3e5 = numeros.stream()
                                       .filter(n -> n % 3 == 0 && n % 5 == 0)
                                       .mapToInt(Integer::intValue)
                                       .sum();
        System.out.println("Desafio 19 - Soma dos números divisíveis por 3 e 5: " + somaDivisiveis3e5);
    }
}
