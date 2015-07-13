/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Huy Hung
 */
public class CompanyDetails {

    private String TenCtyVN;
    private String TenCtyEN;
    private String TenVietTat;
    private String TenGiamDoc;
    private String SoDienThoai;
    private String SoFax;
    private String SoTaiKhoan;
    private String DiaChiVN;
    private String DiaChiEN;
    private String MaSoThue;
    private Date NgayDangKy;
    private byte[] Logo;

//    public CompanyDetails(String TenCtyVN, String TenCtyEN, String TenVietTat, String TenGiamDoc, String SoDienThoai, String SoFax, String SoTaiKhoan, String DiaChiVN, String DiaChiEN, String MaSoThue, Date NgayDangKy, byte[] Logo) {
//        this.TenCtyVN = TenCtyVN;
//        this.TenCtyEN = TenCtyEN;
//        this.TenVietTat = TenVietTat;
//        this.TenGiamDoc = TenGiamDoc;
//        this.SoDienThoai = SoDienThoai;
//        this.SoFax = SoFax;
//        this.SoTaiKhoan = SoTaiKhoan;
//        this.DiaChiVN = DiaChiVN;
//        this.DiaChiEN = DiaChiEN;
//        this.MaSoThue = MaSoThue;
//        this.NgayDangKy = NgayDangKy;
//        this.Logo = Logo;
//    }

    public String getTenCtyVN() {
        return TenCtyVN;
    }

    public void setTenCtyVN(String TenCtyVN) {
        this.TenCtyVN = TenCtyVN;
    }

    public String getTenCtyEN() {
        return TenCtyEN;
    }

    public void setTenCtyEN(String TenCtyEN) {
        this.TenCtyEN = TenCtyEN;
    }

    public String getTenVietTat() {
        return TenVietTat;
    }

    public void setTenVietTat(String TenVietTat) {
        this.TenVietTat = TenVietTat;
    }

    public String getTenGiamDoc() {
        return TenGiamDoc;
    }

    public void setTenGiamDoc(String TenGiamDoc) {
        this.TenGiamDoc = TenGiamDoc;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getSoFax() {
        return SoFax;
    }

    public void setSoFax(String SoFax) {
        this.SoFax = SoFax;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public void setSoTaiKhoan(String SoTaiKhoan) {
        this.SoTaiKhoan = SoTaiKhoan;
    }

    public String getDiaChiVN() {
        return DiaChiVN;
    }

    public void setDiaChiVN(String DiaChiVN) {
        this.DiaChiVN = DiaChiVN;
    }

    public String getDiaChiEN() {
        return DiaChiEN;
    }

    public void setDiaChiEN(String DiaChiEN) {
        this.DiaChiEN = DiaChiEN;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String MaSoThue) {
        this.MaSoThue = MaSoThue;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    public byte[] getLogo() {
        return Logo;
    }

    public void setLogo(byte[] Logo) {
        this.Logo = Logo;
    }
    
    
}
