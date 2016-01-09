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
public class AuthorBookDA {
    private int IDBook;
    private int IDAuthor;

    public AuthorBookDA() {
    }

    public AuthorBookDA(int IDBook, int IDAuthor) {
        this.IDBook = IDBook;
        this.IDAuthor = IDAuthor;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public int getIDAuthor() {
        return IDAuthor;
    }

    public void setIDAuthor(int IDAuthor) {
        this.IDAuthor = IDAuthor;
    }
    
}
