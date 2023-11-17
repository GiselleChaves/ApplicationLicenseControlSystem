import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class PaginaAssinaturas extends JDialog {
    private MenuLateral menuAssinaturas;
    private PainelCompartilhado painelConteudoCompartilhado;
    private GerenciarAssinaturas gerenciarAssinaturas;

    //CATALOGOS
    CatalogoAssinaturas catalogoAssinaturas;
    CatalogoClientes catalogoClientes;
    CatalogoAplicativos catalogoAplicativos;

    private Home parentHome; 

    public PaginaAssinaturas(Home parent) {
        super(parent, "Assinaturas", Dialog.ModalityType.APPLICATION_MODAL);
        this.   parentHome = parent;
        
        catalogoAssinaturas = parent.getCatalogoAssinaturas();
        catalogoClientes = parent.getCatalogoClientes();
        catalogoAplicativos = parent.getCatalogoAplicativos();
        
        configurarJanela();
        criarMenuAssinaturas();
        criarPainelConteudo();
        adicionarComponentes();
        criarEAtualizarTabela();
    }

    public CatalogoAssinaturas getCatalogoAssinaturas() {
        return catalogoAssinaturas;
    }

    public CatalogoClientes getCatalogoClientes() {
        return catalogoClientes;
    }

    public CatalogoAplicativos getCatalogoAplicativos() {
        return catalogoAplicativos;
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

        JButton botao1 = menuAssinaturas.criarBotao("Cadastrar Assinatura", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroAssinatura();
            }
        });

        JButton botao2 = menuAssinaturas.criarBotao("Cancelar Assinatura", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCancelarAssinatura();
            }
        });

        JButton botao3 = menuAssinaturas.criarBotao("Pagamentos em Aberto", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //IMPLEMENTAR
                /*Gerar uma lista com os clientes que devem ser cobrados no mês corrente.
                Para cada cliente listar o nome, o email e o valor a ser cobrado (depende da quantidade de assinaturas do cliente)*/
            }
        });

        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(rotuloTitulo);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao1);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao2);
        menuAssinaturas.adicionarEspacamento(20);
        menuAssinaturas.add(botao3);
    }

    private void adicionarComponentes() {
        add(menuAssinaturas, BorderLayout.WEST);
    }

    public void criarEAtualizarTabela() {       
        CatalogoAssinaturas catalogoAssinaturas = new CatalogoAssinaturas();
        catalogoAssinaturas.loadFromFile();
        CatalogoAssinaturasViewModel modeloTabela = new CatalogoAssinaturasViewModel(catalogoAssinaturas);
    
        JTable tabelaAssinaturas = new JTable(modeloTabela);
    
        JScrollPane scrollPane = new JScrollPane(tabelaAssinaturas);

        painelConteudoCompartilhado.removeAll();
    
        painelConteudoCompartilhado.add(scrollPane, BorderLayout.CENTER);
    
        painelConteudoCompartilhado.revalidate();
        painelConteudoCompartilhado.repaint();
    }

    
    /*private void exibirGerenciarAssinaturas() {
        gerenciarAssinaturas = new GerenciarAssinaturas(this);
        gerenciarAssinaturas.setVisible(true);
    }*/

    //Opções

    //Cadastrar assinatura.
    private void abrirJanelaCadastroAssinatura() {
        CadastroAssinatura cadastro = new CadastroAssinatura(this);
        cadastro.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        cadastro.setVisible(true);
    }
    //Cancelar assinatura.
    private void abrirJanelaCancelarAssinatura() {
        CancelarAssinatura cancelar = new CancelarAssinatura(this);
        cancelar.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        cancelar.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home home = new Home(); // Altere para Home ao invés de JFrame
            new PaginaAssinaturas(home);
        });
    }
}
