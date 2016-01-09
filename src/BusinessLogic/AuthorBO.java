/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.*;
import java.sql.Date;
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
public class AuthorBO extends SqlConnection{
    
    public List<AuthorDA> SelectAll(){
        List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Author_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorDA aAuthorDA = new AuthorDA (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                aListAuthorDA.add(aAuthorDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorDA;
    }
    
    public List<AuthorDA> Select_ByIDAuthor(int IDAuthor){
        List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Author_Select_ByIDAuthor(?)}");
            call.setInt(1, IDAuthor);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorDA aAuthorDA = new AuthorDA (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                aListAuthorDA.add(aAuthorDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorDA;
    }
    
    public List<AuthorDA> Select_ByName_Pseudonym(String Input){
        List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Author_Select_ByName_Pseudonym(?)}");
            call.setString(1, Input);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AuthorDA aAuthorDA = new AuthorDA (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                aListAuthorDA.add(aAuthorDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAuthorDA;
    }
    
    public boolean Insert(AuthorDA aAuthorDA){
        try {
            Date Birthday = new Date(aAuthorDA.getBirthday().getTime());
            CallableStatement call = conn.prepareCall("{call spd_Author_Insert(?,?,?,?,?,?)}");
            call.setString(1, aAuthorDA.getName());
            call.setString(2, aAuthorDA.getPseudonym());
            call.setBoolean(3, aAuthorDA.isGender());
            call.setDate(4, Birthday);
            call.setString(5, aAuthorDA.getAddress());
            call.setString(6, aAuthorDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(AuthorDA aAuthorDA) {
        try {
            Date Birthday = new Date(aAuthorDA.getBirthday().getTime());
            CallableStatement call = conn.prepareCall("{call spd_Author_Update(?,?,?,?,?,?,?)}");
            call.setInt(1, aAuthorDA.getIDAuthor());
            call.setString(2, aAuthorDA.getName());
            call.setString(3, aAuthorDA.getPseudonym());
            call.setBoolean(4, aAuthorDA.isGender());
            call.setDate(5, Birthday);
            call.setString(6, aAuthorDA.getAddress());
            call.setString(7, aAuthorDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(AuthorDA aAuthorDA){
        try {
            CallableStatement call = conn.prepareCall("{call spd_Author_Delete(?)}");
            call.setInt(1, aAuthorDA.getIDAuthor());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

