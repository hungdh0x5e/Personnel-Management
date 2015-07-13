/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.NameAndSex;
import entities.Office;

/**
 *
 * @author HUNGUYEN
 */
public class OfficeDAO {

    private final String PERSONNEL_INFO = "tblNhanVien";
    private final String PERSONNEL_COLUMN = "HoDem,Ten,GioiTinh";
    private DBConnection dbc = new DBConnection();

    public ArrayList<Office> getOfficeList() {
        ArrayList<Office> ol = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select MaPhongBan,TenPhongBan from tblPhongBan";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Office o = new Office();

                    o.setOfficeID(rs.getShort(1));
                    o.setOfficeName(rs.getString(2));

                    ol.add(o);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ol;
    }

    public ArrayList<NameAndSex> loadPersonnel(short officeID) {
        ArrayList<NameAndSex> pList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + PERSONNEL_COLUMN + " from " + PERSONNEL_INFO + " where MaPhongBan =" + officeID;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                while (rs.next()) {
                    NameAndSex nam = new NameAndSex();
                    String fullName = rs.getString(1) + " " + rs.getString(2);
                    nam.setName(fullName);
                    nam.setSex(rs.getShort(3));
//                    System.out.println(fullName);
                    pList.add(nam);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pList;
    }

//    public static void main(String[] args) {
//        OfficeDAO o = new OfficeDAO();
//        o.loadPersonnel((short) 1);
//        ArrayList<Office> a = o.getOfficeList();
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i).getOfficeName() + a.get(i).getOfficeID());
//            ArrayList<NameAndSex> n = o.loadPersonnel(a.get(i).getOfficeID());
//            for (int j)
//        }
//    }
}
