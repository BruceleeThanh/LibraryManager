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
public class LibraryDA {
    private int IDLibrary;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private byte[] Image;
    private String Description;

    public LibraryDA() {
    }

    public LibraryDA(int IDLibrary, String Name, String Address, String PhoneNumber, byte[] Image, String Description) {
        this.IDLibrary = IDLibrary;
        this.Name = Name;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.Image = Image;
        this.Description = Description;
    }

    public int getIDLibrary() {
        return IDLibrary;
    }

    public void setIDLibrary(int IDLibrary) {
        this.IDLibrary = IDLibrary;
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

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
