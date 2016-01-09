/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.SqlConnection;
import DataAccess.SubTopicDA;
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
public class SubTopicBO extends SqlConnection {

    public List<SubTopicDA> SelectAll() {
        List<SubTopicDA> aListSubTopicDA = new ArrayList<SubTopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicDA aSubTopicDA = new SubTopicDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListSubTopicDA.add(aSubTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicDA;
    }

    public List<SubTopicDA> Select_ByIDSubTopic(int IDSubTopic) {
        List<SubTopicDA> aListSubTopicDA = new ArrayList<SubTopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_Select_ByIDSubTopic(?)}");
            call.setInt(1, IDSubTopic);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicDA aSubTopicDA = new SubTopicDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListSubTopicDA.add(aSubTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicDA;
    }

    public List<SubTopicDA> Select_ByIDTopic(int IDTopic) {
        List<SubTopicDA> aListSubTopicDA = new ArrayList<SubTopicDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_Select_ByIDTopic(?)}");
            call.setInt(1, IDTopic);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicDA aSubTopicDA = new SubTopicDA(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                aListSubTopicDA.add(aSubTopicDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicDA;
    }

    public boolean Insert(SubTopicDA aSubTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_Insert(?,?,?)}");
            call.setInt(1, aSubTopicDA.getIDTopic());
            call.setString(2, aSubTopicDA.getName());
            call.setString(3, aSubTopicDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Update(SubTopicDA aSubTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_Update(?,?,?,?)}");
            call.setInt(1, aSubTopicDA.getIDSubTopic());
            call.setInt(2, aSubTopicDA.getIDTopic());
            call.setString(3, aSubTopicDA.getName());
            call.setString(4, aSubTopicDA.getDescription());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(SubTopicDA aSubTopicDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopic_Delete(?)}");
            call.setInt(1, aSubTopicDA.getIDSubTopic());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
