import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class MenuLateral extends JPanel {
    public MenuLateral() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    }

    public JButton criarBotao(String texto, ActionListener actionListener) {
        JButton botao = new JButton(texto);
        botao.setAlignmentX(Component.LEFT_ALIGNMENT);

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(200, 200, 200));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(UIManager.getColor("control"));
            }
        });

        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.addActionListener(actionListener);

        return botao;
    }

    public void adicionarEspacamento(int tamanho) {
        add(Box.createRigidArea(new Dimension(0, tamanho)));
    }

    public void adicionarComponenteComEspacamento(JComponent componente) {
        add(componente);
        adicionarEspacamento(10);
    }
}
