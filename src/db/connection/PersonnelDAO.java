/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.connection;

import entities.ComboBoxItems;
import entities.CompanyDetails;
import entities.Contract;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.DocumentsDetails;
import entities.Education;
import entities.Experience;
import entities.FamilyDetails;
import entities.HealthStatus;
import entities.Office;
import entities.PersonnelBasic;
import entities.PersonnelDetails;
import entities.Skill;

/**
 *
 * @author HUNGUYEN
 */
public class PersonnelDAO {

    //Các tbl được load vào Combobox
    private final String STATUS_CB = "tblTrangThaiLV";
    private final String KIND_CB = "tblLoaiNV";
    private final String POSITION_CB = "tblChucVu";
    private final String CONTRACT_CB = "tblLoaiHopDong";
    private final String FOLK_CB = "tblDanToc";
    private final String RELIGION_CB = "tblTonGiao";
    private final String NATION_CB = "tblQuocGia";
    private final String REGION_CB = "tblTinh";
    private final String BANK_CB = "tblNganHang";
    private final String RELATION_CB = "tblMoiQuanHe";
    private final String BLOOD_CB = "tblNhomMau";
    private final String SKILL_LEVEL_CB = "tblXepLoaiKyNang";
    private final String SKILL_CB = "tblKyNang";
    private final String OFFICE_CB = "tblPhongBan";
    private final String KIND_OF_EDU_CB = "tblLoaiHocVan";
    private final String CERTIFICATION_CB = "tblLoaiTotNghiep";
    private final String HEALTH_STATUS_CB = "tblTinhTrangSK";
    private final String KIND_OF_DOC_CB = "tblLoaiTaiLieu";

    public final ArrayList<String> tblName;

    public PersonnelDAO() {
        super();
        tblName = new ArrayList<>();
        tblName.add(STATUS_CB);
        tblName.add(KIND_CB);
        tblName.add(POSITION_CB);
        tblName.add(OFFICE_CB);
        tblName.add(CONTRACT_CB);
        tblName.add(NATION_CB);
        tblName.add(FOLK_CB);
        tblName.add(RELIGION_CB);
        tblName.add(REGION_CB);
        tblName.add(BANK_CB);
        tblName.add(BLOOD_CB);
        tblName.add(HEALTH_STATUS_CB);
        tblName.add(RELATION_CB);
        tblName.add(KIND_OF_EDU_CB);
        tblName.add(CERTIFICATION_CB);
        tblName.add(SKILL_CB);
        tblName.add(SKILL_LEVEL_CB);
        tblName.add(KIND_OF_DOC_CB);

        personnelTable = new ArrayList<>();
        personnelTable.add(PERSONNEL_INFO);
        personnelTable.add(HEALTH_STATUS);
        personnelTable.add(FAMILY);
        personnelTable.add(EDUCATION);
        personnelTable.add(SKILL_INFO);
        personnelTable.add(EXPERIENCE_INFO);
        personnelTable.add(DOC_INFO);

        tblID = new ArrayList<>();
        tblID.add(HEALTH_ID);
        tblID.add(FAMILY_ID);
        tblID.add(EDU_ID);
        tblID.add(SKILL_ID);
        tblID.add(EXP_ID);
        tblID.add(DOC_ID);
    }

    public String getKIND_OF_DOC_CB() {
        return KIND_OF_DOC_CB;
    }

    public String getHEALTH_STATUS_CB() {
        return HEALTH_STATUS_CB;
    }

    public String getSKILL_LEVEL_CB() {
        return SKILL_LEVEL_CB;
    }

    public String getSKILL_CB() {
        return SKILL_CB;
    }

    public String getKIND_OF_EDU_CB() {
        return KIND_OF_EDU_CB;
    }

    public String getCERTIFICATION_CB() {
        return CERTIFICATION_CB;
    }

    public String getSTATUS_CB() {
        return STATUS_CB;
    }

    public String getKIND_CB() {
        return KIND_CB;
    }

    public String getPOSITION_CB() {
        return POSITION_CB;
    }

    public String getCONTRACT_CB() {
        return CONTRACT_CB;
    }

    public String getFOLK_CB() {
        return FOLK_CB;
    }

    public String getRELIGION_CB() {
        return RELIGION_CB;
    }

    public String getNATION_CB() {
        return NATION_CB;
    }

    public String getREGION_CB() {
        return REGION_CB;
    }

    public String getBANK_CB() {
        return BANK_CB;
    }

    public String getRELATION_CB() {
        return RELATION_CB;
    }

    public String getBLOOD_CB() {
        return BLOOD_CB;
    }

    public String getOFFICE_CB() {
        return OFFICE_CB;
    }

    //Khai báo tên các tbl
    private final String PERSONNEL_INFO = "tblNhanVien";
    private final String HEALTH_STATUS = "tblSucKhoe";
    private final String SKILL_INFO = "tblThongTinKyNang";
    private final String FAMILY = "tblGiaDinh";
    private final String EDUCATION = "tblThongTinHocVan";
    private final String EXPERIENCE_INFO = "tblKinhNghiemLV";
    private final String DOC_INFO = "tblTaiLieu";
    private final String COMPANY_INFO = "tblThongTinCongTy";
    public final ArrayList<String> personnelTable;

    //Các cột được chọn cho từng bảng
    private final String FAMILY_COLUMN = "MaMQH,Ten,NgaySinh,NgheNghiep,DiaChi,SDT,MaGiaDinh";
    private final String HEALTH_COLUMN = "NgayKham,TenBenhVien,ChieuCao,CanNang,ThiLuc,MaNhomMau,MaTinhTrangSK,GhiChu,MaPhieuSK";
    private final String EDUCATION_COLUMN = "MaLoaiHocVan,MaLoaiTotNghiep,TenKhoaHoc,TenTruong,TuNam,DenNam,MaThongTinHocVan";
    private final String SKILL_COLUMN = "MaKyNang,MaXepLoaiKyNang,NgayHieuLuc,GhiChu,MaThongTinKyNang";
    private final String EXPERIENCE_COLUMN = "TenCty,ChucDanh,CongViec,TimeBatDau,TimeKetThuc,LiDo,TenNguoiLienHe,SDT,Email,ChucVu,MaKinhNghiemLV";
    private final String DOC_COLUMN = "Name,NgayLuu,Dulieu,PhanMoRong,MaLoaiTL,MaTaiLieu";

    private final String FAMILY_ID = "MaGiaDinh";
    private final String HEALTH_ID = "MaPhieuSK";
    private final String EDU_ID = "MaThongTinHocVan";
    private final String SKILL_ID = "MaThongTinKyNang";
    private final String EXP_ID = "MaKinhNghiemLV";
    private final String DOC_ID = "MaTaiLieu";
    public final ArrayList<String> tblID;

    private final String PERSONNEL_BASIC_COLUMN = "MaNV,HoDem,Ten,NgaySinh,GioiTinh,MaPhongBan,MaChucVu,MaLoaiNV,MaLoaiHopDong,SDT,EmailRieng,EmailCty";
    private final String ID_COLUMN = "MaNV";

    private final DBConnection dbc = new DBConnection();

    public PersonnelDetails getPersonnelDetails(String personnelID) {
        PersonnelDetails pd = new PersonnelDetails();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select * from " + PERSONNEL_INFO + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                //retrieve data from db by PersonnelID
                while (rs.next()) {

                    pd.setPersonnelID(rs.getString(1));
                    pd.setlName(rs.getString(2));
                    pd.setfName(rs.getString(3));
                    pd.setNickName(rs.getString(4));

                    pd.setStatusID(rs.getShort(5));
                    pd.setKindID(rs.getShort(6));
                    pd.setContractID(rs.getShort(7));
                    pd.setPosID(rs.getShort(8));
                    pd.setOfficeID(rs.getShort(9));

                    pd.setEnterDate(rs.getDate(10));

                    pd.setStartDate(rs.getDate(11));
                    pd.setSex(rs.getBoolean(12));
                    pd.setPhoneNum(rs.getString(13));
                    pd.setCompEmail(rs.getString(14));
                    pd.setEndTraining(rs.getDate(15));

                    pd.setPic(rs.getBytes(16));
                    pd.setBirth(rs.getDate(17));
                    pd.setPlaceOB(rs.getString(18));
                    pd.setRecentAdd(rs.getString(19));

                    pd.setFolkID(rs.getShort(20));
                    pd.setReligionID(rs.getShort(21));
                    pd.setNationID(rs.getShort(22));
                    pd.setPersonalEmail(rs.getString(23));
                    pd.setMariage(rs.getBoolean(24));
                    pd.setEducation(rs.getString(25));
                    pd.setAdd(rs.getString(26));
                    pd.setIDNum(rs.getString(27));
                    pd.setIDDay(rs.getDate(28));
                    pd.setRegionID(rs.getShort(29));
//                    System.out.println(rs.getShort(29));
                    pd.setBankCode(rs.getString(30));
                    pd.setBankID(rs.getShort(31));
                    pd.setIDPlace(rs.getString(32));
                    pd.setTaxCode(rs.getString(33));
                }
                dbc.close(ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pd;
    }

    public ArrayList<ComboBoxItems> getList(String tblName) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ComboBoxItems> list = new ArrayList<>();
        if (dbc.connect()) {
            try {
                String sqlQuery = "select * from " + tblName;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ComboBoxItems cbItem = new ComboBoxItems(rs.getShort(1), rs.getString(2));
                    list.add(cbItem);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public String getPersonnelInfo(String attribute, String tblName, String condition, short ID) {
        PreparedStatement ps;
        ResultSet rs;
        String name = null;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + attribute + " from " + tblName + " where " + condition + " = " + ID;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                rs.next();
                name = rs.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }

    public ArrayList<FamilyDetails> getFamilyDetails(String personnelID) {
        ArrayList<FamilyDetails> fdList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + FAMILY_COLUMN + " from " + FAMILY + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    FamilyDetails fd = new FamilyDetails();

                    fd.setRelationID(rs.getShort(1));
                    fd.setPerName(rs.getString(2));
                    fd.setPerBirth(rs.getDate(3));
                    fd.setPerJob(rs.getString(4));
                    fd.setPerAdd(rs.getString(5));
                    fd.setPerPhone(rs.getString(6));
                    fd.setID_IDENTITY(rs.getShort(7));

                    fdList.add(fd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fdList;
    }

    public ArrayList<HealthStatus> getHealthStatus(String personnelID) {
        ArrayList<HealthStatus> hsList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + HEALTH_COLUMN + " from " + HEALTH_STATUS + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    HealthStatus hs = new HealthStatus();

                    hs.setHealDate(rs.getDate(1));
                    hs.setHospital(rs.getString(2));
                    hs.setHeight(rs.getShort(3));
                    hs.setWeight(rs.getShort(4));
                    hs.setSight(rs.getString(5));
                    hs.setBloodID(rs.getShort(6));
                    hs.setHealthStatusID(rs.getShort(7));
                    hs.setNote(rs.getString(8));
                    hs.setID_IDENTITY(rs.getShort(9));

                    hsList.add(hs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hsList;
    }

    public ArrayList<Education> getEducation(String personnelID) {
        ArrayList<Education> edList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + EDUCATION_COLUMN + " from " + EDUCATION + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Education ed = new Education();

                    ed.setKindID(rs.getShort(1));
                    ed.setGraduationID(rs.getShort(2));
                    ed.setCourseName(rs.getString(3));
                    ed.setSchoolName(rs.getString(4));
                    ed.setFromYear(rs.getShort(5));
                    ed.setToYear(rs.getShort(6));
                    ed.setID_IDENTITY(rs.getShort(7));

                    edList.add(ed);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return edList;
    }

    public ArrayList<Skill> getSkill(String personnelID) {
        ArrayList<Skill> skList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + SKILL_COLUMN + " from " + SKILL_INFO + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Skill sk = new Skill();

                    sk.setNameID(rs.getShort(1));
                    sk.setClassificationID(rs.getShort(2));
                    sk.setEffectiveDate(rs.getDate(3));
                    sk.setNote(rs.getString(4));
                    sk.setID_IDENTITY(rs.getShort(5));

                    skList.add(sk);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return skList;
    }

    public ArrayList<Experience> getExperience(String personnelID) {
        ArrayList<Experience> exList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + EXPERIENCE_COLUMN + " from " + EXPERIENCE_INFO + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Experience ex = new Experience();

                    ex.setCompName(rs.getString(1));
                    ex.setPos(rs.getString(2));
                    ex.setJob(rs.getString(3));
                    ex.setStartDate(rs.getDate(4));
                    ex.setEndDate(rs.getDate(5));

                    ex.setReferName(rs.getString(6));
                    ex.setReferPhone(rs.getString(7));
                    ex.setReferEmail(rs.getString(8));
                    ex.setReferPos(rs.getString(9));
                    ex.setID_IDENTITY(rs.getShort(10));

                    exList.add(ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return exList;
    }

    public ArrayList<DocumentsDetails> getDocumentsDetails(String personnelID) {
        ArrayList<DocumentsDetails> docList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + DOC_COLUMN + " from " + DOC_INFO + " where MaNV = '" + personnelID + "'";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    DocumentsDetails doc = new DocumentsDetails();

                    doc.setName(rs.getNString(1));
                    doc.setSaveDate(rs.getDate(2));
                    doc.setFile(rs.getBytes(3));
                    doc.setExtension(rs.getString(4));
                    doc.setKindID(rs.getShort(5));
                    doc.setID_IDENTITY(rs.getShort(6));

                    docList.add(doc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return docList;
    }

    public ArrayList<PersonnelBasic> getRowPersonnelListTable() {
        ArrayList<PersonnelBasic> pbList = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select " + PERSONNEL_BASIC_COLUMN + " from " + PERSONNEL_INFO;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    PersonnelBasic pb = new PersonnelBasic();

                    pb.setPersonnelID(rs.getString(1));
                    pb.setName(rs.getString(2) + " " + rs.getString(3));
                    pb.setBirth(rs.getString(4));

                    boolean sex = rs.getBoolean(5);
                    pb.setSex(sex ? "Nam" : "Nữ");

                    String office = getPersonnelInfo("TenPhongBan", OFFICE_CB, "MaPhongBan", rs.getShort(6));
                    pb.setOffice(office);

                    String position = getPersonnelInfo("TenChucVu", POSITION_CB, "MaChucVu", rs.getShort(7));
                    pb.setPosition(position);

                    String kind = getPersonnelInfo("TenLoaiNV", KIND_CB, "MaLoaiNV", rs.getShort(8));
                    pb.setPerKind(kind);

                    String contract = getPersonnelInfo("TenLoaiHopDong", CONTRACT_CB, "MaLoaiHopDong", rs.getShort(9));
                    pb.setPerContract(contract);

                    pb.setPhone(rs.getString(10));
                    pb.setPerEmail(rs.getString(11));
                    pb.setCompEmail(rs.getString(12));

                    pbList.add(pb);
                }
                dbc.close(ps, rs);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return pbList;
    }

//    public static void main(String[] args) {
//        PersonnelDAO p = new PersonnelDAO();
//        p.getPersonnelDetails("NV0001");
////////
////        String a = p.getPersonnelInfo("TenPhongBan", "tblPhongBan", "MaPhongBan", (short) 1);
////        System.out.println(a);
//////        ArrayList h = p.getList("MaMQH", "tblGiaDinh");
//////        for (int i = 0; i < h.size(); i++) {
//////            System.out.println(h.get(i));
//////        }
//////////        p.getFamilyDetails("NV0001");
//////////        p.getHealthStatus("NV0001");
//////////        p.getEducation("NV0001");
//////////        p.getSkill("NV0001");
//////////        p.getExperience("NV0001");
//////////        p.getDocumentsDetails("NV0001");
//////////        p.getRowPersonnelListTable();
////////        ArrayList<PersonnelBasic> a = p.getRowPersonnelListTable();
////////        for (int i = 0; i < a.size(); i++) {
////////            System.out.println(a.get(i).getName());
////////            System.out.println(a.get(i).getBirth());
////////            System.out.println(a.get(i).getOffice());
//        }
//    }
    public boolean insertPersonnelDetails(PersonnelDetails pd) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + PERSONNEL_INFO + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, pd.getPersonnelID());
                ps.setNString(2, pd.getlName());
                ps.setNString(3, pd.getfName());
                ps.setNString(4, pd.getNickName());
                ps.setShort(5, pd.getStatusID());
                ps.setShort(6, pd.getKindID());
                ps.setShort(7, pd.getContractID());
                ps.setShort(8, pd.getPosID());
                ps.setShort(9, pd.getOfficeID());

                if (pd.getEnterDate() == null) {
                    ps.setNull(10, java.sql.Types.DATE);
                } else {
                    ps.setDate(10, pd.getEnterDate());
                }

                if (pd.getStartDate() == null) {
                    ps.setNull(11, java.sql.Types.DATE);
                } else {
                    ps.setDate(11, pd.getStartDate());
                }

                ps.setBoolean(12, pd.isSex());
                ps.setString(13, pd.getPhoneNum());
                ps.setString(14, pd.getCompEmail());

                if (pd.getEndTraining() == null) {
                    ps.setNull(15, java.sql.Types.DATE);
                } else {
                    ps.setDate(15, pd.getEndTraining());
                }
                ps.setBytes(16, pd.getPic());

                if (pd.getBirth() == null) {
                    ps.setNull(17, java.sql.Types.DATE);
                } else {
                    ps.setDate(17, pd.getBirth());
                }
                ps.setNString(18, pd.getPlaceOB());
                ps.setNString(19, pd.getRecentAdd());
                ps.setShort(20, pd.getFolkID());
                ps.setShort(21, pd.getReligionID());
                ps.setShort(22, pd.getNationID());
                ps.setString(23, pd.getPersonalEmail());
                ps.setBoolean(24, pd.isMariage());
                ps.setString(25, pd.getEducation());
                ps.setNString(26, pd.getAdd());
                ps.setString(27, pd.getIDNum());

                if (pd.getIDDay() == null) {
                    ps.setNull(28, java.sql.Types.DATE);
                } else {
                    ps.setDate(28, pd.getIDDay());
                }
                ps.setShort(29, pd.getRegionID());
                ps.setString(30, pd.getBankCode());
                ps.setShort(31, pd.getBankID());
                ps.setNString(32, pd.getIDPlace());
                ps.setString(33, pd.getTaxCode());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
                dbc.close(ps);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return check;
    }

    public boolean insertHealthStatus(String personnelID, HealthStatus hs) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + HEALTH_STATUS + " VALUES(?,?,?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                if (hs.getHealDate() == null) {
                    ps.setNull(2, java.sql.Types.DATE);
                } else {
                    ps.setDate(2, hs.getHealDate());
                }

                ps.setNString(3, hs.getHospital());
                ps.setShort(4, hs.getHeight());
                ps.setShort(5, hs.getWeight());
                ps.setString(6, hs.getSight());
                ps.setShort(7, hs.getBloodID());
                ps.setShort(8, hs.getHealthStatusID());
                ps.setNString(9, hs.getNote());
                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean insertFamilyDetails(String personnelID, FamilyDetails fd) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + FAMILY + " VALUES(?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                ps.setShort(2, fd.getRelationID());
                ps.setNString(3, fd.getPerName());
                if (fd.getPerBirth() == null) {
                    ps.setNull(4, java.sql.Types.DATE);
                } else {
                    ps.setDate(4, fd.getPerBirth());
                }
                ps.setNString(5, fd.getPerJob());
                ps.setNString(6, fd.getPerAdd());
                ps.setString(7, fd.getPerPhone());
                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean insertEducationInfo(String personnelID, Education edu) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + EDUCATION + " VALUES(?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                ps.setShort(2, edu.getKindID());
                ps.setShort(3, edu.getGraduationID());
                ps.setNString(4, edu.getCourseName());
                ps.setNString(5, edu.getSchoolName());
                ps.setShort(6, edu.getFromYear());
                ps.setShort(7, edu.getToYear());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean insertSkillInfo(String personnelID, Skill sk) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + SKILL_INFO + " VALUES(?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                ps.setShort(2, sk.getNameID());
                ps.setShort(3, sk.getClassificationID());
                ps.setNString(4, sk.getNote());
                if (sk.getEffectiveDate() == null) {
                    ps.setNull(5, java.sql.Types.DATE);
                } else {
                    ps.setDate(5, sk.getEffectiveDate());
                }

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean insertExperience(String personnelID, Experience exp) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + EXPERIENCE_INFO + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                ps.setNString(2, exp.getCompName());
                ps.setNString(3, exp.getPos());
                ps.setNString(4, exp.getJob());
                if (exp.getStartDate() == null) {
                    ps.setNull(5, java.sql.Types.DATE);
                } else {
                    ps.setDate(5, exp.getStartDate());
                }
                if (exp.getEndDate() == null) {
                    ps.setNull(6, java.sql.Types.DATE);
                } else {
                    ps.setDate(6, exp.getEndDate());
                }
                ps.setNString(7, exp.getReason());
                ps.setNString(8, exp.getReferName());
                ps.setString(9, exp.getReferPhone());
                ps.setString(10, exp.getReferEmail());
                ps.setNString(11, exp.getReferPos());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean insertDocumentDetails(String personnelID, DocumentsDetails doc) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + DOC_INFO + " VALUES(?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setString(1, personnelID);
                ps.setNString(2, doc.getName());
                if (doc.getSaveDate() == null) {
                    ps.setNull(3, java.sql.Types.DATE);
                } else {
                    ps.setDate(3, doc.getSaveDate());
                }
                ps.setBytes(4, doc.getFile());
                ps.setString(5, doc.getExtension());
                ps.setShort(6, doc.getKindID());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean updateListTable(String value, String listName) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + listName + " VALUES(?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);

                ps.setNString(1, value);

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public ArrayList<Contract> getContract() {
        ArrayList<Contract> con = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select * from " + getCONTRACT_CB();
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Contract c = new Contract();

                    c.setID(rs.getShort(1));
                    c.setName(rs.getNString(2));
                    c.setMonth(rs.getShort(3));
                    c.setBHXH(rs.getBoolean(4));
                    c.setPercent(rs.getFloat(5));
                    c.setTemplate(rs.getBytes(6));
                    c.setExtension(rs.getString(7));

                    con.add(c);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return con;
    }

    public ArrayList<Office> getOffice() {
        ArrayList<Office> off = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select * from " + getOFFICE_CB();
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Office o = new Office();
                    o.setOfficeID(rs.getShort(1));
                    o.setOfficeName(rs.getNString(2));
                    o.setOfficeNum(rs.getString(3));

                    off.add(o);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return off;
    }

    public boolean updateOfficeList(Office o) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + getOFFICE_CB() + " VALUES(?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);

                ps.setNString(1, o.getOfficeName());
                ps.setString(2, o.getOfficeNum());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean updateContractList(Contract con) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + getCONTRACT_CB() + " VALUES(?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);

                ps.setNString(1, con.getName());
                ps.setShort(2, con.getMonth());
                if (con.isBHXH()) {
                    ps.setBoolean(3, con.isBHXH());
                    ps.setFloat(4, con.getPercent());
                } else {
                    ps.setBoolean(3, con.isBHXH());
                    ps.setNull(4, java.sql.Types.FLOAT);
                }
                ps.setBytes(5, con.getTemplate());
                ps.setString(6, con.getExtension());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean deleteFromList(short id, String listName, String get) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "DELETE FROM " + listName + " WHERE " + get + " = ?";
//                System.out.println(sqlQuery);
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setShort(1, id);

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public void deletePersonnel(String ID) {
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                for (String personnelTable1 : personnelTable) {
                    String sqlQuery = "DELETE FROM " + personnelTable1 + " WHERE " + ID_COLUMN + " = ?";
                    ps = dbc.getConnection().prepareStatement(sqlQuery);
                    ps.setString(1, ID);
                    ps.executeUpdate();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public CompanyDetails getCompanyDetails() {
        CompanyDetails com = new CompanyDetails();
        PreparedStatement ps;
        ResultSet rs;
        if (dbc.connect()) {
            try {
                String sqlQuery = "select * from " + COMPANY_INFO;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                while (rs.next()) {
                    com.setTenCtyVN(rs.getNString(1));
                    System.out.println(rs.getNString(1));
                    com.setTenCtyEN(rs.getString(2));
                    com.setTenVietTat(rs.getString(3));
                    com.setTenGiamDoc(rs.getNString(4));
                    com.setSoDienThoai(rs.getString(5));
                    com.setSoFax(rs.getString(6));
                    com.setSoTaiKhoan(rs.getString(7));
                    com.setDiaChiVN(rs.getNString(8));
                    com.setDiaChiEN(rs.getNString(9));
                    com.setMaSoThue(rs.getString(10));
                    com.setNgayDangKy(rs.getDate(11));
                    com.setLogo(rs.getBytes(12));
                }

            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return com;
    }

    public boolean insertCompanyDetails(CompanyDetails com) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "INSERT INTO " + COMPANY_INFO + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setNString(1, com.getTenCtyVN());
                ps.setString(2, com.getTenCtyEN());
                ps.setString(3, com.getTenVietTat());
                ps.setNString(4, com.getTenGiamDoc());
                ps.setString(5, com.getSoDienThoai());
                ps.setString(6, com.getSoFax());
                ps.setString(7, com.getSoTaiKhoan());
                ps.setNString(8, com.getDiaChiVN());
                ps.setNString(9, com.getDiaChiEN());
                ps.setString(10, com.getMaSoThue());
                if (com.getNgayDangKy() == null) {
                    ps.setNull(11, java.sql.Types.DATE);
                } else {
                    ps.setDate(11, com.getNgayDangKy());
                }

                ps.setBytes(12, com.getLogo());

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public boolean updatePersonnelDetails(PersonnelDetails pd) {
        boolean check = false;
        PreparedStatement ps = null;
        if (dbc.connect()) {
            try {
                String sqlQuery = "update " + PERSONNEL_INFO + " set "
                        + "HoDem = ? ,"
                        + "Ten = ?   ,"
                        + "	Nickname = ?,\n"
                        + "	MaTrangThai = ?,\n"
                        + "	MaLoaiNV = ?,\n"
                        + "	MaLoaiHopDong = ?,\n"
                        + "	MaChucVu = ?,\n"
                        + "	MaPhongBan = ?,\n"
                        + "	NgayVao = ?,\n"
                        + "	NgayBatDau = ?,\n"
                        + "	GioiTinh = ?,\n"
                        + "	SDT = ?,\n"
                        + "	EmailCty = ?,\n"
                        + "	NgayKTthuViec = ?,\n"
                        + "	HinhAnh = ?,\n"
                        + "	NgaySinh = ?,\n"
                        + "	NguyenQuan = ?,\n"
                        + "	ThuongTru = ?,\n"
                        + "	MaDanToc = ?,\n"
                        + "	MaTonGiao = ?,\n"
                        + "	MaQuocGia = ?,\n"
                        + "	EmailRieng = ?,\n"
                        + "	KetHon = ?,\n"
                        + "	TrinhDoVH = ?,\n"
                        + "	DiaChi = ?,\n"
                        + "	SoCMT = ?,\n"
                        + "	NgayCap = ?,\n"
                        + "	MaTinh = ?,\n"
                        + "	SoTK = ?,\n"
                        + "	MaNH = ?,\n"
                        + "	NoiCap = ?,\n"
                        + "	MaSoThue = ?\n"
                        + "where MaNV = ?";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setNString(1, pd.getlName());
                ps.setNString(2, pd.getfName());
                ps.setNString(3, pd.getNickName());
                ps.setShort(4, pd.getStatusID());
                ps.setShort(5, pd.getKindID());
                ps.setShort(6, pd.getContractID());
                ps.setShort(7, pd.getPosID());
                ps.setShort(8, pd.getOfficeID());

                if (pd.getEnterDate() == null) {
                    ps.setNull(9, java.sql.Types.DATE);
                } else {
                    ps.setDate(9, pd.getEnterDate());

                }

                if (pd.getStartDate() == null) {
                    ps.setNull(10, java.sql.Types.DATE);
                } else {
                    ps.setDate(10, pd.getStartDate());
                }

                ps.setBoolean(11, pd.isSex());
                ps.setString(12, pd.getPhoneNum());
                ps.setString(13, pd.getCompEmail());

                if (pd.getEndTraining() == null) {
                    ps.setNull(14, java.sql.Types.DATE);
                } else {
                    ps.setDate(14, pd.getEndTraining());
                }

                ps.setBytes(15, pd.getPic());

                if (pd.getBirth() == null) {
                    ps.setNull(16, java.sql.Types.DATE);
                } else {
                    ps.setDate(16, pd.getBirth());
                }
                ps.setNString(17, pd.getPlaceOB());
                ps.setNString(18, pd.getRecentAdd());
                ps.setShort(19, pd.getFolkID());
                ps.setShort(20, pd.getReligionID());
                ps.setShort(21, pd.getNationID());
                ps.setString(22, pd.getPersonalEmail());
                ps.setBoolean(23, pd.isMariage());
                ps.setString(24, pd.getEducation());
                ps.setNString(25, pd.getAdd());
                ps.setString(26, pd.getIDNum());

                if (pd.getIDDay() == null) {
                    ps.setNull(27, java.sql.Types.DATE);
                } else {
                    ps.setDate(27, pd.getIDDay());
                }
                ps.setShort(28, pd.getRegionID());
                ps.setString(29, pd.getBankCode());
                ps.setShort(30, pd.getBankID());
                ps.setNString(31, pd.getIDPlace());
                ps.setString(32, pd.getTaxCode());
                ps.setString(33, pd.getPersonnelID());

                if (ps.executeUpdate() > 0) {
                    check = true;
                }
                dbc.close(ps);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                dbc.close(ps);
            }
        }

        return check;
    }

    public boolean deleteTableInfo(String tbl, String idField, short ID) {
        boolean check = true;
        PreparedStatement ps;
        if (dbc.connect()) {
            try {
                String sqlQuery = "DELETE FROM " + tbl + " WHERE " + idField + " = ?";
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                ps.setShort(1, ID);

                if (ps.executeUpdate() < 1) {
                    check = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return check;
    }

    public short getLastIndex(String IDField, String tbl) {
        PreparedStatement ps;
        ResultSet rs;
        short lastID = -1;
        if (dbc.connect()) {
            try {
                String sqlQuery = "SELECT " + IDField + " FROM " + tbl;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();

                while (rs.next()) {
                    lastID = rs.getShort(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lastID;
    }

    public String getMaxID() {
        PreparedStatement ps;
        ResultSet rs;
        String result = "";
        if (dbc.connect()) {
            try {
                String sqlQuery = "SELECT MAX(MaNV) FROM " + PERSONNEL_INFO;
                ps = dbc.getConnection().prepareStatement(sqlQuery);
                rs = ps.executeQuery();
                rs.next();
                result = rs.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new PersonnelDAO().getMaxID());
    }
}
