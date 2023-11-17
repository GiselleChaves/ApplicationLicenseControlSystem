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
import aplicativos.*;
import assinaturas.*;


public class CancelarAssinatura extends JDialog {

    private JTextField campoCpfCliente;
    private JTextField campoCodigoAplicativo;
    private JTextField campoMesFinal;
    private JTextField campoAnoFinal;

    private PaginaAssinaturas paginaAssinaturas;

    //CATALOGOS
    private CatalogoAssinaturas catalogoAssinaturas;
    

    public CancelarAssinatura(PaginaAssinaturas parent) {
        super(parent, "Cancelar Assinatura", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaAssinaturas = parent;

        this.catalogoAssinaturas= parent.getCatalogoAssinaturas();
        
        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(550, 300);
        // Alterado para FlowLayout com alinhamento à esquerda
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    }

    private void criarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Layout de grade com duas colunas
    
        JLabel rotuloCpfCliente = new JLabel("CPF Cliente:");
        campoCpfCliente = new JTextField();

        JLabel rotuloCodigoAplicativo = new JLabel("Código Aplicativo:");
        campoCodigoAplicativo = new JTextField();

        JLabel rotuloMesFinal = new JLabel("Mês Encerramento:");
        campoMesFinal = new JTextField();

        JLabel rotuloAnoFinal = new JLabel("Ano Encerramento:");
        campoAnoFinal = new JTextField();
    
        JButton botaoSalvar = new JButton("Cancelar Assinatura");
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarAssinatura();
            }
        });
    
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    
        // Adicionando rótulos e campos ao painel
        panel.add(rotuloCpfCliente);
        panel.add(campoCpfCliente);
        panel.add(rotuloCodigoAplicativo);
        panel.add(campoCodigoAplicativo);
        panel.add(rotuloMesFinal);
        panel.add(campoMesFinal);
        panel.add(rotuloAnoFinal);
        panel.add(campoAnoFinal);
    
        // Usando FlowLayout com alinhamento à esquerda para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoesPanel.add(botaoSalvar);
        botoesPanel.add(botaoFechar);
    
        // Adicionando o painel de botões ao painel principal
        panel.add(botoesPanel);
    
        getContentPane().add(panel);
    }


    private void cancelarAssinatura() {
        String cpfCliente = campoCpfCliente.getText();
        int codigoAplicativo = Integer.parseInt(campoCodigoAplicativo.getText());
        String mesFinal = campoMesFinal.getText();
        String anoFinal = campoAnoFinal.getText();
    
        Assinatura assinatura = catalogoAssinaturas.getAssinaturaPorCPFECodigoApp(cpfCliente, codigoAplicativo);
    
        if (assinatura != null) {
            
            assinatura.setMesFimVigencia(mesFinal);
            assinatura.setAnoFimVigencia(anoFinal);

            catalogoAssinaturas.removerAssinatura(assinatura);
    
            catalogoAssinaturas.saveToFile(); // Salva as alterações no arquivo
            paginaAssinaturas.criarEAtualizarTabela(); // Atualiza a tabela na página principal
            JOptionPane.showMessageDialog(this, "Assinatura cancelada.");
            dispose(); // Fecha a janela de Cancelar
        } else {
            JOptionPane.showMessageDialog(this, "Assinatura não encontrada em nosso sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaAssinaturas paginaAssinaturas = new PaginaAssinaturas(null); // Substitua `null` pela instância correta se necessário
            CancelarAssinatura Cancelar = new CancelarAssinatura(paginaAssinaturas);
            Cancelar.setLocationRelativeTo(paginaAssinaturas);
            Cancelar.setVisible(true);
        });
    }
}
