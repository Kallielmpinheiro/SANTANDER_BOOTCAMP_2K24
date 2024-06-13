public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente, double saldoInicial, double taxaRendimento) {
        super(cliente, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}