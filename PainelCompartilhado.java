import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.net.URL;

import clientes.*;
import assinaturas.*;
import aplicativos.*;

public class PainelCompartilhado extends JPanel {
    private JLabel rotuloConteudo;

    public PainelCompartilhado() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        rotuloConteudo = new JLabel();
        rotuloConteudo.setHorizontalAlignment(SwingConstants.CENTER);
        add(rotuloConteudo, BorderLayout.CENTER);
    }

    public void atualizarConteudo(String texto) {
        rotuloConteudo.setText(texto);
    }

    public void atualizarImagem(String caminho) {
        ImageIcon icone = criarIconeImagem(caminho);
        if (icone != null) {
            Image imagemOriginal = icone.getImage();
            Image imagemRedimensionada = imagemOriginal.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon iconeRedimensionado = new ImageIcon(imagemRedimensionada);
            rotuloConteudo.setIcon(iconeRedimensionado);
        } else {
            rotuloConteudo.setIcon(null);
        }
    }

    protected ImageIcon criarIconeImagem(String caminho) {
        URL imgURL = getClass().getResource(caminho);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Arquivo de imagem não encontrado: " + caminho);
            return null;
        }
    }
}