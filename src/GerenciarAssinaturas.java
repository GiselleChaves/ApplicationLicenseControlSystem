import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class GerenciarAssinaturas extends JDialog {
    private MenuLateral menuAssinaturas;
    private PainelCompartilhado painelConteudoCompartilhado;

    public GerenciarAssinaturas(Frame parent, PaginaAssinaturas paginaAssinaturas) {
        super(parent, "Assinaturas", Dialog.ModalityType.APPLICATION_MODAL); 
        configurarJanela();

        criarMenuAssinaturas();
        criarPainelConteudo();

        adicionarComponentes();
    }

    public GerenciarAssinaturas(PaginaAssinaturas paginaAssinaturas) {
    }

    private void configurarJanela() {
        setTitle("Assinaturas");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        add(painelConteudoCompartilhado, BorderLayout.CENTER); 
    }

    private void criarMenuAssinaturas() {
        menuAssinaturas = new MenuLateral();

        JLabel rotuloTitulo = new JLabel("MENU");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botao1 = menuAssinaturas.criarBotao("Nova Assinatura", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        JButton botao2 = menuAssinaturas.criarBotao("Cancelar Assinatura", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(rotuloTitulo);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao1);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao2);
    }

    private void adicionarComponentes() {
        add(menuAssinaturas, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame home = new Home();
                new PaginaAssinaturas(home);
            }
        });
    }
}
