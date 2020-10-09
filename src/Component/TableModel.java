/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

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
