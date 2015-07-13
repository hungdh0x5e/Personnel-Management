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
public class EmployeeUnion {

    private String MaNV;
    private String TenNV;
    private String TinhTrang;
    private String ChucVu;

    private Date NgayThamGia;
    private boolean thamGia;

    public EmployeeUnion(String MaNV, String TenNV, String TinhTrang,String ChucVu, Date NgayThamGia, boolean thamGia) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.TinhTrang = TinhTrang;
        this.ChucVu = ChucVu;
        this.NgayThamGia = NgayThamGia;
        this.thamGia = thamGia;
    }

            //"Loại tình trạng","Chức vụ", "Ngày tham gia", "Có tham gia"};
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Date getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(Date NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }

    public boolean isThamGia() {
        return thamGia;
    }

    public void setThamGia(boolean thamGia) {
        this.thamGia = thamGia;
    }
}
