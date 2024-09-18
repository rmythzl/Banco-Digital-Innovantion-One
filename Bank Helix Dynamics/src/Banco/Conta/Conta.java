package banco.conta;

import banco.cliente.Cliente;

public abstract class Conta {
    private static int SEQUENCIAL = 1;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;

    // Construtor
    public Conta(Cliente cliente) {
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Métodos de depósito, saque e transferência
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    // Método abstrato para imprimir o extrato, a ser implementado nas subclasses
    public abstract void imprimirExtrato();
}
