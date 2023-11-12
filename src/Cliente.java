//package Cliente;
public class Cliente {
    private int codigo;
    private String nome;
    private String email;

    public Cliente(int codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String toLineFile() {
        return codigo + "," + nome + "," + email;
    }

    public static Cliente fromLineFile(String line) {
        String[] tokens = line.split(",");
        int codigo = Integer.parseInt(tokens[0]);
        String nome = tokens[1];
        String email = tokens[2];
        return new Cliente(codigo, nome, email);
    }
}
