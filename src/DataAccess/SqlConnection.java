/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brucelee Thanh
 */
public class SqlConnection {
    
    public Connection conn;
    
    public SqlConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;user=sa;password=123456;databaseName=LibrarianProject";
            conn = DriverManager.getConnection(url);
            //java.sql.Statement stnt = conn.createStatement();
        } catch (SQLException se){
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet ExcuteQuery(String query) {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public int ExcuteNoneQuery(String query) {
        int result = 0;
        try {
            Statement st = conn.createStatement();
            result = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = -1;
        }
        return result;
    }
    
    public void Close() throws SQLException
    {
        conn.close();
    }
    
}
