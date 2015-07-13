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
public class HealthStatus {

    private short ID_IDENTITY;
    //Thông tin sức khỏe
    private Date healDate;
    private String hospital;
    private short height;
    private short weight;
    private String sight;
    private short bloodID;
    private short healthStatusID;
    private String note;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getHealDate() {
        return healDate;
    }

    public void setHealDate(Date healDate) {
        this.healDate = healDate;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public short getBloodID() {
        return bloodID;
    }

    public void setBloodID(short bloodID) {
        this.bloodID = bloodID;
    }

    public short getHealthStatusID() {
        return healthStatusID;
    }

    public void setHealthStatusID(short healthStatusID) {
        this.healthStatusID = healthStatusID;
    }

}
