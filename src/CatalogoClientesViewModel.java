package Clientes;
import javax.swing.table.AbstractTableModel;

import CatalogoClientes;

public class CatalogoClientesViewModel extends AbstractTableModel {
    private CatalogoClientes clientes;
    private final String[] nomesDasColunas = {
        "Codigo",
        "Nome",
        "Email"
    };

    public CatalogoClientesViewModel(CatalogoClientes clientes) {
        this.clientes = clientes;
    }

    public String getColumnName(int col) {
        return nomesDasColunas[col];
    }

    public int getRowCount() {
        return clientes.getQtdade();
    }

    public int getColumnCount() {
        return nomesDasColunas.length;
    }

    public Object getValueAt(int row, int col) {
        Cliente cliente = clientes.getClienteNaLinha(row);
        switch (col) {
            case 0: return (Object) (cliente.getCodigo());
            case 1: return (Object) (cliente.getNome());
            case 2: return (Object) (cliente.getEmail());
            default: return (Object) "none";
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        // Não será acionado porque isCellEditable retorna false para todas as celulas
        // Se possível é necessário colocar o dado no catálogo de clientes
        // Indicar a alteração acionando: fireTableCellUpdated(row, col);
    }
}
