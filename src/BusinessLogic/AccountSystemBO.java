/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brucelee Thanh
 */
public class AccountSystemBO extends SqlConnection{

    public List<AccountSystemDA> SelectAll() {
        List<AccountSystemDA> aListAccountSystemDA = new ArrayList<AccountSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AccountSystemDA aAccountSystemDA = new AccountSystemDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListAccountSystemDA.add(aAccountSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAccountSystemDA;
    }

    public List<AccountSystemDA> Select_ByIDAccountSystem(int IDAccountSystem) {
        List<AccountSystemDA> aListAccountSystemDA = new ArrayList<AccountSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Select_ByIDAccountSystem(?)}");
            call.setInt(1, IDAccountSystem);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AccountSystemDA aAccountSystemDA = new AccountSystemDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListAccountSystemDA.add(aAccountSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAccountSystemDA;
    }

    public List<AccountSystemDA> Select_ByIDUserSystem(int IDUserSystem) {
        List<AccountSystemDA> aListAccountSystemDA = new ArrayList<AccountSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Select_ByIDUserSystem(?)}");
            call.setInt(1, IDUserSystem);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AccountSystemDA aAccountSystemDA = new AccountSystemDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListAccountSystemDA.add(aAccountSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAccountSystemDA;
    }

    public List<AccountSystemDA> Select_ByUsername_ByPassword(String Username, String Password) {
        List<AccountSystemDA> aListAccountSystemDA = new ArrayList<AccountSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Select_ByUserName_ByPassword(?,?)}");
            call.setString(1, Username);
            call.setString(2, Password);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                AccountSystemDA aAccountSystemDA = new AccountSystemDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListAccountSystemDA.add(aAccountSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListAccountSystemDA;
    }

    public boolean Insert(AccountSystemDA aAccountSystemDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Insert(?,?,?)}");
            call.setInt(1, aAccountSystemDA.getIDUserSystem());
            call.setString(2, aAccountSystemDA.getUsername());
            call.setString(3, aAccountSystemDA.getPassword());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(AccountSystemDA aAccountSystemDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Update(?,?,?,?)}");
            call.setInt(1, aAccountSystemDA.getIDAccountSystem());
            call.setInt(2, aAccountSystemDA.getIDUserSystem());
            call.setString(3, aAccountSystemDA.getUsername());
            call.setString(4, aAccountSystemDA.getPassword());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(AccountSystemDA aAccountSystemDA){
        try {
            CallableStatement call = conn.prepareCall("{call spd_AccountSystem_Delete(?)}");
            call.setInt(1, aAccountSystemDA.getIDAccountSystem());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
