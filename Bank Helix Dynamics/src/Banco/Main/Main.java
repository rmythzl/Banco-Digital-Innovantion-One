package banco.main;

import banco.Banco;
import banco.cliente.Cliente;
import banco.conta.Conta;
import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;
import banco.transacao.Transacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Helix Dynamics Bank");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao " + banco.getNome());

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Criar Conta Corrente");
            System.out.println("3. Criar Conta Poupança");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Contas");
            System.out.println("6. Depositar");
            System.out.println("7. Sacar");
            System.out.println("8. Transferir");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço do Cliente: ");
                    String endereco = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf, endereco);
                    banco.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("CPF do Cliente: ");
                    cpf = scanner.nextLine();
                    cliente = buscarClientePorCPF(banco, cpf);
                    if (cliente != null) {
                        Conta contaCorrente = new ContaCorrente(cliente);
                        banco.adicionarConta(contaCorrente);
                        System.out.println("Conta Corrente criada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("CPF do Cliente: ");
                    cpf = scanner.nextLine();
                    cliente = buscarClientePorCPF(banco, cpf);
                    if (cliente != null) {
                        Conta contaPoupanca = new ContaPoupanca(cliente);
                        banco.adicionarConta(contaPoupanca);
                        System.out.println("Conta Poupança criada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    banco.listarClientes();
                    break;
                case 5:
                    banco.listarContas();
                    break;
                case 6:
                    System.out.print("Número da Conta: ");
                    int numeroConta = scanner.nextInt();
                    Conta conta = banco.buscarContaPorNumero(numeroConta);
                    if (conta != null) {
                        System.out.print("Valor do depósito: ");
                        double valor = scanner.nextDouble();
                        Transacao.realizarDeposito(conta, valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 7:
                    System.out.print("Número da Conta: ");
                    numeroConta = scanner.nextInt();
                    conta = banco.buscarContaPorNumero(numeroConta);
                    if (conta != null) {
                        System.out.print("Valor do saque: ");
                        double valor = scanner.nextDouble();
                        Transacao.realizarSaque(conta, valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 8:
                    System.out.print("Número da Conta de origem: ");
                    int numeroOrigem = scanner.nextInt();
                    Conta contaOrigem = banco.buscarContaPorNumero(numeroOrigem);
                    System.out.print("Número da Conta de destino: ");
                    int numeroDestino = scanner.nextInt();
                    Conta contaDestino = banco.buscarContaPorNumero(numeroDestino);
                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor da transferência: ");
                        double valor = scanner.nextDouble();
                        Transacao.realizarTransferencia(contaOrigem, contaDestino, valor);
                    } else {
                        System.out.println("Uma das contas não foi encontrada.");
                    }
                    break;
                case 9:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static Cliente buscarClientePorCPF(Banco banco, String cpf) {
        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
