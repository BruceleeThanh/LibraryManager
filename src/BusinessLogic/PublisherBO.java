/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.PublisherDA;
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
public class PublisherBO extends SqlConnection {

    public List<PublisherDA> SelectAll() {
        List<PublisherDA> aListPublisherDA = new ArrayList<PublisherDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                PublisherDA aPublisherDA = new PublisherDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aListPublisherDA.add(aPublisherDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListPublisherDA;
    }
    
    public List<PublisherDA> Select_ByIDPublisher(int IDPublisher) {
        List<PublisherDA> aListPublisherDA = new ArrayList<PublisherDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_Select_ByIDPublisher(?)}");
            call.setInt(1, IDPublisher);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                PublisherDA aPublisherDA = new PublisherDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aListPublisherDA.add(aPublisherDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListPublisherDA;
    }
    
    public List<PublisherDA> Select_ByName(String Name) {
        List<PublisherDA> aListPublisherDA = new ArrayList<PublisherDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_Select_ByName()}");
            call.setString(1, Name);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                PublisherDA aPublisherDA = new PublisherDA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aListPublisherDA.add(aPublisherDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListPublisherDA;
    }

    public boolean Insert(PublisherDA aPublisherDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_Insert(?,?,?)}");
            call.setString(1, aPublisherDA.getName());
            call.setString(2, aPublisherDA.getAddress());
            call.setString(3, aPublisherDA.getPhoneNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Update(PublisherDA aPublisherDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_Update(?,?,?,?)}");
            call.setInt(1, aPublisherDA.getIDPublisher());
            call.setString(2, aPublisherDA.getName());
            call.setString(3, aPublisherDA.getAddress());
            call.setString(4, aPublisherDA.getPhoneNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(PublisherDA aPublisherDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Publisher_Delete(?)}");
            call.setInt(1, aPublisherDA.getIDPublisher());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
