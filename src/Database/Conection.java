package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Frank Paucar
 */
public class Conection {
    
    public Connection con = null;
    public Statement st = null;
    public ResultSet rs = null;
    protected String user, psw, db, host, url;

    public Conection(String user, String psw, String db, String host) {

        this.user = user;
        this.psw = psw;
        this.db = db;
        this.host = host;

        try {

            url = "jdbc:mysql://" + this.host + "/" + this.db; // for Mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, this.user, psw);
            System.out.println("Successfully connected to database " + this.db);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error in the connection\n" + e);
        }

    }
    
}
