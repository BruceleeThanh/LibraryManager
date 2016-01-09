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
public class AccountSystemDA {
    private int IDAccountSystem;
    private int IDUserSystem;
    private String Username;
    private String Password;

    public AccountSystemDA() {
    }

    public AccountSystemDA(int IDAccountSystem, int IDUserSystem, String Username, String Password) {
        this.IDAccountSystem = IDAccountSystem;
        this.IDUserSystem = IDUserSystem;
        this.Username = Username;
        this.Password = Password;
    }

    public int getIDAccountSystem() {
        return IDAccountSystem;
    }

    public void setIDAccountSystem(int IDAccountSystem) {
        this.IDAccountSystem = IDAccountSystem;
    }

    public int getIDUserSystem() {
        return IDUserSystem;
    }

    public void setIDUserSystem(int IDUserSystem) {
        this.IDUserSystem = IDUserSystem;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
