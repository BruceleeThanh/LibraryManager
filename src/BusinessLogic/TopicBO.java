/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.SqlConnection;
import DataAccess.TopicDA;
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
public class TopicBO extends SqlConnection{
    
    public List<TopicDA> SelectAll() {
        List<TopicDA> aListTopicDA = new ArrayList<TopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                TopicDA aTopicDA = new TopicDA(rs.getInt(1), rs.getString(2), rs.getString(3));
                aListTopicDA.add(aTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListTopicDA;
    }
    
    public List<TopicDA> Select_ByIDTopic(int IDTopic) {
        List<TopicDA> aListTopicDA = new ArrayList<TopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_Select_ByIDTopic(?)}");
            call.setInt(1, IDTopic);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                TopicDA aTopicDA = new TopicDA(rs.getInt(1), rs.getString(2), rs.getString(3));
                aListTopicDA.add(aTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListTopicDA;
    }
    
    public List<TopicDA> Select_ByName(String Name) {
        List<TopicDA> aListTopicDA = new ArrayList<TopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_Select_ByName(?)}");
            call.setString(1, Name);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                TopicDA aTopicDA = new TopicDA(rs.getInt(1), rs.getString(2), rs.getString(3));
                aListTopicDA.add(aTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListTopicDA;
    }
    
    public boolean Insert(TopicDA aTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_Insert(?,?)}");
            call.setString(1, aTopicDA.getName());
            call.setString(2, aTopicDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(TopicDA aTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_Update(?,?,?)}");
            call.setInt(1, aTopicDA.getIDTopic());
            call.setString(2, aTopicDA.getName());
            call.setString(3, aTopicDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(TopicDA aTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_Topic_Delete(?)}");
            call.setInt(1, aTopicDA.getIDTopic());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
