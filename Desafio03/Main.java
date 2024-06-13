public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Cliente cliente1 = new Cliente("João", "12345678901");
        Conta conta1 = new ContaCorrente(cliente1, 1000, 500);
        banco.adicionarConta(conta1);

        Conta conta2 = new ContaPoupanca(new Cliente("Maria", "98765432101"), 500, 0.05);
        banco.adicionarConta(conta2);

        System.out.println("Saldo da conta1 antes da transferência: " + conta1.getSaldo());
        System.out.println("Saldo da conta2 antes da transferência: " + conta2.getSaldo());

        conta1.transferir(conta2, 200);

        System.out.println("Saldo da conta1 depois da transferência: " + conta1.getSaldo());
        System.out.println("Saldo da conta2 depois da transferência: " + conta2.getSaldo());
    }
}
