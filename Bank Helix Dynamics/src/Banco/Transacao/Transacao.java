package banco.transacao;

import banco.conta.Conta;

public class Transacao {
    public static void realizarDeposito(Conta conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso! Saldo atual: " + conta.getSaldo());
    }

    public static void realizarSaque(Conta conta, double valor) {
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso! Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public static void realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (origem.transferir(valor, destino)) {
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência falhou, saldo insuficiente.");
        }
    }
}
