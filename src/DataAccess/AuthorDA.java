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
public class AuthorDA {
    private int IDAuthor;
    private String Name;
    private String Pseudonym;
    private boolean Gender;
    private Date Birthday;
    private String Address;
    private String Description;

    public AuthorDA() {
    }

    public AuthorDA(int IDAuthor, String Name, String Pseudonym, boolean Gender, Date Birthday, String Address, String Description) {
        this.IDAuthor = IDAuthor;
        this.Name = Name;
        this.Pseudonym = Pseudonym;
        this.Gender = Gender;
        this.Birthday = Birthday;
        this.Address = Address;
        this.Description = Description;
    }

    public int getIDAuthor() {
        return IDAuthor;
    }

    public void setIDAuthor(int IDAuthor) {
        this.IDAuthor = IDAuthor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPseudonym() {
        return Pseudonym;
    }

    public void setPseudonym(String Pseudonym) {
        this.Pseudonym = Pseudonym;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
