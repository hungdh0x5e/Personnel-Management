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
public class Education {

    private short ID_IDENTITY;
    private short kindID;
    private String courseName;
    private short graduationID;
    private String schoolName;
    private short fromYear;
    private short toYear;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public short getKindID() {
        return kindID;
    }

    public void setKindID(short kindID) {
        this.kindID = kindID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public short getGraduationID() {
        return graduationID;
    }

    public void setGraduationID(short graduationID) {
        this.graduationID = graduationID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public short getFromYear() {
        return fromYear;
    }

    public void setFromYear(short fromYear) {
        this.fromYear = fromYear;
    }

    public short getToYear() {
        return toYear;
    }

    public void setToYear(short toYear) {
        this.toYear = toYear;
    }

}
