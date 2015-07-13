/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author HUNGUYEN
 */
public class Skill {

    private short ID_IDENTITY;
    private short nameID;
    private short classificationID;
    private Date effectiveDate;
    private String note;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public short getNameID() {
        return nameID;
    }

    public void setNameID(short nameID) {
        this.nameID = nameID;
    }

    public short getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(short classificationID) {
        this.classificationID = classificationID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}
