package banco.conta;

import banco.cliente.Cliente;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Titular: " + this.getCliente().getNome());
        System.out.println("Número da Conta: " + this.getNumeroConta());
        System.out.println("Saldo: " + this.getSaldo());
    }
}
