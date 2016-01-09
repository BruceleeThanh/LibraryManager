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
public class UserSystemDA {
    private int IDUserSystem;
    private String Name;
    private boolean Gender;
    private Date Birthday;
    private String Address;
    private String Identify;
    private String PhoneNumber;
    private Date JoinDate;
    private String Position;

    public UserSystemDA() {
    }

    public UserSystemDA(int IDUserSystem, String Name, boolean Gender, Date Birthday, String Address, String Identify, String PhoneNumber, Date JoinDate, String Position) {
        this.IDUserSystem = IDUserSystem;
        this.Name = Name;
        this.Gender = Gender;
        this.Birthday = Birthday;
        this.Address = Address;
        this.Identify = Identify;
        this.PhoneNumber = PhoneNumber;
        this.JoinDate = JoinDate;
        this.Position = Position;
    }

    public int getIDUserSystem() {
        return IDUserSystem;
    }

    public void setIDUserSystem(int IDUserSystem) {
        this.IDUserSystem = IDUserSystem;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
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

    public Date getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(Date JoinDate) {
        this.JoinDate = JoinDate;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }
    
}
