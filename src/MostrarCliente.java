import javax.swing.*;
import javax.swing.border.EmptyBorder;
import clientes.Cliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarCliente extends JDialog {

  private JTextField cpfField;
  private JTextField nomeField;
  private JTextField emailField;
  private PaginaClientes paginaClientes; 
  private Cliente cliente;

  public MostrarCliente(PaginaClientes parent, Cliente cliente) {
    super(parent, "Mostrar Cliente", Dialog.ModalityType.APPLICATION_MODAL);
    this.paginaClientes = parent;
    this.cliente = cliente;
    initComponents();
  }

  private void initComponents() {
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));

    JButton btnFechar = new JButton("Fechar");
    btnFechar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });

    panel.add(Box.createVerticalStrut(10));

    panel.add(btnFechar);

    getContentPane().add(panel);
}

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      // Substitua este cliente pelo cliente que deseja mostrar
      Cliente cliente = new Cliente(null);
      PaginaClientes paginaClientes = new PaginaClientes(null); // Substitua `null` pela instância correta se necessário
      MostrarCliente mostrarCliente = new MostrarCliente(paginaClientes, cliente);
      mostrarCliente.setLocationRelativeTo(null);
      mostrarCliente.setVisible(true);
    });
  }
}