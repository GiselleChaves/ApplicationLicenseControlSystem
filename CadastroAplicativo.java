import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import aplicativos.*;


public class CadastroAplicativo extends JDialog {

    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField valorField;
    private JTextField soField;

    private PaginaAplicativos paginaAplicativos;
    private CatalogoAplicativos catalogoAplicativos;

    public CadastroAplicativo(PaginaAplicativos parent) {
        super(parent, "Cadastro de Aplicativo", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaAplicativos = parent;
        this.catalogoAplicativos = parent.getCatalogoAplicativos();
        initComponents();
    }

    private void initComponents() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblCodigo = new JLabel("Código:");
        codigoField = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel lblValor = new JLabel("Valor Mensal Assinatura:");
        valorField = new JTextField();
        JLabel lblSo = new JLabel("SO (ios / android):");
        soField = new JTextField();

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
        panel.add(lblValor);
        panel.add(valorField);
        panel.add(lblSo);
        panel.add(soField);

        panel.add(Box.createVerticalStrut(10));

        panel.add(btnCadastrar);

        getContentPane().add(panel);
    }

    private void cadastrarAplicativo() {

        int codigo = Integer.parseInt(codigoField.getText());
        String nome = nomeField.getText();
        double valor = Double.parseDouble(valorField.getText());
        String so = soField.getText();

        Aplicativo aplicativo = catalogoAplicativos.getAplicativoByCodigo(codigo);

        if (aplicativo == null) {
            Aplicativo novoAplicativo = new Aplicativo(codigo, nome, valor, so);
            catalogoAplicativos.cadastraAppNoCatalogo(novoAplicativo);
            catalogoAplicativos.saveToFile();
            paginaAplicativos.criarEAtualizarTabela();
            JOptionPane.showMessageDialog(this, "Aplicativo cadastrado com sucesso!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Já existe um aplicativo com esse código.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaAplicativos paginaAplicativos = new PaginaAplicativos(null);
            CadastroAplicativo cadastro = new CadastroAplicativo(paginaAplicativos);
            cadastro.setLocationRelativeTo(paginaAplicativos);
            cadastro.setVisible(true);
        });
    }
}
