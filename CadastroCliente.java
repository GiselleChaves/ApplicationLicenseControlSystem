import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import clientes.*;


public class CadastroCliente extends JDialog {

    private JTextField campoCpf;
    private JTextField campoNome;
    private JTextField campoEmail;

    private CatalogoClientes catalogoClientes;
    private PaginaClientes paginaClientes;
    

    public CadastroCliente(PaginaClientes parent) {
        super(parent, "Cadastro de Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaClientes = parent;
        this.catalogoClientes = parent.getCatalogoClientes();
        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
    }

    private void criarComponentes() {
        campoCpf = new JTextField();
        campoNome = new JTextField();
        campoEmail = new JTextField();

        JLabel rotuloCpf = new JLabel("CPF:");
        JLabel rotuloNome = new JLabel("Nome:");
        JLabel rotuloEmail = new JLabel("Email:");

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(rotuloCpf);
        add(campoCpf);
        add(rotuloNome);
        add(campoNome);
        add(rotuloEmail);
        add(campoEmail);
        add(botaoSalvar);
        add(botaoCancelar);
    }

    private void cadastrarCliente() {

            String cpf = campoCpf.getText();
            String nome = campoNome.getText();
            String email = campoEmail.getText();

            Cliente cliente = catalogoClientes.getClienteByCpf(cpf);

            if (cliente == null) {
                Cliente novoCliente = new Cliente(cpf, nome, email);
                catalogoClientes.cadastrarCliente(novoCliente);

                catalogoClientes.saveToFile(); // Salva as alterações no arquivo
                paginaClientes.criarEAtualizarTabela(); // Atualiza a tabela na página principal
                JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
                dispose(); // Fecha a janela de edição
            } else {
                JOptionPane.showMessageDialog(this, "Já existe um cliente com esse CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
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
