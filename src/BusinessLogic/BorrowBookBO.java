/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.BorrowBookDA;
import DataAccess.SqlConnection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brucelee Thanh
 */
public class BorrowBookBO extends SqlConnection{
    
    public List<BorrowBookDA> SelectAll() {
        List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                aListBorrowBookDA.add(aBorrowBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDA;
    }
    
    public List<BorrowBookDA> Select_ByIDBorrowBook(int IDBorrowBook) {
        List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Select_ByIDBorrowBook(?)}");
            call.setInt(1, IDBorrowBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                aListBorrowBookDA.add(aBorrowBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDA;
    }
    
    public List<BorrowBookDA> Select_ByIDMemberCard(int IDMemberCard) {
        List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Select_ByIDMemberCard(?)}");
            call.setInt(1, IDMemberCard);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                aListBorrowBookDA.add(aBorrowBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDA;
    }
    
    public List<BorrowBookDA> Select_ByIDUserSystem(int IDUserSystem) {
        List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Select_ByIDUserSystem(?)}");
            call.setInt(1, IDUserSystem);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                aListBorrowBookDA.add(aBorrowBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDA;
    }
    
    public List<BorrowBookDA> Select_ByBorrowDate(Date BorrowDate) {
        List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Select_ByBorrowDate(?)}");
            call.setDate(1, BorrowDate);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                aListBorrowBookDA.add(aBorrowBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDA;
    }
    
    public int SelectLast_IDBorrowBook(){
        try {
            PreparedStatement call = conn.prepareStatement("select IDENT_CURRENT('[LibrarianProject].[dbo].[BorrowBook]')");
            call.executeQuery();
            ResultSet rs = call.getResultSet();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public boolean Insert(BorrowBookDA aBorrowBookDA) {
        try {
            Date BorrowDate = new Date(aBorrowBookDA.getBorrowDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Insert(?,?,?,?)}");
            call.setInt(1, aBorrowBookDA.getIDMemberCard());
            call.setInt(2, aBorrowBookDA.getIDUserSystem());
            call.setInt(3, aBorrowBookDA.getQuantity());
            call.setDate(4, BorrowDate);
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(BorrowBookDA aBorrowBookDA) {
        try {
            Date BorrowDate = new Date(aBorrowBookDA.getBorrowDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Update(?,?,?,?,?)}");
            call.setInt(1, aBorrowBookDA.getIDBorrowBook());
            call.setInt(2, aBorrowBookDA.getIDMemberCard());
            call.setInt(3, aBorrowBookDA.getIDUserSystem());
            call.setInt(4, aBorrowBookDA.getQuantity());
            call.setDate(5, BorrowDate);
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(BorrowBookDA aBorrowBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBook_Delete(?)}");
            call.setInt(1, aBorrowBookDA.getIDBorrowBook());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
