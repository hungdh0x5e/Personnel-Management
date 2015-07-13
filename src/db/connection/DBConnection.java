/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author HUNGUYEN
 */
public class DBConnection {

    private String url;
    private String driver;
    private String servername;
    private String database;
    private String user;
    private String pwd;
    private String port;
    private Connection connection;
//    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() {
        try {

            Properties p = new Properties();
            p.load(new FileInputStream("database.properties"));
            driver = p.getProperty("driver");
            servername = p.getProperty("servername");
            database = p.getProperty("database");
            user = p.getProperty("user");
            pwd = p.getProperty("password");
            port = p.getProperty("port");
            url = "jdbc:sqlserver://" + servername + ":" + port + ";databaseName=" + database;

//            System.out.println("get properties xong");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
            if (connection == null) {
                throw new NullPointerException("Can not connect to SQL server!");
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Error(IO): " + ex.toString() + "\n");
            JOptionPane.showMessageDialog(null, "Can not connect to server\n" + ex.toString() + ".\nPlease try again!", "ERROR!", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Class not found!\n");
            JOptionPane.showMessageDialog(null, "Can not connect to server" + ex.toString() + ".\nPlease try again!", "ERROR!", 0);
            return false;
        } catch (SQLException ex) {
            System.out.println("Error(SQL): " + ex.toString());
            JOptionPane.showMessageDialog(null, "Can not connect to server" + ex.toString() + ".\nPlease try again!", "ERROR!", 0);
            return false;
        }
    }

//    public ResultSet getData(String sqlCommand) {
//        try {
//            statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sqlCommand);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println("Error!\n" + ex.toString());
//            return null;
//        }
//    }
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
        }
    }

    public void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
        }
        close();
    }

    public void close(PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
        }
        close(ps);
    }

//    public static void main(String[] args) {
//        DBConnection d = new DBConnection();
//        boolean i = d.connect();
//        if(i){
//            System.out.println("thành công");
//        }
//    }
}
