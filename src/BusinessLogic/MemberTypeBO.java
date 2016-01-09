/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.MemberTypeDA;
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
public class MemberTypeBO extends SqlConnection{
    
    public List<MemberTypeDA> SelectAll() {
        List<MemberTypeDA> aListMemberTypeDA = new ArrayList<MemberTypeDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberType_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                MemberTypeDA aMemberTypeDA = new MemberTypeDA(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                aListMemberTypeDA.add(aMemberTypeDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberTypeBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListMemberTypeDA;
    }
    
    public List<MemberTypeDA> Select_ByIDMemberType(int IDMemberType) {
        List<MemberTypeDA> aListMemberTypeDA = new ArrayList<MemberTypeDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberType_Select_ByIDMemberType(?)}");
            call.setInt(1, IDMemberType);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                MemberTypeDA aMemberTypeDA = new MemberTypeDA(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                aListMemberTypeDA.add(aMemberTypeDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberTypeBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListMemberTypeDA;
    }
    
    public boolean Insert(MemberTypeDA aMemberTypeDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberType_Insert(?,?,?,?,?)}");
            call.setString(1, aMemberTypeDA.getName());
            call.setInt(2, aMemberTypeDA.getLimitBook());
            call.setInt(3, aMemberTypeDA.getLimitDay());
            call.setInt(4, aMemberTypeDA.getExtendDay());
            call.setInt(5, aMemberTypeDA.getExtendNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberTypeBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(MemberTypeDA aMemberTypeDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberType_Update(?,?,?,?,?,?)}");
            call.setInt(1, aMemberTypeDA.getIDMemberType());
            call.setString(2, aMemberTypeDA.getName());
            call.setInt(3, aMemberTypeDA.getLimitBook());
            call.setInt(4, aMemberTypeDA.getLimitDay());
            call.setInt(5, aMemberTypeDA.getExtendDay());
            call.setInt(6, aMemberTypeDA.getExtendNumber());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberTypeBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(MemberTypeDA aMemberTypeDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberType_Delete(?)}");
            call.setInt(1, aMemberTypeDA.getIDMemberType());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberTypeBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
