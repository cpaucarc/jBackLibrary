package Database;

import Component.TableModel;
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
public class Controller extends Conection{
    
    public Controller(String user, String psw, String db, String host) {
        super(user, psw, db, host);
    }

    public Connection getConnection() throws NullPointerException{
        try {
            return this.con;
        } catch (Exception e) {
            throw new NullPointerException("It's not connected to database");
        }
    }

    public ResultSet ReturnRow(String sql) throws SQLException {
        try {
            st = this.con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public String getData(String sql, int pos) throws SQLException {
        try {
            rs = ReturnRow(sql);
            if (rs.next())
                return rs.getString(pos);
            return "No data";
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public String[] getColumnData(String sql) throws SQLException {
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
            throw new SQLException(e);
        }
    }

    public String[] getRowData(String sql, int num) throws SQLException {
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
            throw new SQLException(e);
        }
    }

    public ArrayList<String> getData(String sql) throws SQLException {
        try {
            ArrayList<String> data = new ArrayList<>();
            rs = ReturnRow(sql);
            while (rs.next()) {
                data.add(rs.getString(1));
            }
            return data;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void clearTable(TableModel model) {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void fillTable(TableModel model, String sql, int size) throws SQLException {
        String[] data = new String[size];
        clearTable(model);
        rs = ReturnRow(sql);
        while (rs.next()) {
            for (int i = 0; i < size; i++) {
                data[i] = rs.getString((i + 1));
            }
            model.addRow(data);
        }
    }

    private void Sub_FillCombo(JComboBox combo, String sql, int pos) throws SQLException {
        combo.removeAllItems();
        rs = ReturnRow(sql);
        combo.addItem("Select...");
        while (rs.next()) {
            combo.addItem(rs.getString(pos));
        }
    }

    public void fillCombo(JComboBox combo, String sql, int pos) throws SQLException {
        Sub_FillCombo(combo, sql, pos);
        if (combo.getItemCount() == 1) {
            combo.removeAllItems();
            combo.addItem("No data");
        }
        combo.setSelectedIndex(0);
    }

    public void fillList(DefaultListModel<String> model, String sql, int pos) throws SQLException {
        try {
            model.clear();
            rs = ReturnRow(sql);
            while (rs.next()) {
                model.addElement(rs.getString(pos));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public boolean existInDB(String sql) throws SQLException{
        try {
            rs = ReturnRow(sql);
            return rs.next();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void executeQuery(String sql) throws SQLException{
        try {
            st = this.con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
