/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;

import entities.EmployeeUnion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huy Hung
 */
public class UnionDAO {

    private DBConnection dbc = new DBConnection();
    private static final String TABLE_UNION = "tblCongDoan";

    public Vector<EmployeeUnion> getAllListUnion() {
        String sqlQuery = "SELECT nv.MaNV, nv.HoDem + ' ' +nv.Ten, tt.TenTrangThai,cv.TenChucVu, cd.NgayThamGia, cd.CoThamGia"
                + "     FROM tblNhanVien as nv INNER JOIN tblCongDoan cd ON nv.MaNV = cd.MaNV"
                + "	INNER JOIN tblChucVu AS cv ON cv.MaChucVu = nv.MaChucVu"
                + "	INNER JOIN tblTrangThaiLV AS tt ON tt.MaTrangThai = nv.MaTrangThai"
                + "     ORDER BY nv.Ten ASC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<EmployeeUnion> vt =  new Vector<>();;
        if(dbc.connect()){
            try {
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    EmployeeUnion e = new EmployeeUnion(rs.getString(1),rs.getNString(2),rs.getNString(3),
                    rs.getNString(4),rs.getDate(5),rs.getBoolean(6));
                    vt.add(e);
                }
                return vt;
            } catch (SQLException ex) {
                Logger.getLogger(UnionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                dbc.close(ps, rs);
            }
        }
        return null;
    }

    public void insertUnion(String personelID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + TABLE_UNION + " VALUES(?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personelID);
                ps.setNull(2, java.sql.Types.DATE);
                ps.setBoolean(3, false);
                rs = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                dbc.close(ps, rs);
            }

        }
    }
}
