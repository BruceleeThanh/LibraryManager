/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.ImportBookDA;
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
public class ImportBookBO extends SqlConnection {
    
    public List<ImportBookDA> SelectAll() {
        List<ImportBookDA> aListImportBookDA = new ArrayList<ImportBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_SelectAll()}");
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDA aImportBookDA = new ImportBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
                aListImportBookDA.add(aImportBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDA;
    }
    
    public List<ImportBookDA> Select_ByIDImportBook(int IDImportBook) {
        List<ImportBookDA> aListImportBookDA = new ArrayList<ImportBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Select_ByIDImportBook(?)}");
            call.setInt(1, IDImportBook);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDA aImportBookDA = new ImportBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
                aListImportBookDA.add(aImportBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDA;
    }
    
    public List<ImportBookDA> Select_ByIDUserSystem(int IDUserSystem) {
        List<ImportBookDA> aListImportBookDA = new ArrayList<ImportBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Select_ByIDUserSystem(?)}");
            call.setInt(1, IDUserSystem);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDA aImportBookDA = new ImportBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
                aListImportBookDA.add(aImportBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDA;
    }
    
    public List<ImportBookDA> Select_ByIDProvider(int IDProvider) {
        List<ImportBookDA> aListImportBookDA = new ArrayList<ImportBookDA>();
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Select_ByIDProvider(?)}");
            call.setInt(1, IDProvider);
            call.execute();
            ResultSet rs = call.getResultSet();
            while (rs.next()) {
                ImportBookDA aImportBookDA = new ImportBookDA(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
                aListImportBookDA.add(aImportBookDA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aListImportBookDA;
    }
    
    public boolean Insert(ImportBookDA aImportBookDA) {
        try {
            Date ImportDate = new Date(aImportBookDA.getImportDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Insert(?,?,?)}");
            call.setInt(1, aImportBookDA.getIDUserSystem());
            call.setInt(2, aImportBookDA.getIDProvider());
            call.setDate(3, ImportDate);
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Update(ImportBookDA aImportBookDA) {
        try {
            Date ImportDate = new Date(aImportBookDA.getImportDate().getTime());
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Update(?,?,?,?)}");
            call.setInt(1, aImportBookDA.getIDImportBook());
            call.setInt(2, aImportBookDA.getIDUserSystem());
            call.setInt(3, aImportBookDA.getIDProvider());
            call.setDate(4, ImportDate);
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Delete(ImportBookDA aImportBookDA) {
        try {
            CallableStatement call = conn.prepareCall("{call spd_ImportBook_Delete(?)}");
            call.setInt(1, aImportBookDA.getIDImportBook());
            if(call.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportBookBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
