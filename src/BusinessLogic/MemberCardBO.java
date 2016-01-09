/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.MemberCardDA;
import DataAccess.SqlConnection;
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
public class MemberCardBO extends SqlConnection{
    
    public List<MemberCardDA> SelectAll() {
        List<MemberCardDA> aListMemberCardDA = new ArrayList<MemberCardDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                MemberCardDA aMemberCardDA = new MemberCardDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBytes(6), rs.getInt(7));
                aListMemberCardDA.add(aMemberCardDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListMemberCardDA;
    }
    
    public List<MemberCardDA> Select_ByIDMemberCard(int IDMemberCard) {
        List<MemberCardDA> aListMemberCardDA = new ArrayList<MemberCardDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_Select_ByIDMemberCard(?)}");
            call.setInt(1, IDMemberCard);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                MemberCardDA aMemberCardDA = new MemberCardDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBytes(6), rs.getInt(7));
                aListMemberCardDA.add(aMemberCardDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListMemberCardDA;
    }
    
    public List<MemberCardDA> Select_ByIDCustomer(int IDCustomer) {
        List<MemberCardDA> aListMemberCardDA = new ArrayList<MemberCardDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_Select_ByIDCustomer(?)}");
            call.setInt(1, IDCustomer);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                MemberCardDA aMemberCardDA = new MemberCardDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getBytes(6), rs.getInt(7));
                aListMemberCardDA.add(aMemberCardDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListMemberCardDA;
    }
    
    public boolean Insert(MemberCardDA aMemberCardDA) {
        try {
            Date CreateDate = new Date(aMemberCardDA.getCreateDate().getTime());
            Date EndDate = new Date(aMemberCardDA.getEndDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_Insert(?,?,?,?,?,?)}");
            call.setInt(1,aMemberCardDA.getIDCustomer());
            call.setInt(2, aMemberCardDA.getIDMemberType());
            call.setDate(3, CreateDate);
            call.setDate(4, EndDate);
            call.setBytes(5, aMemberCardDA.getImage());
            call.setInt(6, aMemberCardDA.getStatus());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(MemberCardDA aMemberCardDA) {
        try {
            Date CreateDate = new Date(aMemberCardDA.getCreateDate().getTime());
            Date EndDate = new Date(aMemberCardDA.getEndDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_Update(?,?,?,?,?,?,?)}");
            call.setInt(1, aMemberCardDA.getIDMemberCard());
            call.setInt(2,aMemberCardDA.getIDCustomer());
            call.setInt(3, aMemberCardDA.getIDMemberType());
            call.setDate(4, CreateDate);
            call.setDate(5, EndDate);
            call.setBytes(6, aMemberCardDA.getImage());
            call.setInt(7, aMemberCardDA.getStatus());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(MemberCardDA aMemberCardDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_MemberCard_Delete(?)}");
            call.setInt(1, aMemberCardDA.getIDMemberCard());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
