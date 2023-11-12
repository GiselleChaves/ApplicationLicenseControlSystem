import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private MenuLateral menuLateral;
    private PainelCompartilhado painelConteudoCompartilhado;

    public Home() {
        configurarJanelaPrincipal();

        criarPainelMenuLateral();
        criarPainelConteudo();

        adicionarComponentes();

        exibirJanela();
    }

    private void configurarJanelaPrincipal() {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelMenuLateral() {
        menuLateral = new MenuLateral();

        JLabel rotuloTitulo = new JLabel("MENU");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botao1 = menuLateral.criarBotao("CLIENTES", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //PaginaClientes paginaClientes = new PaginaClientes();
            }
        });

        JButton botao2 = menuLateral.criarBotao("APLICATIVOS", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //PaginaAplicativos paginaAplicativos = new PaginaAplicativos();
            }
        });

        JButton botao3 = menuLateral.criarBotao("ASSINATURAS", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //PaginaAssinaturas paginaAplicativos = new PaginaAssinaturas();
            }
        });

        menuLateral.adicionarEspacamento(20);
        menuLateral.add(rotuloTitulo);
        menuLateral.adicionarEspacamento(20);
        menuLateral.add(botao1);
        menuLateral.adicionarEspacamento(10);
        menuLateral.add(botao2);
        menuLateral.adicionarEspacamento(10);
        menuLateral.add(botao3);
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        painelConteudoCompartilhado.atualizarImagem("arquivosimagem.png");
        painelConteudoCompartilhado.setBorder(new EmptyBorder(40, 0, 0, 0));
    }

    private void adicionarComponentes() {
        add(menuLateral, BorderLayout.WEST);
        add(painelConteudoCompartilhado, BorderLayout.CENTER);
    }

    private void exibirJanela() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home();
            }
        });
    }
}