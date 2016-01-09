/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.BorrowBookDetailDA;
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
public class BorrowBookDetailBO extends SqlConnection{
    public List<BorrowBookDetailDA> SelectAll() {
        List<BorrowBookDetailDA> aListBorrowBookDetailDA = new ArrayList<BorrowBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDetailDA aBorrowBookDetailDA = new BorrowBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5));
                aListBorrowBookDetailDA.add(aBorrowBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDetailDA;
    }
    
    public List<BorrowBookDetailDA> Select_ByIDBorrowBook_ByIDBook(int IDBorrowBook, int IDBook) {
        List<BorrowBookDetailDA> aListBorrowBookDetailDA = new ArrayList<BorrowBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_Select_ByIDBorrowBook_ByIDBook(?,?)}");
            call.setInt(1, IDBorrowBook);
            call.setInt(2, IDBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDetailDA aBorrowBookDetailDA = new BorrowBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5));
                aListBorrowBookDetailDA.add(aBorrowBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDetailDA;
    }
    
    public List<BorrowBookDetailDA> Select_ByIDBorrowBook(int IDBorrowBook) {
        List<BorrowBookDetailDA> aListBorrowBookDetailDA = new ArrayList<BorrowBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_Select_ByIDBorrowBook(?)}");
            call.setInt(1, IDBorrowBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                BorrowBookDetailDA aBorrowBookDetailDA = new BorrowBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getFloat(5));
                aListBorrowBookDetailDA.add(aBorrowBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListBorrowBookDetailDA;
    }
    
    public boolean Insert(BorrowBookDetailDA aBorrowBookDetailDA) {
        try {
            Date PlanReturn = new Date(aBorrowBookDetailDA.getPlanReturn().getTime());
            Date ActualReturn = new Date(aBorrowBookDetailDA.getActualReturn().getTime());
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_Insert(?,?,?,?,?)}");
            call.setInt(1, aBorrowBookDetailDA.getIDBorrowBook());
            call.setInt(2, aBorrowBookDetailDA.getIDBook());
            call.setDate(3, PlanReturn);
            call.setDate(4, ActualReturn);
            call.setFloat(5, aBorrowBookDetailDA.getFee());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(BorrowBookDetailDA aBorrowBookDetailDA) {
        try {
            Date PlanReturn = new Date(aBorrowBookDetailDA.getPlanReturn().getTime());
            Date ActualReturn = new Date(aBorrowBookDetailDA.getActualReturn().getTime());
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_Update(?,?,?,?,?)}");
            call.setInt(1, aBorrowBookDetailDA.getIDBorrowBook());
            call.setInt(2, aBorrowBookDetailDA.getIDBook());
            call.setDate(3, PlanReturn);
            call.setDate(4, ActualReturn);
            call.setFloat(5, aBorrowBookDetailDA.getFee());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(BorrowBookDetailDA aBorrowBookDetailDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_BorrowBookDetail_Delete(?,?)}");
            call.setInt(1, aBorrowBookDetailDA.getIDBorrowBook());
            call.setInt(2, aBorrowBookDetailDA.getIDBook());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
