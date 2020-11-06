/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Frank Paucar
 */
public class Tables {

    private static final Color MY_BLUE = new Color(38, 117, 191);
    private static final Color MY_BLACK = new Color(47, 46, 65);
    private static final Color MY_WHITE = new Color(255, 255, 255);

    public static void setModel(JTable table, TableModel tm, String[] columnNames) {
        tm.setColumnIdentifiers(columnNames);
        table.setModel(tm);
    }

    public static Object searchDataInTable(JTable table, int columnSearch, Object data, int columnReturn) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (data == table.getValueAt(i, columnSearch)) {
                if (columnReturn != -1) {
                    return table.getValueAt(i, columnReturn);
                } else {
                    return i;
                }
            }
        }
        return null;
    }

    public static Object getDataFromSelectedRow(JTable table, int columnData) {
        return table.getValueAt(table.getSelectedRow(), columnData);
    }

    public static boolean existDataInTable(JTable table, Object data, int columnSearch) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (data == table.getValueAt(i, columnSearch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ***************** UI *****************
     */
    private static void CenterTableHeader(JTable table) {
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    private static void CenterBodyTable(JTable table) {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        int columns = table.getColumnCount(), i = 0;
        while (i < columns) {
            table.getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
            table.getTableHeader().getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
            i++;
        }
    }

    public static void setRightAlignmentToColumn(JTable table, int column) {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(column).setCellRenderer(tableCellRenderer);
        table.getTableHeader().getColumnModel().getColumn(column).setCellRenderer(tableCellRenderer);
    }

    public static void setRightAlignmentToColumns(JTable table, int... columns) {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int column : columns) {
            table.getColumnModel().getColumn(column).setCellRenderer(tableCellRenderer);
            table.getTableHeader().getColumnModel().getColumn(column).setCellRenderer(tableCellRenderer);
        }
    }

    private static void settingTable(JTable table, Color headColor, Color headTextColor, Color selectColor, Color selectTextColor, int heightRow, boolean center, int size) {
        //TableHead
        table.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, size));
        table.getTableHeader().setBackground(headColor);
        table.getTableHeader().setForeground(headTextColor);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //Table
        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Segoe UI", 0, size)); // NOI18N
        table.setForeground(MY_BLACK);
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setRowHeight(heightRow);
        table.setSelectionBackground(selectColor);
        table.setSelectionForeground(selectTextColor);
        table.setGridColor(MY_WHITE);
        table.setShowVerticalLines(false);
        //Center table content
        if (center) {
            CenterBodyTable(table);
            CenterTableHeader(table);
        }
    }

    private static Color fontColor(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return (r + g + b) < 400 ? MY_WHITE : MY_BLACK;
    }

    public static void Dark(JTable table) {
        settingTable(table, MY_BLACK, MY_WHITE, MY_BLUE, MY_WHITE, 27, true, 13);
    }

    public static void Dark(JTable table, int height, boolean centered, int size) {
        settingTable(table, MY_BLACK, MY_WHITE, MY_BLUE, MY_WHITE, height, centered, size);
    }

    public static void Light(JTable table) {
        settingTable(table, MY_WHITE, MY_BLACK, MY_BLUE, MY_WHITE, 27, true, 13);
    }

    public static void Light(JTable table, int height, boolean centered, int size) {
        settingTable(table, MY_WHITE, MY_BLACK, MY_BLUE, MY_WHITE, height, centered, size);
    }

    public static void DarkCustom(JTable table, Color selectColor) {
        settingTable(table, MY_BLACK, MY_WHITE, selectColor, fontColor(selectColor), 27, true, 13);
    }

    public static void TableCustom(JTable table, Color headColor, Color headTextColor, Color selectColor, Color selectTextColor, int heightRow, boolean center, int size) {
        settingTable(table, headColor, headTextColor, selectColor, selectTextColor, heightRow, center, size);
    }

    public static void HideColumn(JTable table, int column) {
        table.getColumnModel().getColumn(column).setMaxWidth(0);
        table.getColumnModel().getColumn(column).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(column).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(column).setMinWidth(0);
    }

    public static void HideColumns(JTable table, int... columns) {
        for (int column : columns) {
            HideColumn(table, column);
        }
    }

    public static void WidthColumns(JTable table, int width, int... columns) {
        for (int column : columns) {
            table.getColumnModel().getColumn(column).setMaxWidth(width);
            table.getColumnModel().getColumn(column).setMinWidth(width);
            table.getTableHeader().getColumnModel().getColumn(column).setMaxWidth(width);
            table.getTableHeader().getColumnModel().getColumn(column).setMinWidth(width);

//            table.getColumnModel().getColumn(column).setWidth(width);
//            table.getColumnModel().getColumn(column).setPreferredWidth(width);
        }
    }
}
