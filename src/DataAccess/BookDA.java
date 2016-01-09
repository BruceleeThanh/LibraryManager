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
public class BookDA {
    private int IDBook;
    private int IDPublisher;
    private String Name;
    private byte[] Image;
    private int Page;
    private int PublishDate;
    private float CoverSizeWidth;
    private float CoverSizeHeight;
    private int Quantity;
    private int ExistingNumber;

    public BookDA() {
    }

    public BookDA(int IDBook, int IDPublisher, String Name, byte[] Image, int Page, int PublishDate, float CoverSizeWidth, float CoverSizeHeight, int Quantity, int ExistingNumber) {
        this.IDBook = IDBook;
        this.IDPublisher = IDPublisher;
        this.Name = Name;
        this.Image = Image;
        this.Page = Page;
        this.PublishDate = PublishDate;
        this.CoverSizeWidth = CoverSizeWidth;
        this.CoverSizeHeight = CoverSizeHeight;
        this.Quantity = Quantity;
        this.ExistingNumber = ExistingNumber;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public int getIDPublisher() {
        return IDPublisher;
    }

    public void setIDPublisher(int IDPublisher) {
        this.IDPublisher = IDPublisher;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int Page) {
        this.Page = Page;
    }

    public int getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(int PublishDate) {
        this.PublishDate = PublishDate;
    }

    public float getCoverSizeWidth() {
        return CoverSizeWidth;
    }

    public void setCoverSizeWidth(float CoverSizeWidth) {
        this.CoverSizeWidth = CoverSizeWidth;
    }

    public float getCoverSizeHeight() {
        return CoverSizeHeight;
    }

    public void setCoverSizeHeight(float CoverSizeHeight) {
        this.CoverSizeHeight = CoverSizeHeight;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getExistingNumber() {
        return ExistingNumber;
    }

    public void setExistingNumber(int ExistingNumber) {
        this.ExistingNumber = ExistingNumber;
    }
    
}
