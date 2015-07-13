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
public class PersonnelDetails {

    //Thông tin cá nhân
    private String personnelID;
    private String fName;
    private String lName;
    private String nickName;
    private short statusID;
    private short kindID;
    private short contractID;
    private short posID;
    private short officeID;
    private Date enterDate;
    private Date startDate;
    private boolean sex;
    private Date endTraining;
    private String phoneNum;
    private String compEmail;
    private byte[] pic;
    private Date birth;
    private String placeOB;
    private String recentAdd;
    private short folkID;
    private short religionID;
    private short nationID;
    private String personalEmail;
    private boolean mariage;
    private String education;
    private String Add;
    private String IDNum;
    private Date IDDay;
    private String IDPlace;
    private short regionID;
    private String bankCode;
    private short bankID;
    private String taxCode;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndTraining() {
        return endTraining;
    }

    public void setEndTraining(Date endTraining) {
        this.endTraining = endTraining;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getIDDay() {
        return IDDay;
    }

    public void setIDDay(Date IDDay) {
        this.IDDay = IDDay;
    }

    public String getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(String personnelID) {
        this.personnelID = personnelID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public short getStatusID() {
        return statusID;
    }

    public void setStatusID(short statusID) {
        this.statusID = statusID;
    }

    public short getKindID() {
        return kindID;
    }

    public void setKindID(short kindID) {
        this.kindID = kindID;
    }

    public short getContractID() {
        return contractID;
    }

    public void setContractID(short contractID) {
        this.contractID = contractID;
    }

    public short getPosID() {
        return posID;
    }

    public void setPosID(short posID) {
        this.posID = posID;
    }

    public short getOfficeID() {
        return officeID;
    }

    public void setOfficeID(short officeID) {
        this.officeID = officeID;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCompEmail() {
        return compEmail;
    }

    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getPlaceOB() {
        return placeOB;
    }

    public void setPlaceOB(String placeOB) {
        this.placeOB = placeOB;
    }

    public String getRecentAdd() {
        return recentAdd;
    }

    public void setRecentAdd(String recentAdd) {
        this.recentAdd = recentAdd;
    }

    public short getFolkID() {
        return folkID;
    }

    public void setFolkID(short folkID) {
        this.folkID = folkID;
    }

    public short getReligionID() {
        return religionID;
    }

    public void setReligionID(short religionID) {
        this.religionID = religionID;
    }

    public short getNationID() {
        return nationID;
    }

    public void setNationID(short nationID) {
        this.nationID = nationID;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isMariage() {
        return mariage;
    }

    public void setMariage(boolean mariage) {
        this.mariage = mariage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String Add) {
        this.Add = Add;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getIDPlace() {
        return IDPlace;
    }

    public void setIDPlace(String IDPlace) {
        this.IDPlace = IDPlace;
    }

    public short getRegionID() {
        return regionID;
    }

    public void setRegionID(short regionID) {
        this.regionID = regionID;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public short getBankID() {
        return bankID;
    }

    public void setBankID(short bankID) {
        this.bankID = bankID;
    }

}
