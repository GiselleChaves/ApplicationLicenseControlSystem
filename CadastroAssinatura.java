import javax.swing.*;
import javax.swing.border.EmptyBorder;

import aplicativos.Aplicativo;
import aplicativos.CatalogoAplicativos;
import assinaturas.Assinatura;
import assinaturas.CatalogoAssinaturas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import clientes.*;


public class CadastroAssinatura extends JDialog {

    private JTextField campoCodigoAssinatura;
    private JTextField campoCpf;
    private JTextField campoCodigoAplicativo;
    private JTextField campoMesInicio;
    private JTextField campoAnoInicio;

    private PaginaAssinaturas paginaAssinaturas;
    private CatalogoClientes catalogoClientes;
    private CatalogoAssinaturas catalogoAssinaturas;
    private CatalogoAplicativos catalogoAplicativos;
    

    public CadastroAssinatura(PaginaAssinaturas parent) {
        super(parent, "Cadastro de Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaAssinaturas = parent;
        this.catalogoAssinaturas= parent.getCatalogoAssinaturas();
        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 350);
        // Alterado para FlowLayout com alinhamento à esquerda
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    }

    private void criarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Layout de grade com duas colunas
    
        JLabel rotuloCodigoAssinatura = new JLabel("Código da Assinatura:");
        campoCodigoAssinatura = new JTextField();
        JLabel rotuloCpf = new JLabel("CPF Cliente:");
        campoCpf = new JTextField();
        JLabel rotuloCodigoAplicativo = new JLabel("Código Aplicativo:");
        campoCodigoAplicativo = new JTextField();
        JLabel rotuloMesInicio = new JLabel("Mês:");
        campoMesInicio = new JTextField();
        JLabel rotuloAnoInicio = new JLabel("Ano:");
        campoAnoInicio = new JTextField();
    
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarAssinatura();
            }
        });
    
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    
        // Adicionando rótulos e campos ao painel
        panel.add(rotuloCodigoAssinatura);
        panel.add(campoCodigoAssinatura);
        panel.add(rotuloCpf);
        panel.add(campoCpf);
        panel.add(rotuloCodigoAplicativo);
        panel.add(campoCodigoAplicativo);
        panel.add(rotuloMesInicio);
        panel.add(campoMesInicio);
        panel.add(rotuloAnoInicio);
        panel.add(campoAnoInicio);
    
        // Usando FlowLayout com alinhamento à esquerda para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoesPanel.add(botaoSalvar);
        botoesPanel.add(botaoCancelar);
    
        // Adicionando o painel de botões ao painel principal
        panel.add(botoesPanel);
    
        getContentPane().add(panel);
    }


    private void cadastrarAssinatura() {

            String codigoAssinatura = campoCodigoAssinatura.getText();
            String cpf = campoCpf.getText();
            int codigoAplicativo  = Integer.parseInt(campoCodigoAplicativo.getText());
            String mesInicio = campoMesInicio.getText();
            String anoInicio = campoAnoInicio.getText();

            Cliente cliente = catalogoClientes.getClienteByCpf(cpf);
            Aplicativo aplicativo = catalogoAplicativos.getAplicativoByCodigo(codigoAplicativo);

            if (cliente != null && aplicativo != null) {

                Assinatura novaAssinatura = new Assinatura(codigoAssinatura, codigoAplicativo, cpf, mesInicio, anoInicio);
                catalogoAssinaturas.cadastraAssinaturaNoCatalogo(novaAssinatura);

                catalogoAssinaturas.saveToFile(); // Salva as alterações no arquivo
                paginaAssinaturas.criarEAtualizarTabela(); // Atualiza a tabela na página principal
                JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
                dispose(); // Fecha a janela de edição
            } else {
                JOptionPane.showMessageDialog(this, "CPF/Código: Alguma das informações não foi encontrada em nosso sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
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
