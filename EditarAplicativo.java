import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicativos.*;

public class EditarAplicativo extends JDialog {
    private JTextField campoCodigo;
    private JTextField campoNome;
    private JTextField campoValor;
    private JTextField campoSo;

    private CatalogoAplicativos catalogoAplicativos;
    private PaginaAplicativos paginaAplicativos;

    public EditarAplicativo(PaginaAplicativos parent) {
        super(parent, "Editar Aplicativo", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaAplicativos = parent;
        this.catalogoAplicativos = parent.getCatalogoAplicativos();
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
        campoCodigo = new JTextField();
        campoNome = new JTextField();
        campoValor = new JTextField();

        JLabel rotuloCodigo = new JLabel("Codigo:");
        JLabel rotuloNome = new JLabel("Nome:");
        JLabel rotuloValor = new JLabel("Valor:");

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

        add(rotuloCodigo);
        add(campoCodigo);
        add(rotuloNome);
        add(campoNome);
        add(rotuloValor);
        add(campoValor);
        add(botaoSalvar);
        add(botaoCancelar);
    }

    private void adicionarComponentes() {
        // Adicione os componentes à janela aqui
    }

    private void salvarAlteracoes() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            String novoNome = campoNome.getText();
            double novoValor = Double.parseDouble(campoValor.getText());

            Aplicativo Aplicativo = catalogoAplicativos.getAplicativoByCodigo(codigo);

            if (Aplicativo != null) {
                Aplicativo.setNome(novoNome);
                Aplicativo.setValorMensalAssinatura(novoValor);
                catalogoAplicativos.saveToFile(); // Salva as alterações no arquivo
                paginaAplicativos.criarEAtualizarTabela(); // Atualiza a tabela na página principal
                JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
                dispose(); // Fecha a janela de edição
            } else {
                JOptionPane.showMessageDialog(this, "Aplicativo não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um código válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaAplicativos paginaAplicativos = new PaginaAplicativos(null); // Substitua `null` pela instância correta se necessário
            EditarAplicativo editar = new EditarAplicativo(paginaAplicativos);
            editar.setLocationRelativeTo(paginaAplicativos);
            editar.setVisible(true);
        });
    }
}


