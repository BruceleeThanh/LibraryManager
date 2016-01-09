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
public class MemberTypeDA {
    private int IDMemberType;
    private String Name;
    private int LimitBook;
    private int LimitDay;
    private int ExtendDay;
    private int ExtendNumber;

    public MemberTypeDA() {
    }

    public MemberTypeDA(int IDMemberType, String Name, int LimitBook, int LimitDay, int ExtendDay, int ExtendNumber) {
        this.IDMemberType = IDMemberType;
        this.Name = Name;
        this.LimitBook = LimitBook;
        this.LimitDay = LimitDay;
        this.ExtendDay = ExtendDay;
        this.ExtendNumber = ExtendNumber;
    }

    public int getIDMemberType() {
        return IDMemberType;
    }

    public void setIDMemberType(int IDMemberType) {
        this.IDMemberType = IDMemberType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getLimitBook() {
        return LimitBook;
    }

    public void setLimitBook(int LimitBook) {
        this.LimitBook = LimitBook;
    }

    public int getLimitDay() {
        return LimitDay;
    }

    public void setLimitDay(int LimitDay) {
        this.LimitDay = LimitDay;
    }

    public int getExtendDay() {
        return ExtendDay;
    }

    public void setExtendDay(int ExtendDay) {
        this.ExtendDay = ExtendDay;
    }

    public int getExtendNumber() {
        return ExtendNumber;
    }

    public void setExtendNumber(int ExtendNumber) {
        this.ExtendNumber = ExtendNumber;
    }
    
}
