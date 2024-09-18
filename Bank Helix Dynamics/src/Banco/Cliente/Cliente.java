package banco.cliente;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;

    // Construtor
    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método toString para exibir informações do cliente de forma legível
    @Override
    public String toString() {
        return "Cliente [Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + "]";
    }
}
