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
public class MemberCardDA {
    private int IDMemberCard;
    private int IDCustomer;
    private int IDMemberType;
    private Date CreateDate;
    private Date EndDate;
    private byte[] Image;
    private int Status;

    public MemberCardDA() {
    }

    public MemberCardDA(int IDMemberCard, int IDCustomer, int IDMemberType, Date CreateDate, Date EndDate, byte[] Image, int Status) {
        this.IDMemberCard = IDMemberCard;
        this.IDCustomer = IDCustomer;
        this.IDMemberType = IDMemberType;
        this.CreateDate = CreateDate;
        this.EndDate = EndDate;
        this.Image = Image;
        this.Status = Status;
    }

    public int getIDMemberCard() {
        return IDMemberCard;
    }

    public void setIDMemberCard(int IDMemberCard) {
        this.IDMemberCard = IDMemberCard;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public int getIDMemberType() {
        return IDMemberType;
    }

    public void setIDMemberType(int IDMemberType) {
        this.IDMemberType = IDMemberType;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
}
