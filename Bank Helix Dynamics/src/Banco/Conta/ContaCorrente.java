package banco.conta;

import banco.cliente.Cliente;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Titular: " + this.getCliente().getNome());
        System.out.println("Número da Conta: " + this.getNumeroConta());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
