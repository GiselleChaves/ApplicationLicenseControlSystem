import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;

public class EditarCliente extends JDialog {
    private JTextField campoCpf;
    private JTextField campoNome;
    private JTextField campoEmail;

    private CatalogoClientes catalogoClientes;
    private PaginaClientes paginaClientes;

    public EditarCliente(PaginaClientes parent) {
        super(parent, "Editar Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaClientes = parent;
        this.catalogoClientes = parent.getCatalogoClientes();
        configurarJanela();
        criarComponentes();
        adicionarComponentes();
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
                salvarAlteracoes();
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

    private void adicionarComponentes() {
        // Adicione os componentes à janela aqui
    }

    private void salvarAlteracoes() {
        try {
            String cpf = campoCpf.getText();
            String novoNome = campoNome.getText();
            String novoEmail = campoEmail.getText();

            Cliente cliente = catalogoClientes.getClienteByCpf(cpf);
            if (cliente != null) {
                cliente.setNome(novoNome);
                cliente.setEmail(novoEmail);
                catalogoClientes.saveToFile(); // Salva as alterações no arquivo
                paginaClientes.criarEAtualizarTabela(); // Atualiza a tabela na página principal
                JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
                dispose(); // Fecha a janela de edição
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaClientes paginaClientes = new PaginaClientes(null); // Substitua `null` pela instância correta se necessário
            EditarCliente editar = new EditarCliente(paginaClientes);
            editar.setLocationRelativeTo(paginaClientes);
            editar.setVisible(true);
        });
    }
}


