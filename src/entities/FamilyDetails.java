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
public class FamilyDetails {

    private short ID_IDENTITY;
    //Thông tin người thân
    private short relationID;
    private String perName;
    private Date perBirth;
    private String perJob;
    private String perAdd;
    private String perPhone;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public short getRelationID() {
        return relationID;
    }

    public void setRelationID(short relationID) {
        this.relationID = relationID;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public Date getPerBirth() {
        return perBirth;
    }

    public void setPerBirth(Date perBirth) {
        this.perBirth = perBirth;
    }

    public String getPerJob() {
        return perJob;
    }

    public void setPerJob(String perJob) {
        this.perJob = perJob;
    }

    public String getPerAdd() {
        return perAdd;
    }

    public void setPerAdd(String perAdd) {
        this.perAdd = perAdd;
    }

    public String getPerPhone() {
        return perPhone;
    }

    public void setPerPhone(String perPhone) {
        this.perPhone = perPhone;
    }

}
