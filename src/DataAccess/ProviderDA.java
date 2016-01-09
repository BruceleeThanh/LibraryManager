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
public class ProviderDA {
    private int IDProvider;
    private String Name;
    private String Address;
    private String PhoneNumber;

    public ProviderDA() {
    }

    public ProviderDA(int IDProvider, String Name, String Address, String PhoneNumber) {
        this.IDProvider = IDProvider;
        this.Name = Name;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public int getIDProvider() {
        return IDProvider;
    }

    public void setIDProvider(int IDProvider) {
        this.IDProvider = IDProvider;
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
