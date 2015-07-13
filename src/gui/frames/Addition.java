/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.frames;

import db.connection.PersonnelDAO;
import entities.ComboBoxItems;
import entities.Contract;
import entities.FileTypeFilter;
import entities.Office;
import gui.panel.PanelInfo;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HUNGUYEN
 */
public class Addition extends javax.swing.JDialog {

    /**
     * Creates new form Addition
     */
    private PanelInfo info;
    private JComboBox cbox;
    private int addMode;
    private byte[] template;
    private String fileExtension;

    public byte[] getTemplate() {
        return template;
    }

    public void setTemplate(byte[] template) {
        this.template = template;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public int getMode() {
        return addMode;
    }

    public void setMode(int mode) {
        this.addMode = mode;
    }

    private PersonnelDAO pDAO = new PersonnelDAO();
    DefaultTableModel listModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    private String listName;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    private ArrayList<ComboBoxItems> rowData;
    private ArrayList<Contract> contractData;
    private ArrayList<Office> officeData;
    private ArrayList<byte[]> contractTemp = new ArrayList<>();

    private ArrayList<Object[]> columnArray;
    private final Object[] personnelStatus = {"Mã trạng thái", "Tên trạng thái làm việc"};
    private final Object[] personnelKind = {"Mã loại nhân viên", "Tên loại nhân viên"};
    private final Object[] personnelPos = {"Mã chức vụ", "Tên chức vụ"};
    private final Object[] personnelOffice = {"Mã phòng ban", "Tên phòng ban", "Số phòng"};
    private final Object[] personnelContract = {"Mã hợp đồng", "Tên hợp đồng",
        "Số tháng", "Đóng BHXH", "Tỉ lệ đóng", "Mẫu hợp đồng"};
    private final Object[] personnelNation = {"Mã quốc gia", "Tên quốc gia"};
    private final Object[] personnelFolk = {"Mã dân tộc", "Tên dân tộc"};
    private final Object[] personnelReligion = {"Mã tôn giáo", "Tên tôn giáo"};
    private final Object[] personnelRegion = {"Mã tỉnh", "Tên tỉnh"};
    private final Object[] personnelBank = {"Mã ngân hàng", "Tên ngân hàng"};
    private final Object[] personnelBlood = {"Mã nhóm máu", "Tên nhóm máu"};
    private final Object[] personnelHealth = {"Mã tình trạng sức khỏe", "Tên tình trạng sức khỏe"};
    private final Object[] famRelationship = {"Mã quan hệ", "Mối quan hệ"};
    private final Object[] eduKind = {"Mã loại học vấn", "Tên loại học vấn"};
    private final Object[] eduGraduattion = {"Mã tốt nghiệp", "Tên loại tốt nghiệp"};
    private final Object[] skillKind = {"Mã kỹ năng", "Tên kỹ năng"};
    private final Object[] skillRank = {"Mã xếp loại", "Xếp loại"};
    private final Object[] docKind = {"Mã tài liệu", "Tên loại tài liệu"};

    private final String status = "MaTrangThai";
    private final String kind = "MaLoaiNV";
    private final String pos = "MaChucVu";
    private final String off = "MaPhongBan";
    private final String con = "MaLoaiHopDong";
    private final String nation = "MaQuocGia";
    private final String folk = "MaDanToc";
    private final String religion = "MaTonGiao";
    private final String region = "MaTinh";
    private final String bank = "MaNH";
    private final String blood = "MaNhomMau";
    private final String health = "MaTinhTrangSK";
    private final String relation = "MaMQH";
    private final String edukind = "MaLoaiHocVan";
    private final String edugrat = "MaLoaiTotNghiep";
    private final String skkind = "MaKyNang";
    private final String skrank = "MaXepLoaiKyNang";
    private final String doc = "MaLoaiTL";
    private ArrayList<String> columnInSQL;

    public void setColumnInSQL() {
        columnInSQL = new ArrayList<>();
        columnInSQL.add(status);
        columnInSQL.add(kind);
        columnInSQL.add(pos);
        columnInSQL.add(off);
        columnInSQL.add(con);
        columnInSQL.add(nation);
        columnInSQL.add(folk);
        columnInSQL.add(religion);
        columnInSQL.add(region);
        columnInSQL.add(bank);
        columnInSQL.add(blood);
        columnInSQL.add(health);
        columnInSQL.add(relation);
        columnInSQL.add(edukind);
        columnInSQL.add(edugrat);
        columnInSQL.add(skkind);
        columnInSQL.add(skrank);
        columnInSQL.add(doc);
    }

    private void setColumnArray() {
        columnArray = new ArrayList<>();
        this.columnArray.add(personnelStatus);
        this.columnArray.add(personnelKind);
        this.columnArray.add(personnelPos);
        this.columnArray.add(personnelOffice);
        this.columnArray.add(personnelContract);
        this.columnArray.add(personnelNation);
        this.columnArray.add(personnelFolk);
        this.columnArray.add(personnelReligion);
        this.columnArray.add(personnelRegion);
        this.columnArray.add(personnelBank);
        this.columnArray.add(personnelBlood);
        this.columnArray.add(personnelHealth);
        this.columnArray.add(famRelationship);
        this.columnArray.add(eduKind);
        this.columnArray.add(eduGraduattion);
        this.columnArray.add(skillKind);
        this.columnArray.add(skillRank);
        this.columnArray.add(docKind);
    }

    public Addition(java.awt.Frame parent, boolean modal, int mode, PanelInfo info, JComboBox cbox) {
        super(parent, modal);
        initComponents();
        this.info = info;
        this.cbox = cbox;
        cbox.setSelectedIndex(0);
        btOpenContract.setVisible(false);
        setFrame();
        setColumnArray();
        setColumnInSQL();
        loadTable(mode);
        setTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOption = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btDel = new javax.swing.JButton();
        pnOtherList = new javax.swing.JPanel();
        tfAdd = new javax.swing.JTextField();
        pnContractList = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfContractName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfContractMonth = new javax.swing.JTextField();
        tfContractPercent = new javax.swing.JTextField();
        tfContractTemplate = new javax.swing.JTextField();
        rbYes = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        btSaveFile = new javax.swing.JButton();
        pnOfficeList = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfOfficeName = new javax.swing.JTextField();
        tfOfficeNum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btOpenContract = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(488, 378));
        setMinimumSize(new java.awt.Dimension(488, 378));

        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbList);

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/Add.png"))); // NOI18N
        btAdd.setText("Thêm");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/Delete.png"))); // NOI18N
        btDel.setText("Xóa");
        btDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelActionPerformed(evt);
            }
        });

        pnOtherList.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm vào danh sách"));

        javax.swing.GroupLayout pnOtherListLayout = new javax.swing.GroupLayout(pnOtherList);
        pnOtherList.setLayout(pnOtherListLayout);
        pnOtherListLayout.setHorizontalGroup(
            pnOtherListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOtherListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnOtherListLayout.setVerticalGroup(
            pnOtherListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnOtherListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfAdd)
                .addContainerGap())
        );

        pnContractList.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm vào danh sách"));

        jLabel1.setText("Tên loại hợp đồng:");

        jLabel2.setText("Đóng BHXH:");

        jLabel3.setText("Tỉ lệ đóng:");

        jLabel4.setText("Số tháng:");

        jLabel5.setText("Mẫu hợp đồng:");

        bgOption.add(rbYes);
        rbYes.setText("Có");
        rbYes.setActionCommand("Có");
        rbYes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbYesStateChanged(evt);
            }
        });

        bgOption.add(rbNo);
        rbNo.setText("Không");
        rbNo.setActionCommand("Không");

        btSaveFile.setText("...");
        btSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnContractListLayout = new javax.swing.GroupLayout(pnContractList);
        pnContractList.setLayout(pnContractListLayout);
        pnContractListLayout.setHorizontalGroup(
            pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContractListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfContractName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnContractListLayout.createSequentialGroup()
                        .addComponent(rbYes)
                        .addGap(18, 18, 18)
                        .addComponent(rbNo))
                    .addComponent(tfContractPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContractListLayout.createSequentialGroup()
                        .addComponent(tfContractTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfContractMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnContractListLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel4, jLabel5});

        pnContractListLayout.setVerticalGroup(
            pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContractListLayout.createSequentialGroup()
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfContractName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfContractMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbYes)
                        .addComponent(rbNo)
                        .addComponent(jLabel5)
                        .addComponent(tfContractTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnContractListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfContractPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnContractListLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btSaveFile, tfContractTemplate});

        pnOfficeList.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm vào danh sách"));

        jLabel6.setText("Tên phòng ban:");

        jLabel7.setText("Số phòng:");

        javax.swing.GroupLayout pnOfficeListLayout = new javax.swing.GroupLayout(pnOfficeList);
        pnOfficeList.setLayout(pnOfficeListLayout);
        pnOfficeListLayout.setHorizontalGroup(
            pnOfficeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOfficeListLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfOfficeName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfOfficeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnOfficeListLayout.setVerticalGroup(
            pnOfficeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOfficeListLayout.createSequentialGroup()
                .addGroup(pnOfficeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOfficeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tfOfficeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnOfficeListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfOfficeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btOpenContract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/Files.png"))); // NOI18N
        btOpenContract.setText("Xem mẫu HĐ");
        btOpenContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpenContractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnOtherList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btOpenContract)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnContractList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnOfficeList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnOtherList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnContractList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnOfficeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btDel)
                        .addComponent(btOpenContract)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelActionPerformed
        int row = tbList.getSelectedRow();
        short id = Short.parseShort(tbList.getValueAt(row, 0).toString());
        deleteFromList(id, row);
    }//GEN-LAST:event_btDelActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        switch (getMode()) {
            case 1:
                String value = tfAdd.getText();
                if (pDAO.updateListTable(value, this.listName)) {
                    addRowtoOtherList(value);
                }
                resetCbox();
                break;
            case 2:
                insertContract();
                resetCbox();
                break;
            case 3:
                insertOffice();
                resetCbox();
                break;
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btOpenContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpenContractActionPerformed
        showFileChooser(2);
    }//GEN-LAST:event_btOpenContractActionPerformed

    private void rbYesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbYesStateChanged
        if (rbYes.isSelected()) {
            tfContractPercent.setEditable(true);
        } else {
            tfContractPercent.setEditable(false);
            tfContractPercent.setText("");
        }
    }//GEN-LAST:event_rbYesStateChanged

    private void btSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveFileActionPerformed
        showFileChooser(1);
    }//GEN-LAST:event_btSaveFileActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Addition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Addition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Addition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Addition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Addition dialog = new Addition(new javax.swing.JFrame(), true, 5,new InfoPanel());
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOption;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDel;
    private javax.swing.JButton btOpenContract;
    private javax.swing.JButton btSaveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnContractList;
    private javax.swing.JPanel pnOfficeList;
    private javax.swing.JPanel pnOtherList;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbYes;
    private javax.swing.JTable tbList;
    private javax.swing.JTextField tfAdd;
    private javax.swing.JTextField tfContractMonth;
    private javax.swing.JTextField tfContractName;
    private javax.swing.JTextField tfContractPercent;
    private javax.swing.JTextField tfContractTemplate;
    private javax.swing.JTextField tfOfficeName;
    private javax.swing.JTextField tfOfficeNum;
    // End of variables declaration//GEN-END:variables
    private void setFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    private void loadTable(int mode) {
        listModel.setColumnIdentifiers(columnArray.get(mode - 1));
        setListName(pDAO.tblName.get(mode - 1));
        if (mode != 5 && mode != 4) {
            setMode(1);
            pnOtherList.setVisible(true);
            pnOfficeList.setVisible(false);
            pnContractList.setVisible(false);
            loadRowData(this.listName);
        } else {
            if (mode == 5) {
                setMode(2);
                pnOtherList.setVisible(false);
                pnOfficeList.setVisible(false);
                pnContractList.setVisible(true);
                btOpenContract.setVisible(true);
                loadContract();
            } else {
                setMode(3);
                pnOtherList.setVisible(false);
                pnOfficeList.setVisible(true);
                pnContractList.setVisible(false);
                loadOffice();
            }
        }
    }

    private void setTable() {
        tbList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbList.getTableHeader().setReorderingAllowed(false);
        tbList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void loadRowData(String listName) {
        this.rowData = pDAO.getList(listName);
        ArrayList<String> row = new ArrayList<>();
        rowData.stream().map((rowData1) -> {
            row.add(String.valueOf(rowData1.getID()));
            return rowData1;
        }).map((rowData1) -> {
            row.add(rowData1.getName());
            return rowData1;
        }).map((_item) -> {
            listModel.addRow(row.toArray());
            return _item;
        }).forEach((_item) -> {
            row.clear();
        });
        tbList.setModel(listModel);
    }

    private void loadContract() {
        this.contractData = pDAO.getContract();
        ArrayList<String> row = new ArrayList<>();
        contractData.stream().map((contractData1) -> {
            row.add(String.valueOf(contractData1.getID()));
            return contractData1;
        }).map((contractData1) -> {
            row.add(contractData1.getName());
            return contractData1;
        }).map((contractData1) -> {
            row.add(String.valueOf(contractData1.getMonth()));
            return contractData1;
        }).map((contractData1) -> {
            row.add(contractData1.isBHXH() ? "Có" : "Không");
            return contractData1;
        }).map((contractData1) -> {
            if (contractData1.isBHXH()) {
                row.add(String.valueOf(contractData1.getPercent()));
            } else {
                row.add("");
            }
            return contractData1;
        }).map((contractData1) -> {
            this.contractTemp.add(contractData1.getTemplate());
            return contractData1;
        }).map((contractData1) -> {
            row.add(contractData1.getName() + "." + contractData1.getExtension());
            return contractData1;
        }).map((_item) -> {
            listModel.addRow(row.toArray());
            return _item;
        }).forEach((_item) -> {
            row.clear();
        });

        tbList.setModel(listModel);
    }

    private void loadOffice() {
        this.officeData = pDAO.getOffice();
        ArrayList<String> row = new ArrayList<>();

        officeData.stream().map((officeData1) -> {
            row.add(String.valueOf(officeData1.getOfficeID()));
            return officeData1;
        }).map((officeData1) -> {
            row.add(officeData1.getOfficeName());
            return officeData1;
        }).map((officeData1) -> {
            row.add(officeData1.getOfficeNum());
            return officeData1;
        }).map((_item) -> {
            listModel.addRow(row.toArray());
            return _item;
        }).forEach((_item) -> {
            row.clear();
        });
        tbList.setModel(listModel);
    }

    private void showFileChooser(int mode) {
        JFileChooser fileChooser = new JFileChooser();
        int result;
        switch (mode) {
            case 1:
                fileChooser.setDialogTitle("Chọn một File");
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileFilter(new FileTypeFilter(".docx", "DOCX"));
                fileChooser.setFileFilter(new FileTypeFilter(".doc", "DOC"));
                fileChooser.setFileFilter(new FileTypeFilter(".pdf", "PDF"));

                result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File docFile = fileChooser.getSelectedFile();
                    tfContractTemplate.setText(docFile.getAbsolutePath());
                    convertFile(docFile.getAbsolutePath());
                    int ext = docFile.getName().lastIndexOf('.');
                    setFileExtension(docFile.getName().substring(ext + 1));
                }
                break;
            case 2:
                byte[] fileData = null;
                String fileName = "";
                try {
                    int row = tbList.getSelectedRow();
                    fileData = contractTemp.get(row);
                    fileName = tbList.getValueAt(row, 5).toString();
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(this, "Bạn phải chọn một file trong bảng trên", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                fileChooser.setDialogTitle("Lưu file");
                fileChooser.setFileFilter(new FileTypeFilter(".docx", "DOCX"));
                fileChooser.setFileFilter(new FileTypeFilter(".doc", "DOC"));
                fileChooser.setFileFilter(new FileTypeFilter(".pdf", "PDF"));
                fileChooser.setSelectedFile(new File(fileName));
                result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File docFile = fileChooser.getSelectedFile();
                    try {
                        docFile.createNewFile();
                        try (FileOutputStream fos = new FileOutputStream(docFile)) {
                            fos.write(fileData, 0, fileData.length);
                        }
                        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn mở file đã lưu không?", "Mở file", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.open(new File(docFile.getAbsolutePath()));
                        }
                    } catch (IOException | NullPointerException ex) {
                        Logger.getLogger(PanelInfo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
    }

    private void addRowtoOtherList(String value) {
        int rowNum = tbList.getRowCount();
        int lastIndex = 0;
        if (rowNum > 0) {
            lastIndex = Integer.parseInt(tbList.getValueAt(rowNum - 1, 0).toString());
        }
        Object[] newRow = {String.valueOf(lastIndex + 1), value};
        DefaultTableModel model = (DefaultTableModel) tbList.getModel();
        model.addRow(newRow);
        tfAdd.setText("");
        JOptionPane.showMessageDialog(this, "Đã thêm mới thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void insertContract() {
        Contract con = new Contract();

        con.setName(tfContractName.getText());
        con.setMonth(Short.parseShort(tfContractMonth.getText()));
        String ops = bgOption.getSelection().getActionCommand();
        if (ops.equals("Không")) {
            con.setBHXH(false);
        } else {
            con.setBHXH(true);
            con.setPercent(Float.parseFloat(tfContractPercent.getText()));
        }
        con.setTemplate(this.template);
        con.setExtension(this.fileExtension);

        if (pDAO.updateContractList(con)) {
            addContractRow();
            resetPanelContract();
        }
    }

    private void insertOffice() {
        Office o = new Office();

        o.setOfficeName(tfOfficeName.getText());
        o.setOfficeNum(tfOfficeNum.getText());

        if (pDAO.updateOfficeList(o)) {
            addOfficeRow();
            resetPanelOffice();
        }
    }

    private void addOfficeRow() {
        ArrayList<String> row = new ArrayList<>();

        int rowNum = tbList.getRowCount();
        int lastIndex = 0;
        if (rowNum > 0) {
            lastIndex = Integer.parseInt(tbList.getValueAt(rowNum - 1, 0).toString());
        }
        row.add(String.valueOf(lastIndex + 1));
        row.add(tfOfficeName.getText());
        row.add(tfOfficeNum.getText());

        DefaultTableModel model = (DefaultTableModel) tbList.getModel();
        model.addRow(row.toArray());
    }

    private void resetPanelOffice() {
        tfOfficeName.setText("");
        tfOfficeNum.setText("");
    }

    private void convertFile(String absolutePath) {
        File docFile = new File(absolutePath);
        FileInputStream fis;
        setTemplate(new byte[(int) docFile.length()]);
        try {
            fis = new FileInputStream(docFile);
            fis.read(this.template);
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addContractRow() {
        ArrayList<String> row = new ArrayList<>();

        int rowNum = tbList.getRowCount();
        int lastIndex = 0;
        if (rowNum > 0) {
            lastIndex = Integer.parseInt(tbList.getValueAt(rowNum - 1, 0).toString());
        }
        row.add(String.valueOf(lastIndex + 1));
        row.add(tfContractName.getText());
        row.add(tfContractMonth.getText());
        row.add(bgOption.getSelection().getActionCommand());
        row.add(tfContractPercent.getText());
        row.add(tfContractName.getText() + "." + this.fileExtension);

        DefaultTableModel model = (DefaultTableModel) tbList.getModel();
        model.addRow(row.toArray());
    }

    private void resetPanelContract() {
        tfContractName.setText("");
        tfContractMonth.setText("");
        tfContractPercent.setText("");
        tfContractTemplate.setText("");
    }

    private void resetCbox() {
        info.loadList(cbox, pDAO.tblName.get(Integer.parseInt(cbox.getActionCommand()) - 1));
    }

    private void deleteFromList(short id, int row) {
        if (pDAO.deleteFromList(id, this.listName, columnInSQL.get(Integer.parseInt(cbox.getActionCommand()) - 1))) {
            DefaultTableModel model = (DefaultTableModel) tbList.getModel();
            model.removeRow(row);
            JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        resetCbox();
    }
}
