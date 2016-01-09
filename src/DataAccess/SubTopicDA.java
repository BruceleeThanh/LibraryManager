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
public class SubTopicDA {
    private int IDSubTopic;
    private int IDTopic;
    private String Name;
    private String Description;

    public SubTopicDA() {
    }

    public SubTopicDA(int IDSubTopic, int IDTopic, String Name, String Description) {
        this.IDSubTopic = IDSubTopic;
        this.IDTopic = IDTopic;
        this.Name = Name;
        this.Description = Description;
    }

    public int getIDSubTopic() {
        return IDSubTopic;
    }

    public void setIDSubTopic(int IDSubTopic) {
        this.IDSubTopic = IDSubTopic;
    }

    public int getIDTopic() {
        return IDTopic;
    }

    public void setIDTopic(int IDTopic) {
        this.IDTopic = IDTopic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
