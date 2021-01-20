package ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Frank Paucar
 */
public class Tables implements UIEnv {

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

    private static void settingTable(JTable table, Color head, Color headText, Color select, Color selectText, int heightRow, boolean center, int fontSize) {
        //Table Head
        table.getTableHeader().setFont(new java.awt.Font(FONT_FAMILY, Font.BOLD, fontSize));
        table.getTableHeader().setBackground(head);
        table.getTableHeader().setForeground(headText);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        //Table
        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font(FONT_FAMILY, Font.PLAIN, fontSize));
        table.setForeground(UI_BLACK);
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setRowHeight(heightRow);
        table.setSelectionBackground(select);
        table.setSelectionForeground(selectText);
        table.setGridColor(UI_WHITE);
        table.setShowVerticalLines(false);
        //Center table content
        if (center) {
            CenterBodyTable(table);
            CenterTableHeader(table);
        }
    }

    private static Color foregroundColor(Color background) {
        int r = background.getRed();
        int g = background.getGreen();
        int b = background.getBlue();
        return (r + g + b) < 400 ? UI_WHITE : UI_BLACK;
    }

    // Dark header
    public static void dark(JTable table) {
        settingTable(table, UI_BLACK, UI_WHITE, UI_BLUE, UI_WHITE, DEFAULT_HEIGHT, true, FONT_NORMAL_SIZE);
    }

    public static void dark(JTable table, int height, boolean centered, int size) {
        settingTable(table, UI_BLACK, UI_WHITE, UI_BLUE, UI_WHITE, height, centered, size);
    }

    public static void darkCustom(JTable table, Color selectColor) {
        settingTable(table, UI_BLACK, UI_WHITE, selectColor, foregroundColor(selectColor), DEFAULT_HEIGHT, true, FONT_NORMAL_SIZE);
    }

    // Light header
    public static void light(JTable table) {
        settingTable(table, UI_WHITE, UI_BLACK, UI_BLUE, UI_WHITE, DEFAULT_HEIGHT, true, FONT_NORMAL_SIZE);
    }

    public static void light(JTable table, int height, boolean centered, int size) {
        settingTable(table, UI_WHITE, UI_BLACK, UI_BLUE, UI_WHITE, height, centered, size);
    }

    // Custom
    public static void tableFullCustom(JTable table, Color head, Color headText, Color select, Color selectText, int heightRow, boolean center, int fontSize) {
        settingTable(table, head, headText, select, selectText, heightRow, center, fontSize);
    }
}
