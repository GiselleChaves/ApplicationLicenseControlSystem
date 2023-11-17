import javax.swing.*;

import aplicativos.CatalogoAplicativos;
import assinaturas.Assinatura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientes.*;

public class MostrarAssinaturas extends JDialog {
    private JTextField campoCpf;
    CatalogoAplicativos catalogoAplicativos;
    
    private Assinatura assinatura;
    //private CatalogoClientes catalogoClientes;
    private PaginaClientes paginaClientes;

    public MostrarAssinaturas(PaginaClientes parent) {
        super(parent, "Mostrar assinaturas do Cliente", Dialog.ModalityType.APPLICATION_MODAL);
        this.paginaClientes = parent;
        configurarJanela();
        criarComponentes();
        adicionarComponentes();
    }

    private void configurarJanela() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2, 10, 10));
    }

    private void criarComponentes() {
        campoCpf = new JTextField();

        JLabel rotuloCpf = new JLabel("CPF:");

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAssinaturas();
            }
        });

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(rotuloCpf);
        add(campoCpf);
        add(botaoBuscar);
        add(botaoCancelar);
    }

    private void adicionarComponentes() {
        // Adicione os componentes à janela aqui
    }

    private void mostrarAssinaturas() {
        try {
            String cpf = campoCpf.getText();
            
            Assinatura assinatura = catalogoAplicativos.getAssinaturaByCPF(cpf);
            
            if (assinatura != null) {
                assinatura.getCodigoApp();

                dispose(); // Fecha a janela de edição
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF válido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaginaClientes paginaClientes = new PaginaClientes(null); // Substitua `null` pela instância correta se necessário
            MostrarAssinaturas editar = new MostrarAssinaturas(paginaClientes);
            editar.setLocationRelativeTo(paginaClientes);
            editar.setVisible(true);
        });
    }
}