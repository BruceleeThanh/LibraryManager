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
public class CustomerDA {
    private int IDCustomer;
    private String Name;
    private boolean Gender;
    private Date Birthday;
    private String Address;
    private String Identify;
    private String PhoneNumber;
    private int Status;

    public CustomerDA() {
    }

    public CustomerDA(int IDCustomer, String Name, boolean Gender, Date Birthday, String Address, String Identify, String PhoneNumber, int Status) {
        this.IDCustomer = IDCustomer;
        this.Name = Name;
        this.Gender = Gender;
        this.Birthday = Birthday;
        this.Address = Address;
        this.Identify = Identify;
        this.PhoneNumber = PhoneNumber;
        this.Status = Status;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getIdentify() {
        return Identify;
    }

    public void setIdentify(String Identify) {
        this.Identify = Identify;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
}
