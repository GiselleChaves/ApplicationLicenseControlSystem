import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import aplicativos.*;

public class FaturamentoTotal extends JDialog {
  private CatalogoAplicativos catalogoAplicativos;
  private PaginaAplicativos paginaAplicativos;

  double faturamentoTotal = catalogoAplicativos.mostraFaturamentoTotal();

  public FaturamentoTotal(PaginaAplicativos parent) {
    super(parent, "Faturamento Total", Dialog.ModalityType.APPLICATION_MODAL);
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
    JLabel labelTotal = new JLabel("Faturamento Total: R$" + faturamentoTotal);

    JButton botaoFechar = new JButton("Fechar");
    botaoFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });

    add(labelTotal);
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



