/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.ImportBookDetailDA;
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
public class ImportBookDetailBO extends SqlConnection{
    
    public List<ImportBookDetailDA> SelectAll() {
        List<ImportBookDetailDA> aListImportBookDetailDA = new ArrayList<ImportBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDetailDA aImportBookDetailDA = new ImportBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                aListImportBookDetailDA.add(aImportBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDetailDA;
    }
    
    public List<ImportBookDetailDA> Select_ByIDImportBook_ByIDBook(int IDImportBook, int IDBook) {
        List<ImportBookDetailDA> aListImportBookDetailDA = new ArrayList<ImportBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_Select_ByIDImportBook_ByIDBook(?,?)}");
            call.setInt(1, IDImportBook);
            call.setInt(2, IDBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDetailDA aImportBookDetailDA = new ImportBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                aListImportBookDetailDA.add(aImportBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDetailDA;
    }
    
    public List<ImportBookDetailDA> Select_ByQuantity(int Quantity) {
        List<ImportBookDetailDA> aListImportBookDetailDA = new ArrayList<ImportBookDetailDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_Select_ByQuantity(?)}");
            call.setInt(1, Quantity);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDetailDA aImportBookDetailDA = new ImportBookDetailDA(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                aListImportBookDetailDA.add(aImportBookDetailDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDetailDA;
    }
    
    public boolean Insert(ImportBookDetailDA aImportBookDetailDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_Insert(?,?,?)}");
            call.setInt(1, aImportBookDetailDA.getIDImportBook());
            call.setInt(2, aImportBookDetailDA.getIDBook());
            call.setInt(3, aImportBookDetailDA.getQuantity());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Update(ImportBookDetailDA aImportBookDetailDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_Update(?,?,?)}");
            call.setInt(1, aImportBookDetailDA.getIDImportBook());
            call.setInt(2, aImportBookDetailDA.getIDBook());
            call.setInt(3, aImportBookDetailDA.getQuantity());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Delete(ImportBookDetailDA aImportBookDetailDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBookDetail_Delete(?)}");
            call.setInt(1, aImportBookDetailDA.getIDImportBook());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookDetailBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
