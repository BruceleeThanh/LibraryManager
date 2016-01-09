/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.CustomerDA;
import DataAccess.SqlConnection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class CustomerBO extends SqlConnection {
    
    public List<CustomerDA> SelectAll() {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }
    
    public List<CustomerDA> Select_ByIDCustomer(int IDCustomer) {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Select_ByIDCustomer(?)}");
            call.setInt(1, IDCustomer);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }
    
    public List<CustomerDA> Select_ByName(String Name) {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Select_ByName(?)}");
            call.setString(1, Name);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }
    
    public List<CustomerDA> Select_ByIdentify(String Identify) {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Select_ByIdentify(?)}");
            call.setString(1, Identify);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }
    
    public List<CustomerDA> Select_ByPhoneNumber(String PhoneNumber) {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Select_ByPhoneNumber(?)}");
            call.setString(1, PhoneNumber);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }
    
    public List<CustomerDA> Select_ByStatus(int Status) {
        List<CustomerDA> aListCustomerDA = new ArrayList<CustomerDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Select_ByStatus(?)}");
            call.setInt(1, Status);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                CustomerDA aCustomerDA = new CustomerDA(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                aListCustomerDA.add(aCustomerDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListCustomerDA;
    }

    public int SelectLast_IDCustomer(){
        try {
            PreparedStatement call = conn.prepareStatement("select IDENT_CURRENT('[LibrarianProject].[dbo].[Customer]')");
            call.executeQuery();
            ResultSet rs = call.getResultSet();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public boolean Insert(CustomerDA aCustomerDA) {
        try {
            Date Birthday = new Date(aCustomerDA.getBirthday().getTime());
            CallableStatement call = conn.prepareCall("{call spd_Customer_Insert(?,?,?,?,?,?,?)}");
            call.setString(1, aCustomerDA.getName());
            call.setBoolean(2, aCustomerDA.isGender());
            call.setDate(3, Birthday);
            call.setString(4, aCustomerDA.getAddress());
            call.setString(5, aCustomerDA.getIdentify());
            call.setString(6, aCustomerDA.getPhoneNumber());
            call.setInt(7, aCustomerDA.getStatus());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Update(CustomerDA aCustomerDA) {
        try {
            Date Birthday = new Date(aCustomerDA.getBirthday().getTime());
            CallableStatement call = conn.prepareCall("{call spd_Customer_Update(?,?,?,?,?,?,?,?)}");
            call.setInt(1, aCustomerDA.getIDCustomer());
            call.setString(2, aCustomerDA.getName());
            call.setBoolean(3, aCustomerDA.isGender());
            call.setDate(4, Birthday);
            call.setString(5, aCustomerDA.getAddress());
            call.setString(6, aCustomerDA.getIdentify());
            call.setString(7, aCustomerDA.getPhoneNumber());
            call.setInt(8, aCustomerDA.getStatus());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(CustomerDA aCustomerDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Customer_Delete(?)}");
            call.setInt(1, aCustomerDA.getIDCustomer());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
