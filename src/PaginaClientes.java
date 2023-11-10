import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaClientes extends JFrame {
    private MenuLateral menuClientes;
    private PainelCompartilhado painelConteudoCompartilhado;

    public PaginaClientes() {
        configurarJanela();

        criarMenuClientes();
        criarPainelConteudo();

        adicionarComponentes();
        criarEAtualizarTabela();

        exibirJanela();
    }

    private void configurarJanela() {
        setTitle("Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        add(painelConteudoCompartilhado, BorderLayout.CENTER);
    }

    private void criarMenuClientes() {
        menuClientes = new MenuLateral();

        JLabel rotuloTitulo = new JLabel("MENU");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botao1 = menuClientes.criarBotao("Cadastrar Cliente", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ação para CLIENTES");
            }
        });

        JButton botao2 = menuClientes.criarBotao("Editar Cliente", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton botao3 = menuClientes.criarBotao("Mostrar Clientes", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton botao4 = menuClientes.criarBotao("Mostrar Assinaturas", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        menuClientes.adicionarEspacamento(20);
        menuClientes.add(rotuloTitulo);
        menuClientes.adicionarEspacamento(20);
        menuClientes.add(botao1);
        menuClientes.adicionarEspacamento(10);
        menuClientes.add(botao2);
        menuClientes.adicionarEspacamento(10);
        menuClientes.add(botao3);
        menuClientes.adicionarEspacamento(10);
        menuClientes.add(botao4);
    }

    private void adicionarComponentes() {
        add(menuClientes, BorderLayout.WEST);
    }

    private void exibirJanela() {
        setVisible(true);
    }

    private void criarEAtualizarTabela() {
       
        CatalogoClientes catalogoClientes = new CatalogoClientes();
        catalogoClientes.loadFromFile();
        CatalogoClientesViewModel modeloTabela = new CatalogoClientesViewModel(catalogoClientes);
    
        JTable tabelaClientes = new JTable(modeloTabela);
    
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);

        painelConteudoCompartilhado.removeAll();
    
        painelConteudoCompartilhado.add(scrollPane, BorderLayout.CENTER);
    
        painelConteudoCompartilhado.revalidate();
        painelConteudoCompartilhado.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaginaClientes();
            }
        });
    }
}
