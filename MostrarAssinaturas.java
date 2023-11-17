import javax.swing.*;

import aplicativos.CatalogoAplicativos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import assinaturas.*;


public class MostrarAssinaturas extends JDialog {
    private JTextField campoCpf;
    private JTextArea areaTextoAssinaturas;
    private CatalogoAssinaturas catalogoAssinaturas;
    private CatalogoAplicativos catalogoAplicativos;

    public MostrarAssinaturas(PaginaClientes parent) {
        super(parent, "Mostrar assinaturas do Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.catalogoAssinaturas = parent.getCatalogoAssinaturas();
        this.catalogoAplicativos = parent.getCatalogoAplicativos();
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
        campoCpf = new JTextField();
        areaTextoAssinaturas = new JTextArea();
        areaTextoAssinaturas.setEditable(false);

        JLabel rotuloCpf = new JLabel("CPF:");

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAssinaturas();
            }
        });

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel painelSuperior = new JPanel(new GridLayout(1, 4, 10, 10));
        painelSuperior.add(rotuloCpf);
        painelSuperior.add(campoCpf);
        painelSuperior.add(botaoBuscar);
        painelSuperior.add(botaoCancelar);

        JScrollPane scrollPane = new JScrollPane(areaTextoAssinaturas);

        add(painelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    private void adicionarComponentes() {
        // Adicione os componentes à janela aqui
    }

    private void mostrarAssinaturas() {
        try {
            String cpf = campoCpf.getText();

            List<Assinatura> assinaturas = catalogoAssinaturas.getAssinaturasByCPF(cpf);

            if (!assinaturas.isEmpty()) {
                StringBuilder mensagem = new StringBuilder("Assinaturas do cliente:\n");
                for (Assinatura assinatura : assinaturas) {
                    mensagem.append("Código de Assinatura: ").append(assinatura.getCodigoAssinatura()).append("\n");
                    mensagem.append("Aplicativo: ").append(catalogoAplicativos.getAplicativoByCodigo(assinatura.getCodigoApp()).getNome()).append("\n");
                    mensagem.append("CPF do Cliente: ").append(assinatura.getCpfCliente()).append("\n");
                    mensagem.append("Mês de Início da Vigência: ").append(assinatura.getMesInicioVigencia()).append("\n");
                    mensagem.append("Ano de Início da Vigência: ").append(assinatura.getAnoInicioVigencia()).append("\n");
                
                    // Adicione mais informações conforme necessário
                
                    mensagem.append("\n"); // Adiciona uma linha em branco para separar as assinaturas
                }
                areaTextoAssinaturas.setText(mensagem.toString());
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
            MostrarAssinaturas editar = new MostrarAssinaturas(paginaClientes);
            editar.setLocationRelativeTo(paginaClientes);
            editar.setVisible(true);
        });
    }
}