public abstract class Conta implements IConta {
    private Cliente cliente;
    protected double saldo;

    public Conta(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    public void transferir(Conta contaDestino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência concluída com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

}