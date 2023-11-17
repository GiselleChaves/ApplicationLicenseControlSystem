import javax.swing.*;

import clientes.*;
import aplicativos.*;
import assinaturas.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaAplicativos extends JDialog {
    private MenuLateral menuAplicativos;
    private PainelCompartilhado painelConteudoCompartilhado;
    private Home parentHome; 

    //CATALOGOS 
    private CatalogoAplicativos catalogoAplicativos;

    public PaginaAplicativos(Home parent) {
        super(parent, "Aplicativos", Dialog.ModalityType.APPLICATION_MODAL);
        this.parentHome = parent;

        catalogoAplicativos = parent.getCatalogoAplicativos();

        configurarJanela();

        criarMenuAplicativos();
        criarPainelConteudo();

        adicionarComponentes();
        criarEAtualizarTabela();
    }

    public CatalogoAplicativos getCatalogoAplicativos() {
        return catalogoAplicativos;
    }


    private void configurarJanela() {
        setTitle("Aplicativos");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
        setSize(600, 400);
        setLayout(new BorderLayout());
    }

    private void criarPainelConteudo() {
        painelConteudoCompartilhado = new PainelCompartilhado();
        add(painelConteudoCompartilhado, BorderLayout.CENTER); // Adicionando o PainelCompartilhado ao centro
    }

    private void criarMenuAplicativos() {
        menuAplicativos = new MenuLateral();
    
        JLabel rotuloTitulo = new JLabel("MENU APLICATIVOS");
        rotuloTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloTitulo.setFont(new Font("Arial", Font.BOLD, 18));
    
        JButton botao1 = menuAplicativos.criarBotao("Cadastrar Aplicativo", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroAplicativo();
            }
        });
    
        JButton botao2 = menuAplicativos.criarBotao("Editar Aplicativo", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaEditarAplicativo();
            }
        });

    
        JButton botao3 = menuAplicativos.criarBotao("Aplicativo: mostrar assinantes", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMensagem("IMPLEMENTAR");
            }
        });

        JButton botao4 = menuAplicativos.criarBotao("Aplicativo: mostrar faturamento", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMensagem("IMPLEMENTAR");
                /*Listar o faturamento com um determinado aplicativo no mês corrente (supondo que todos os que foram cobrados pagaram). */
            }
        });

        JButton botao5 = menuAplicativos.criarBotao("SO: mostrar faturamento", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMensagem("IMPLEMENTAR");
                /*Mostrar o faturamento por ios e por android */
            }
        });

        JButton botao6 = menuAplicativos.criarBotao("Faturamento total", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMensagem("IMPLEMENTAR");
                /*Mostrar a soma do faturamento de todos os aplicativos */
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
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao5);
        menuAplicativos.adicionarEspacamento(20);
        menuAplicativos.add(botao6);
    
    }    

    private void adicionarComponentes() {
        add(menuAplicativos, BorderLayout.WEST);
    }
    
    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    public void criarEAtualizarTabela() {
       
        CatalogoAplicativos catalogoAplicativos = new CatalogoAplicativos();
        catalogoAplicativos.loadFromFile();
        CatalogoAplicativosViewModel modeloTabela = new CatalogoAplicativosViewModel(catalogoAplicativos);
    
        JTable tabelaAplicativos = new JTable(modeloTabela);
    
        JScrollPane scrollPane = new JScrollPane(tabelaAplicativos);

        painelConteudoCompartilhado.removeAll();
    
        painelConteudoCompartilhado.add(scrollPane, BorderLayout.CENTER);
    
        painelConteudoCompartilhado.revalidate();
        painelConteudoCompartilhado.repaint();
    }

    //Cadastrar cliente.
    private void abrirJanelaCadastroAplicativo() {
        CadastroAplicativo  cadastro = new CadastroAplicativo(this);
        cadastro.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        cadastro.setVisible(true);
    }

    //Edtiar cliente
    private void abrirJanelaEditarAplicativo() {
        EditarAplicativo editar = new EditarAplicativo(this);
        editar.setLocationRelativeTo(this); // Define a localização relativa à janela pai
        editar.setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home home = new Home(); 
            new PaginaAplicativos(home);
        });
    }
}
gt