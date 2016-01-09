/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.Entity;
import DataAccess.*;
import BusinessLogic.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Brucelee Thanh
 */
public class BorrowBookEN extends BorrowBookDA{
    private List<BorrowBookDetailDA> aListBorrowBookDetailDA = new ArrayList<BorrowBookDetailDA>();
    private int ExtendActual;
    private int ExtendNumber;
    private int ExtendDay;

    public BorrowBookEN() {
    }

    public BorrowBookEN(int IDBorrowBook, int IDMemberCard, int IDUserSystem, int Quantity, Date BorrowDate) {
        super(IDBorrowBook, IDMemberCard, IDUserSystem, Quantity, BorrowDate);
    }
    
    public BorrowBookEN(BorrowBookDA Input) {
        super(Input.getIDBorrowBook(), Input.getIDMemberCard(), Input.getIDUserSystem(), Input.getQuantity(), Input.getBorrowDate());
    }

    public List<BorrowBookDetailDA> getaListBorrowBookDetailDA() {
        return aListBorrowBookDetailDA;
    }

    public void setaListBorrowBookDetailDA() {
        BorrowBookDetailBO aBorrowBookDetailBO = new BorrowBookDetailBO();
        this.aListBorrowBookDetailDA = aBorrowBookDetailBO.Select_ByIDBorrowBook(this.getIDBorrowBook());
    }

    public int getExtendActual() {
        return ExtendActual;
    }

    public void setExtendActual(int ExtendActual) {
        this.ExtendActual = ExtendActual;
    }

    public int getExtendNumber() {
        return ExtendNumber;
    }

    public void setExtendNumber(int ExtendNumber) {
        this.ExtendNumber = ExtendNumber;
    }

    public int getExtendDay() {
        return ExtendDay;
    }

    public void setExtendDay(int ExtendDay) {
        this.ExtendDay = ExtendDay;
    }
    
    public void setAllOfExtend(){
        MemberTypeBO aMemberTypeBO = new MemberTypeBO();
        MemberTypeDA aMemberTypeDA = new MemberTypeDA();
        MemberCardBO aMemberCardBO = new MemberCardBO();
        MemberCardDA aMemberCardDA = new MemberCardDA();
        
        aMemberCardDA = aMemberCardBO.Select_ByIDMemberCard(this.getIDMemberCard()).get(0);
        aMemberTypeDA = aMemberTypeBO.Select_ByIDMemberType(aMemberCardDA.getIDMemberType()).get(0);
        this.setExtendDay(aMemberTypeDA.getExtendDay());
        this.setExtendNumber(aMemberTypeDA.getExtendNumber());
        long diff = Math.abs(this.aListBorrowBookDetailDA.get(0).getPlanReturn().getTime() - this.getBorrowDate().getTime());
        long diffDays = diff/(24*60*60*1000);
        diffDays -= aMemberTypeDA.getLimitDay();
        if((float)diffDays/this.getExtendDay() > 0){
            this.setExtendActual((int)((float)diffDays/this.getExtendDay()));
        }else{
            this.setExtendActual(0);
        }
    }
    
    public boolean checkExtendLimit(){
        if(this.getExtendActual() == this.getExtendNumber()){
            return true;
        }else{
            return false;
        }
    }
    
}
