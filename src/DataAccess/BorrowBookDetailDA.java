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
public class BorrowBookDetailDA {
    private int IDBorrowBook;
    private int IDBook;
    private Date PlanReturn;
    private Date ActualReturn;
    private float Fee;

    public BorrowBookDetailDA() {
    }

    public BorrowBookDetailDA(int IDBorrowBook, int IDBook, Date PlanReturn, Date ActualReturn, float Fee) {
        this.IDBorrowBook = IDBorrowBook;
        this.IDBook = IDBook;
        this.PlanReturn = PlanReturn;
        this.ActualReturn = ActualReturn;
        this.Fee = Fee;
    }
    
    public int getIDBorrowBook() {
        return IDBorrowBook;
    }

    public void setIDBorrowBook(int IDBorrowBook) {
        this.IDBorrowBook = IDBorrowBook;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public Date getPlanReturn() {
        return PlanReturn;
    }

    public void setPlanReturn(Date PlanReturn) {
        this.PlanReturn = PlanReturn;
    }

    public Date getActualReturn() {
        return ActualReturn;
    }

    public void setActualReturn(Date ActualReturn) {
        this.ActualReturn = ActualReturn;
    }

    public float getFee() {
        return Fee;
    }

    public void setFee(float Fee) {
        this.Fee = Fee;
    }
    
}
