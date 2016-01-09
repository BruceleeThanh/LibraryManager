/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.LibraryDA;
import DataAccess.SqlConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brucelee Thanh
 */
public class LibraryBO extends SqlConnection {
    public List<LibraryDA> SelectAll() {
        List<LibraryDA> aListLibraryDA = new ArrayList<LibraryDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Library_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                LibraryDA aLibraryDA = new LibraryDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBytes(5), rs.getString(6));
                aListLibraryDA.add(aLibraryDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListLibraryDA;
    }
    
    public boolean Insert(LibraryDA aLibraryDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Library_Insert(?,?,?,?,?)}");
            call.setString(1, aLibraryDA.getName());
            call.setString(2, aLibraryDA.getAddress());
            call.setString(3, aLibraryDA.getPhoneNumber());
            call.setBytes(4, aLibraryDA.getImage());
            call.setString(5, aLibraryDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(LibraryDA aLibraryDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Library_Update(?,?,?,?,?,?)}");
            call.setInt(1, aLibraryDA.getIDLibrary());
            call.setString(2, aLibraryDA.getName());
            call.setString(3, aLibraryDA.getAddress());
            call.setString(4, aLibraryDA.getPhoneNumber());
            call.setBytes(5, aLibraryDA.getImage());
            call.setString(6, aLibraryDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(LibraryDA aLibraryDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Library_Delete(?)}");
            call.setInt(1, aLibraryDA.getIDLibrary());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
