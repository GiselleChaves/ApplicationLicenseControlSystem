import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaAssinaturas extends JFrame {
    private MenuLateral menuAssinaturas;
    private PainelCompartilhado painelConteudoCompartilhado;

    public PaginaAssinaturas() {
        configurarJanela();

        criarMenuAssinaturas();
        criarPainelConteudo();

        adicionarComponentes();
        exibirJanela();
    }

    private void configurarJanela() {
        setTitle("Assinaturas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton botao1 = menuAssinaturas.criarBotao("Mostrar Assinaturas", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(rotuloTitulo);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao1);
    }

    private void adicionarComponentes() {
        add(menuAssinaturas, BorderLayout.WEST);
    }

    private void exibirJanela() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaginaClientes();
            }
        });
    }
}
