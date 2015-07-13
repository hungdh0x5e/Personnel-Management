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
public class DocumentsDetails {

    private short ID_IDENTITY;
    private String name;
    private String extension;
    private short kindID;
    private Date saveDate;
    private byte[] file;

    public short getID_IDENTITY() {
        return ID_IDENTITY;
    }

    public void setID_IDENTITY(short ID_IDENTITY) {
        this.ID_IDENTITY = ID_IDENTITY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public short getKindID() {
        return kindID;
    }

    public void setKindID(short kindID) {
        this.kindID = kindID;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

}
