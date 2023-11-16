import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroAplicativo extends JDialog {
    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField soField;
    private JTextField valorMensalField;

    private PaginaAplicativos paginaAplicativos; 

    public CadastroAplicativo(PaginaAplicativos parent) {
        super(parent, "Cadastro de Aplicativo", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaAplicativos = parent;
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Aplicativo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCodigo = new JLabel("Código:");
        codigoField = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel lblSo = new JLabel("SO:");
        soField = new JTextField();
        JLabel lblValorMensal = new JLabel("Valor mensal:");
        valorMensalField = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAplicativo();
            }
        });

        panel.add(lblCodigo);
        panel.add(codigoField);
        panel.add(lblNome);
        panel.add(nomeField);
        panel.add(lblSo);
        panel.add(soField);
        panel.add(lblValorMensal);
        panel.add(valorMensalField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(btnCadastrar);

        getContentPane().add(panel);
    }

    private void cadastrarAplicativo() {
        // Seu código para cadastrar o aplicativo
        //try {
            int codigo = Integer.parseInt(codigoField.getText());
            String nome = nomeField.getText();
            String so = soField.getText();
            double valorMensalAssinatura = Double.parseDouble(valorMensalField.getText());
            salvarAppEmArquivo(codigo, nome, so, valorMensalAssinatura);  
    
            // Limpe os campos após cadastrar o aplicativo
            codigoField.setText("");
            nomeField.setText("");
            soField.setText("");
            valorMensalField.setText("");
    
            dispose();
    } 

    private void salvarAppEmArquivo(int codigo, String nome, String so, double email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("apps.txt", true))) {
            // Append para adicionar ao final do arquivo
            writer.write("CODIGO: " + codigo + ", Nome: " + nome + ", SO: " + so + ", EMAIL:" + email);
            writer.newLine(); // Adicionar uma nova linha para cada entrada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaAplicativos paginaAplicativos = new PaginaAplicativos(null); // Substitua `null` pela instância correta se necessário
            CadastroAplicativo cadastro = new CadastroAplicativo(paginaAplicativos);
            cadastro.setLocationRelativeTo(paginaAplicativos);
            cadastro.setVisible(true);
        });
    }
}
