/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.ProviderDA;
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
public class ProviderBO extends SqlConnection{
    
    public List<ProviderDA> SelectAll() {
        List<ProviderDA> aListProviderDA = new ArrayList<ProviderDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Provider_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ProviderDA aProviderDA = new ProviderDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aListProviderDA.add(aProviderDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListProviderDA;
    }
    
    public List<ProviderDA> Select_ByIDProvider(int IDProvider) {
        List<ProviderDA> aListProviderDA = new ArrayList<ProviderDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Provider_Select_ByIDProvider()}");
            call.setInt(1, IDProvider);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ProviderDA aProviderDA = new ProviderDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aListProviderDA.add(aProviderDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListProviderDA;
    }
    
    public boolean Insert(ProviderDA aProviderDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Provider_Insert(?,?,?)}");
            call.setString(1, aProviderDA.getName());
            call.setString(2, aProviderDA.getAddress());
            call.setString(3, aProviderDA.getPhoneNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(ProviderDA aProviderDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Provider_Update(?,?,?,?)}");
            call.setInt(1, aProviderDA.getIDProvider());
            call.setString(2, aProviderDA.getName());
            call.setString(3, aProviderDA.getAddress());
            call.setString(4, aProviderDA.getPhoneNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(ProviderDA aProviderDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Provider_Delete(?)}");
            call.setInt(1, aProviderDA.getIDProvider());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProviderBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
