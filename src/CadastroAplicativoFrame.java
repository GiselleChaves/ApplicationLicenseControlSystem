import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class CadastroAplicativoFrame extends JFrame {
    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField soField;
    private JTextField valorMensalField;

    public CadastroAplicativoFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Aplicativo");
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
        int codigo = Integer.parseInt(codigoField.getText());
        String nome = nomeField.getText();
        String so = soField.getText();
        double valorMensalAssinatura = Double.parseDouble(valorMensalField.getText());

        //catalogoAplicativos.cadastra(new Aplicativo(codigo, nome, so, valorMensalAssinatura));

        // Limpe os campos após cadastrar o aplicativo
        codigoField.setText("");
        nomeField.setText("");
        soField.setText("");
        valorMensalField.setText("");

        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroAplicativoFrame cadastroFrame = new CadastroAplicativoFrame();
            cadastroFrame.setVisible(true);
        });
    }
}
