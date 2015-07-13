/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author HUNGUYEN
 */
public class ComboBoxItems {
    private Short ID;
    private String name;

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

    public ComboBoxItems(Short ID, String name) {
        this.ID = ID;
        this.name = name;
    }
    
}
