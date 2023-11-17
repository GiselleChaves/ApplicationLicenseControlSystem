package assinaturas;

import clientes.*;
import aplicativos.*;

import javax.swing.table.AbstractTableModel;

public class CatalogoAssinaturasViewModel extends AbstractTableModel {
    private CatalogoAssinaturas assinaturas;
    private final String[] nomesDasColunas = {
        "Codigo",
        "Codigo App",
        "CPF Cliente",
        "Mes Inicio",
        "Ano Inicio"
    };

    public CatalogoAssinaturasViewModel(CatalogoAssinaturas Assinaturas) {
        this.assinaturas = Assinaturas;
    }
    

    public String getColumnName(int col) {
        return nomesDasColunas[col];
    }

    //Conferir se getCont era quantidade
    public int getRowCount() {
        return assinaturas.getContAssinaturas();
    }

    public int getColumnCount() {
        return nomesDasColunas.length;
    }

    public Object getValueAt(int row, int col) {
        Assinatura assinatura = assinaturas.getAssinaturaNaLinha(row);
        switch (col) {
            case 0: return (Object) (assinatura.getCodigoAssinatura());
            case 1: return (Object) (assinatura.getCodigoApp());
            case 2: return (Object) (assinatura.getCpfCliente());
            case 3: return (Object) (assinatura.getMesInicioVigencia());
            case 4: return (Object) (assinatura.getAnoInicioVigencia());
            default: return (Object) "none";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        // Não será acionado porque isCellEditable retorna false para todas as celulas
        // Se possível é necessário colocar o dado no catálogo de Assinaturas
        // Indicar a alteração acionando: fireTableCellUpdated(row, col);
    }
}
