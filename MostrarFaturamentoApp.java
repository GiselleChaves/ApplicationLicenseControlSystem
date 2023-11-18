import javax.swing.*;

import aplicativos.CatalogoAplicativos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import assinaturas.*;
import clientes.*;
import aplicativos.*;


public class MostrarFaturamentoApp extends JDialog {
    private JTextField campoCodigo;
    private JTextArea areaTextoAssinaturas;
    private CatalogoAssinaturas catalogoAssinaturas;
    private CatalogoAplicativos catalogoAplicativos;
    private CatalogoClientes catalogoClientes;

    public MostrarFaturamentoApp(PaginaAplicativos parent) {
        super(parent, "Mostrar Faturamento do App", Dialog.ModalityType.APPLICATION_MODAL);
        this.catalogoAssinaturas = parent.getCatalogoAssinaturas();
        this.catalogoAplicativos = parent.getCatalogoAplicativos();
        this.catalogoClientes = parent.getCatalogoClientes();
        configurarJanela();
        criarComponentes();
        adicionarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());
    }

    private void criarComponentes() {
        campoCodigo = new JTextField();
        areaTextoAssinaturas = new JTextArea();
        areaTextoAssinaturas.setEditable(false);

        JLabel rotuloCodigo = new JLabel("Código do App:");

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFaturamento();
            }
        });

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel painelSuperior = new JPanel(new GridLayout(1, 4, 10, 10));
        painelSuperior.add(rotuloCodigo);
        painelSuperior.add(campoCodigo);
        painelSuperior.add(botaoBuscar);
        painelSuperior.add(botaoCancelar);

        JScrollPane scrollPane = new JScrollPane(areaTextoAssinaturas);

        add(painelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    private void adicionarComponentes() {
        // Adicione os componentes à janela aqui
    }

    private void mostrarFaturamento() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
    
            List<Assinatura> assinaturas = catalogoAssinaturas.getAssinaturasByCodigoApp(codigo);

            if (!assinaturas.isEmpty()) {
                double faturamento = assinaturas.size() * catalogoAplicativos.getValorMensalByCodigo(codigo);
    
                // Exibir o faturamento em reais
                String mensagem = String.format("Faturamento do App: R$ %.2f", faturamento);
                areaTextoAssinaturas.setText(mensagem);
            } else {
                JOptionPane.showMessageDialog(this, "App não possui assinaturas", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um código válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaClientes paginaClientes = new PaginaClientes(null); // Substitua `null` pela instância correta se necessário
            MostrarAssinaturas editar = new MostrarAssinaturas(paginaClientes);
            editar.setLocationRelativeTo(paginaClientes);
            editar.setVisible(true);
        });
    }
}