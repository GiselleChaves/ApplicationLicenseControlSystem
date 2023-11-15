import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditarCliente extends JDialog {

    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField emailField;

    private PaginaClientes paginaClientes; 

    public EditarCliente(PaginaClientes parent) {
        super(parent, "Editar de Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaClientes = parent;
        initComponents();
    }

    private void initComponents() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adiciona um espaçamento de 10 pixels em todas as bordas do JPanel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCpf = new JLabel("Cpf:");
        cpfField = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel lblEmail = new JLabel("E-mail:");
        emailField = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }

        
        });

        panel.add(lblCpf);
        panel.add(cpfField);
        panel.add(lblNome);
        panel.add(nomeField);
        panel.add(lblEmail);
        panel.add(emailField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(btnCadastrar);

        getContentPane().add(panel);
    }

    private void cadastrarCliente() {
        // Código para cadastrar o cliente
        int cpf = Integer.parseInt(cpfField.getText());
        String nome = nomeField.getText();
        String email = emailField.getText();
        salvarEmArquivo(cpf, nome, email);        

        // Limpe os campos após cadastrar o cliente
        cpfField.setText("");
        nomeField.setText("");
        emailField.setText("");

        dispose();
    }

    private void salvarEmArquivo(int cpf, String nome, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosClientes.txt", true))) {
            // Append para adicionar ao final do arquivo
            writer.write("CPF: " + cpf + ", Nome: " + nome + ", Email: " + email);
            writer.newLine(); // Adicionar uma nova linha para cada entrada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaClientes paginaClientes = new PaginaClientes(null); // Substitua `null` pela instância correta se necessário
            CadastroCliente cadastro = new CadastroCliente(paginaClientes);
            cadastro.setLocationRelativeTo(paginaClientes);
            cadastro.setVisible(true);
        });
    }
}

}
