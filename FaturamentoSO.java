import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicativos.*;

public class FaturamentoSO extends JDialog {
  private CatalogoAplicativos catalogoAplicativos;
  private PaginaAplicativos paginaAplicativos;

  double faturamentoIOS = catalogoAplicativos.mostraFaturamentoIOS();
  double faturamentoAndroid = catalogoAplicativos.mostraFaturamentoAndroid();

  public FaturamentoSO(PaginaAplicativos parent) {
    super(parent, "Faturamento SO Aplicativos", Dialog.ModalityType.APPLICATION_MODAL);
    this.paginaAplicativos = parent;
    this.catalogoAplicativos = parent.getCatalogoAplicativos();
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
    JLabel labelIOS = new JLabel("Faturamento por IOS: R$" + faturamentoIOS);
    JLabel labelAndroid = new JLabel("Faturamento por Android: R$" + faturamentoAndroid);

    JButton botaoFechar = new JButton("Fechar");
    botaoFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });

    add(labelIOS);
    add(labelAndroid);
    add(botaoFechar, BorderLayout.SOUTH);
  }
    private void adicionarComponentes() {
    // Adicione os componentes à janela aqui
    }


  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        PaginaAplicativos paginaAplicativos = new PaginaAplicativos(null); // Substitua `null` pela instância correta se necessário
        FaturamentoSO faturamentoSO = new FaturamentoSO(paginaAplicativos);
        faturamentoSO.setLocationRelativeTo(paginaAplicativos);
        faturamentoSO.setVisible(true);
    });
  }
}



