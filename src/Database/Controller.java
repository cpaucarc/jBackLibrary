package Database;

import ui.TableModel;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author Frank Paucar
 */
public class Controller extends Conection {

    public Controller(String user, String psw, String db, String host) {
        super(user, psw, db, host);
    }
    
    public Controller(File envFile) {
        super(envFile);
    }
    
    public Connection getConnection() {
        try {
            return this.con;
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet ReturnRow(String sql) {
        try {
            st = this.con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

    public String getData(String sql, int pos) {
        try {
            rs = ReturnRow(sql);
            if (rs.next()) {
                return rs.getString(pos);
            }
            return "No data";
        } catch (SQLException e) {
            return null;
        }
    }

    public String[] getColumnData(String sql) {
        try {
            List<String> dataList = new ArrayList<>();
            rs = ReturnRow(sql);

            while (rs.next()) {
                dataList.add(rs.getString(1));
            }

            String[] data = new String[dataList.size()];
            dataList.toArray(data);
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public String[] getRowData(String sql, int num) {
        try {
            String[] data = new String[num];
            rs = ReturnRow(sql);
            if (rs.next()) {
                for (int i = 0; i < num; i++) {
                    data[i] = rs.getString(i + 1);
                }
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> getData(String sql) {
        try {
            ArrayList<String> data = new ArrayList<>();
            rs = ReturnRow(sql);
            while (rs.next()) {
                data.add(rs.getString(1));
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public void clearTable(TableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void fillTable(TableModel model, String sql, int size) {
        String[] data = new String[size];
        clearTable(model);
        try {
            rs = ReturnRow(sql);
            while (rs.next()) {
                for (int i = 0; i < size; i++) {
                    data[i] = rs.getString((i + 1));
                }
                model.addRow(data);
            }
        } catch (SQLException e) {
        }
    }

    private void Sub_FillCombo(JComboBox combo, String sql, int pos) {
        combo.removeAllItems();
        try {
            rs = ReturnRow(sql);
            combo.addItem("Select...");
            while (rs.next()) {
                combo.addItem(rs.getString(pos));
            }
        } catch (SQLException e) {
        }
    }

    public void fillCombo(JComboBox combo, String sql, int pos) {
        Sub_FillCombo(combo, sql, pos);
        if (combo.getItemCount() == 1) {
            combo.removeAllItems();
            combo.addItem("No data");
        }
        combo.setSelectedIndex(0);
    }

    public void fillList(DefaultListModel<String> model, String sql, int pos) {
        try {
            model.clear();
            rs = ReturnRow(sql);
            while (rs.next()) {
                model.addElement(rs.getString(pos));
            }
        } catch (SQLException e) {
        }
    }

    public boolean existInDB(String sql){
        try {
            rs = ReturnRow(sql);
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public void executeQuery(String sql){
        try {
            st = this.con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
}
