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
public class SubTopicBookDA {
    private int IDSubTopic;
    private int IDBook;

    public SubTopicBookDA() {
    }

    public SubTopicBookDA(int IDSubTopic, int IDBook) {
        this.IDSubTopic = IDSubTopic;
        this.IDBook = IDBook;
    }

    public int getIDSubTopic() {
        return IDSubTopic;
    }

    public void setIDSubTopic(int IDSubTopic) {
        this.IDSubTopic = IDSubTopic;
    }

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }
    
}
