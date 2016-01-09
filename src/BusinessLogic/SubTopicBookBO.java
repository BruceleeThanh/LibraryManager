/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.SqlConnection;
import DataAccess.SubTopicBookDA;
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
public class SubTopicBookBO extends SqlConnection{
    
    public List<SubTopicBookDA> SelectAll() {
        List<SubTopicBookDA> aListSubTopicBookDA = new ArrayList<SubTopicBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicBookDA aSubTopicBookDA = new SubTopicBookDA(rs.getInt(1), rs.getInt(2));
                aListSubTopicBookDA.add(aSubTopicBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicBookDA;
    }
    
    public List<SubTopicBookDA> Select_ByIDBook_ByIDSubTopic(int IDBook, int IDSubTopic) {
        List<SubTopicBookDA> aListSubTopicBookDA = new ArrayList<SubTopicBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Select_ByIDBook_ByIDSubTopic(?,?)}");
            call.setInt(1, IDBook);
            call.setInt(2, IDSubTopic);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicBookDA aSubTopicBookDA = new SubTopicBookDA(rs.getInt(1), rs.getInt(2));
                aListSubTopicBookDA.add(aSubTopicBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicBookDA;
    }
    
    public List<SubTopicBookDA> Select_ByIDBook(int IDBook) {
        List<SubTopicBookDA> aListSubTopicBookDA = new ArrayList<SubTopicBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Select_ByIDBook(?)}");
            call.setInt(1, IDBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicBookDA aSubTopicBookDA = new SubTopicBookDA(rs.getInt(1), rs.getInt(2));
                aListSubTopicBookDA.add(aSubTopicBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicBookDA;
    }
    
    public List<SubTopicBookDA> Select_ByIDSubTopic(int IDSubTopic) {
        List<SubTopicBookDA> aListSubTopicBookDA = new ArrayList<SubTopicBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Select_ByIDBook_ByIDSubTopic(?)}");
            call.setInt(1, IDSubTopic);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                SubTopicBookDA aSubTopicBookDA = new SubTopicBookDA(rs.getInt(1), rs.getInt(2));
                aListSubTopicBookDA.add(aSubTopicBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListSubTopicBookDA;
    }
    
    public boolean Insert(SubTopicBookDA aSubTopicBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Insert(?,?)}");
            call.setInt(1, aSubTopicBookDA.getIDBook());
            call.setInt(2, aSubTopicBookDA.getIDSubTopic());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(SubTopicBookDA aSubTopicBookDA_Old, SubTopicBookDA aSubTopicBookDA_New) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Update(?,?,?,?)}");
            call.setInt(1, aSubTopicBookDA_Old.getIDBook());
            call.setInt(2, aSubTopicBookDA_Old.getIDSubTopic());
            call.setInt(3, aSubTopicBookDA_New.getIDBook());
            call.setInt(4, aSubTopicBookDA_New.getIDSubTopic());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(SubTopicBookDA aSubTopicBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_SubTopicBook_Delete(?,?)}");
            call.setInt(1, aSubTopicBookDA.getIDBook());
            call.setInt(2, aSubTopicBookDA.getIDSubTopic());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubTopicBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
