import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteFrame extends JFrame {
    
    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField emailField;

    public CadastroClienteFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Adiciona um espaçamento de 10 pixels em todas as bordas do JPanel
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCodigo = new JLabel("Código:");
        codigoField = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel lblEmail = new JLabel("E-mail:");
        emailField = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cadastrarCliente();
            }
        });

        panel.add(lblCodigo);
        panel.add(codigoField);
        panel.add(lblNome);
        panel.add(nomeField);
        panel.add(lblEmail);
        panel.add(emailField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(btnCadastrar);

        getContentPane().add(panel);
    }

    private void cadastrarAplicativo() {
        int codigo = Integer.parseInt(codigoField.getText());
        String nome = nomeField.getText();
        String email = emailField.getText();

        //catalogoClientes.cadastra(new Aplicativo(codigo, nome, email));

        // Limpe os campos após cadastrar o aplicativo
        codigoField.setText("");
        nomeField.setText("");
        emailField.setText("");

        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAplicativoFrame cadastroFrame = new CadastroAplicativoFrame();
            cadastroFrame.setVisible(true);
        });
    }
}
