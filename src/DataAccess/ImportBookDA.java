/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.util.Date;

/**
 *
 * @author Brucelee Thanh
 */
public class ImportBookDA {
    private int IDImportBook;
    private int IDUserSystem;
    private int IDProvider;
    private Date ImportDate;

    public ImportBookDA() {
    }

    public ImportBookDA(int IDImportBook, int IDUserSystem, int IDProvider, Date ImportDate) {
        this.IDImportBook = IDImportBook;
        this.IDUserSystem = IDUserSystem;
        this.IDProvider = IDProvider;
        this.ImportDate = ImportDate;
    }

    public int getIDImportBook() {
        return IDImportBook;
    }

    public void setIDImportBook(int IDImportBook) {
        this.IDImportBook = IDImportBook;
    }

    public int getIDUserSystem() {
        return IDUserSystem;
    }

    public void setIDUserSystem(int IDUserSystem) {
        this.IDUserSystem = IDUserSystem;
    }

    public int getIDProvider() {
        return IDProvider;
    }

    public void setIDProvider(int IDProvider) {
        this.IDProvider = IDProvider;
    }

    public Date getImportDate() {
        return ImportDate;
    }

    public void setImportDate(Date ImportDate) {
        this.ImportDate = ImportDate;
    }
    
}
