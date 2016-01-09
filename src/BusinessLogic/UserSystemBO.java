/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.SqlConnection;
import DataAccess.UserSystemDA;
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
public class UserSystemBO extends SqlConnection {
    
    public List<UserSystemDA> SelectAll() {
        List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                UserSystemDA aUserSystemDA = new UserSystemDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                aListUserSystemDA.add(aUserSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListUserSystemDA;
    }
    
    public List<UserSystemDA> Select_ByIDUserSystem(int IDUserSystem) {
        List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Select_ByIDUserSystem(?)}");
            call.setInt(1, IDUserSystem);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                UserSystemDA aUserSystemDA = new UserSystemDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                aListUserSystemDA.add(aUserSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListUserSystemDA;
    }
    
    public List<UserSystemDA> Select_ByName(String Name) {
        List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Select_ByName(?)}");
            call.setString(1, Name);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                UserSystemDA aUserSystemDA = new UserSystemDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                aListUserSystemDA.add(aUserSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListUserSystemDA;
    }
    
    public List<UserSystemDA> Select_ByIdentify_PhoneNumber(String Input) {
        List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Select_ByIdentify_PhoneNumber(?)}");
            call.setString(1, Input);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                UserSystemDA aUserSystemDA = new UserSystemDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                aListUserSystemDA.add(aUserSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListUserSystemDA;
    }
    
    public List<UserSystemDA> Select_ByPosition(String Position) {
        List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Select_ByPosition(?)}");
            call.setString(1, Position);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                UserSystemDA aUserSystemDA = new UserSystemDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                aListUserSystemDA.add(aUserSystemDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListUserSystemDA;
    }
    
    public boolean Insert(UserSystemDA aUserSystemDA) {
        try {
            Date Birthday = new Date(aUserSystemDA.getBirthday().getTime());
            Date JoinDate = new Date(aUserSystemDA.getJoinDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Insert(?,?,?,?,?,?,?,?)}");
            call.setString(1, aUserSystemDA.getName());
            call.setBoolean(2, aUserSystemDA.isGender());
            call.setDate(3, Birthday);
            call.setString(4, aUserSystemDA.getAddress());
            call.setString(5, aUserSystemDA.getIdentify());
            call.setString(6, aUserSystemDA.getPhoneNumber());
            call.setDate(7, JoinDate);
            call.setString(8, aUserSystemDA.getPosition());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(UserSystemDA aUserSystemDA) {
        try {
            Date Birthday = new Date(aUserSystemDA.getBirthday().getTime());
            Date JoinDate = new Date(aUserSystemDA.getJoinDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Update(?,?,?,?,?,?,?,?,?)}");
            call.setInt(1, aUserSystemDA.getIDUserSystem());
            call.setString(2, aUserSystemDA.getName());
            call.setBoolean(3, aUserSystemDA.isGender());
            call.setDate(4, Birthday);
            call.setString(5, aUserSystemDA.getAddress());
            call.setString(6, aUserSystemDA.getIdentify());
            call.setString(7, aUserSystemDA.getPhoneNumber());
            call.setDate(8, JoinDate);
            call.setString(9, aUserSystemDA.getPosition());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(UserSystemDA aUserSystemDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_UserSystem_Delete(?)}");
            call.setInt(1, aUserSystemDA.getIDUserSystem());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSystemBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
