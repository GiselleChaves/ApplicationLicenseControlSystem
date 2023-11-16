package clientes;

public class Cliente {
    private int cpf;
    private String nome;
    private String email;

    public Cliente(int cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String toLineFile() {
        return cpf + "," + nome + "," + email;
    }

    public static Cliente fromLineFile(String line) {
        String[] tokens = line.split(",");
        int cpf = Integer.parseInt(tokens[0]);
        String nome = tokens[1];
        String email = tokens[2];
        return new Cliente(cpf, nome, email);
    }
}
