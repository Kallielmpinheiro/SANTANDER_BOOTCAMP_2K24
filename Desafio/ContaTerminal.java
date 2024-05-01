import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner entradaDados = new Scanner(System.in);

        System.out.println("Por favor, digite o número da Agência:");
        String agencia = entradaDados.nextLine();

        System.out.println("Por favor, digite o número da Conta:");
        int numero = entradaDados.nextInt();
        entradaDados.nextLine();

        System.out.println("Por favor, digite o nome do Cliente:");
        String nomeCliente = entradaDados.nextLine();

        System.out.println("Por favor, digite o saldo da Conta:");
        double saldo = entradaDados.nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");

        entradaDados.close();
    }
}
