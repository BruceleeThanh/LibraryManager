/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author Brucelee Thanh
 */
public class ImportBookDetailDA {
    private int IDImportBook;
    private int IDBook;
    private int Quantity;

    public ImportBookDetailDA() {
    }

    public ImportBookDetailDA(int IDImportBook, int IDBook, int Quantity) {
        this.IDImportBook = IDImportBook;
        this.IDBook = IDBook;
        this.Quantity = Quantity;
    }

    public int getIDImportBook() {
        return IDImportBook;
    }

    public void setIDImportBook(int IDImportBook) {
        this.IDImportBook = IDImportBook;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
}
