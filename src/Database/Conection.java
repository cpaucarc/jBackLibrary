package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Frank Paucar
 */
public class Conection {

    public Connection con = null;
    public Statement st = null;
    public ResultSet rs = null;
    protected String user, password, database, host;
    protected String url;

    // Connection using separate data
    public Conection(String user, String psw, String db, String host) {
        this.user = user;
        this.password = psw;
        this.database = db;
        this.host = host;

        tryConnect();
    }

    // Connection using a properties files
    public Conection(File envFile) {
        // File archivo = new File("database_info.properties");
        Properties prop;
        try {
            try (InputStream inputStream = new FileInputStream(envFile)) {
                prop = new Properties();
                prop.load(inputStream);
                
                this.database = prop.getProperty("database");
                this.password = prop.getProperty("password");
                this.host = prop.getProperty("host");
                this.user = prop.getProperty("user");
                
                tryConnect();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("I/O Error");
        }
    }

    private void tryConnect() {
        try {
            url = "jdbc:mysql://" + this.host + "/" + this.database; // for Mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, this.user, password);
            System.out.println("Successfully connected to database " + this.database);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println("Error in the connection\n" + e);
        }
    }

}
