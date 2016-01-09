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
public class BorrowBookDA {
    private int IDBorrowBook;
    private int IDMemberCard;
    private int IDUserSystem;
    private int Quantity;
    private Date BorrowDate;

    public BorrowBookDA() {
    }

    public BorrowBookDA(int IDBorrowBook, int IDMemberCard, int IDUserSystem, int Quantity, Date BorrowDate) {
        this.IDBorrowBook = IDBorrowBook;
        this.IDMemberCard = IDMemberCard;
        this.IDUserSystem = IDUserSystem;
        this.Quantity = Quantity;
        this.BorrowDate = BorrowDate;
    }

    public int getIDBorrowBook() {
        return IDBorrowBook;
    }

    public void setIDBorrowBook(int IDBorrowBook) {
        this.IDBorrowBook = IDBorrowBook;
    }

    public int getIDMemberCard() {
        return IDMemberCard;
    }

    public void setIDMemberCard(int IDMemberCard) {
        this.IDMemberCard = IDMemberCard;
    }

    public int getIDUserSystem() {
        return IDUserSystem;
    }

    public void setIDUserSystem(int IDUserSystem) {
        this.IDUserSystem = IDUserSystem;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Date getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(Date BorrowDate) {
        this.BorrowDate = BorrowDate;
    }
    
}
