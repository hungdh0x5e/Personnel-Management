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
public class Experience {

    private short ID_IDENTITY;
    private String compName;
    private String pos;
    private String job;
    private Date startDate;
    private Date endDate;
    private String reason;

    private String referName;
    private String referPhone;
    private String referEmail;
    private String referPos;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReferName() {
        return referName;
    }

    public void setReferName(String referName) {
        this.referName = referName;
    }

    public String getReferPhone() {
        return referPhone;
    }

    public void setReferPhone(String referPhone) {
        this.referPhone = referPhone;
    }

    public String getReferEmail() {
        return referEmail;
    }

    public void setReferEmail(String referEmail) {
        this.referEmail = referEmail;
    }

    public String getReferPos() {
        return referPos;
    }

    public void setReferPos(String referPos) {
        this.referPos = referPos;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
