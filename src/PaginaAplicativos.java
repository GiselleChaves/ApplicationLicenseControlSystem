
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class PaginaAplicativos extends JFrame {
    private MenuLateral menuAplicativos;
    private PainelCompartilhado painelConteudoCompartilhado;

    public PaginaAplicativos() {
        configurarJanela();

        criarMenuAplicativos();
        criarPainelConteudo();

        adicionarComponentes();
        exibirJanela();
    }

    private void configurarJanela() {
        setTitle("Aplicativos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        add(painelConteudoCompartilhado, BorderLayout.CENTER); // Adicionando o PainelCompartilhado ao centro
    }

    private void criarMenuAplicativos() {
        menuAplicativos = new MenuLateral();

        JLabel rotuloTitulo = new JLabel("MENU");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botao1 = menuAplicativos.criarBotao("Cadastrar Aplicativo", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroAplicativo();
            }
        });

        JButton botao2 = menuAplicativos.criarBotao("Editar Aplicativo", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        JButton botao3 = menuAplicativos.criarBotao("Mostrar Aplicativos", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        JButton botao4 = menuAplicativos.criarBotao("Mostrar Assinantes do App", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(rotuloTitulo);
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao1);
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao2);
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao3);
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao4);

    }

    private void adicionarComponentes() {
        add(menuAplicativos, BorderLayout.WEST);
    }

    private void exibirJanela() {
        setVisible(true);
    }

    private void abrirJanelaCadastroAplicativo() {
        SwingUtilities.invokeLater(() -> {
            CadastroAplicativoFrame cadastroFrame = new CadastroAplicativoFrame();
            cadastroFrame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaginaClientes();
            }
        });
    }
}
