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
public class PublisherDA {
    private int IDPublisher;
    private String Name;
    private String Address;
    private String PhoneNumber;

    public PublisherDA() {
    }

    public PublisherDA(int IDPublisher, String Name, String Address, String PhoneNumber) {
        this.IDPublisher = IDPublisher;
        this.Name = Name;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
}
