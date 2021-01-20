package ui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank Paucar
 */
public class TableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 40;
    }
    
}
