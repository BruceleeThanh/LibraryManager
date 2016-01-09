/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.*;
import java.sql.CallableStatement;
import java.sql.Date;
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
public class AuthorBookBO extends SqlConnection {

    public List<AuthorBookDA> SelectAll() {
        List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorBookDA aAuthorBookDA = new AuthorBookDA(rs.getInt(1), rs.getInt(2));
                aListAuthorBookDA.add(aAuthorBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorBookDA;
    }

    public List<AuthorBookDA> Select_ByIDBook_ByIDAuthor(int IDBook, int IDAuthor) {
        List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Select_ByIDBook_ByIDAuthor(?,?)}");
            call.setInt(1, IDBook);
            call.setInt(2, IDAuthor);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorBookDA aAuthorBookDA = new AuthorBookDA(rs.getInt(1), rs.getInt(2));
                aListAuthorBookDA.add(aAuthorBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorBookDA;
    }
    
    public List<AuthorBookDA> Select_ByIDBook(int IDBook) {
        List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Select_ByIDBook(?)}");
            call.setInt(1, IDBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorBookDA aAuthorBookDA = new AuthorBookDA(rs.getInt(1), rs.getInt(2));
                aListAuthorBookDA.add(aAuthorBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorBookDA;
    }
    
    public List<AuthorBookDA> Select_ByIDAuthor(int IDAuthor) {
        List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Select_ByIDBook_ByIDAuthor(?)}");
            call.setInt(1, IDAuthor);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorBookDA aAuthorBookDA = new AuthorBookDA(rs.getInt(1), rs.getInt(2));
                aListAuthorBookDA.add(aAuthorBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorBookDA;
    }

    public boolean Insert(AuthorBookDA aAuthorBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Insert(?,?)}");
            call.setInt(1, aAuthorBookDA.getIDBook());
            call.setInt(2, aAuthorBookDA.getIDAuthor());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Update(AuthorBookDA aAuthorBookDA_Old, AuthorBookDA aAuthorBookDA_New) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Update(?,?,?,?)}");
            call.setInt(1, aAuthorBookDA_Old.getIDBook());
            call.setInt(2, aAuthorBookDA_Old.getIDAuthor());
            call.setInt(3, aAuthorBookDA_New.getIDBook());
            call.setInt(4, aAuthorBookDA_New.getIDAuthor());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(AuthorBookDA aAuthorBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_AuthorBook_Delete(?,?)}");
            call.setInt(1, aAuthorBookDA.getIDBook());
            call.setInt(2, aAuthorBookDA.getIDAuthor());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
