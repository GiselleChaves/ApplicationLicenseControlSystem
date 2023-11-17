import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class PaginaClientes extends JDialog {
    private MenuLateral menuClientes;
    private PainelCompartilhado painelConteudoCompartilhado;

    //CATALOGOS
    private CatalogoClientes catalogoClientes;

    private Home parentHome; 

    public PaginaClientes(Home parent) {
        super(parent, "Clientes", Dialog.ModalityType.APPLICATION_MODAL);
        this.   parentHome = parent;

        catalogoClientes = parent.getCatalogoClientes();

        configurarJanela();
        criarMenuClientes();
        criarPainelConteudo();
        adicionarComponentes();
        criarEAtualizarTabela();
    }

    public CatalogoClientes getCatalogoClientes() {
        return catalogoClientes;
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Configuração válida para a operação padrão de fechamento
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        add(painelConteudoCompartilhado, BorderLayout.CENTER);
    }

    private void criarMenuClientes() {
        menuClientes = new MenuLateral();

        JLabel rotuloTitulo = new JLabel("MENU CLIENTE");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton botao1 = menuClientes.criarBotao("Cadastrar Cliente", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroCliente();
            }
        });

        JButton botao2 = menuClientes.criarBotao("Editar Cliente", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaEditarCliente();
            }
        });

        JButton botao3 = menuClientes.criarBotao("Mostrar Assinaturas", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        JButton botao4 = menuClientes.criarBotao("Cobranças", new ActionListener() {
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


    public void criarEAtualizarTabela() {
       
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

    ///Opções:

    //Cadastrar cliente.
    private void abrirJanelaCadastroCliente() {
        CadastroCliente cadastro = new CadastroCliente(this);
        cadastro.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        cadastro.setVisible(true);
    }

    //Edtiar cliente
    private void abrirJanelaEditarCliente() {
        EditarCliente editar = new EditarCliente(this);
        editar.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        editar.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home home = new Home(); // Altere para Home ao invés de JFrame
            new PaginaClientes(home);
        });
    }
}
