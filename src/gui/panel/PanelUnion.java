/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import db.connection.UnionDAO;
import gui.frames.Main;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import entities.DocumentsDetails;
import entities.Education;
import entities.EmployeeUnion;
import entities.Experience;
import entities.FamilyDetails;
import entities.HealthStatus;
import entities.PersonnelDetails;
import entities.Skill;
import java.util.Vector;

/**
 *
 * @author HUNGUYEN
 */
public class PanelUnion extends javax.swing.JPanel {

    /**
     * Creates new form EmployList
     */
    private final UnionDAO uDAO = new UnionDAO();
    private Vector<EmployeeUnion> vtEmploy = null;
    private Vector<EmployeeUnion> vtEmploySearch = new Vector();
    private DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    
    private final Object[] COLUMNS_NAME = {"STT", "Mã nhân viên", "Tên Nhân viên", "Loại tình trạng",
        "Chức vụ", "Ngày tham gia", "Có tham gia"};
    private final Main main;
    
    public PanelUnion(Main main) {
        initComponents();
        this.main = main;
        setColum();
        loadData(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUnionList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbSearchList = new javax.swing.JComboBox();
        btRefesh = new javax.swing.JButton();

        tbUnionList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbUnionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "Tình trạng", "Chức vụ", "Ngày tham gia", "Tham gia"
            }
        ));
        tbUnionList.setShowHorizontalLines(false);
        tbUnionList.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbUnionList);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm theo:");

        cbSearchList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tên nhân viên", "Mã nhân viên" }));
        cbSearchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchListActionPerformed(evt);
            }
        });

        btRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/Refresh.png"))); // NOI18N
        btRefesh.setText("Làm mới");
        btRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRefesh)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbSearchList, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRefesh))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefeshActionPerformed
//        loadTable();
    }//GEN-LAST:event_btRefeshActionPerformed
    private void removeRow() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    private void setColum() {
        model.setColumnIdentifiers(COLUMNS_NAME);
    }

    /*
     * @param option: 0: load all list; 
     *                1: load with condition from search box
     *
     */
    private void loadData(int option) {
        removeRow();
        int stt = 0;
        switch (option) {
            case 0:
                vtEmploy = uDAO.getAllListUnion();
                if (vtEmploy.size() > 0) {
                    for (EmployeeUnion e : vtEmploy) {
                        stt++;
                        model.addRow(toObject(stt, e));
                    }
                }
                break;
            case 1:
                if (vtEmploySearch.size() > 0) {
                    for (EmployeeUnion e : vtEmploySearch) {
                        stt++;
                        model.addRow(toObject(stt, e));
                    }
                }
                break;
        }
        
        tbUnionList.setModel(model);
    }
    
    private Object[] toObject(int stt, EmployeeUnion e) {
        Object[] obj = {stt, e.getMaNV(), e.getTenNV(), e.getTinhTrang(), e.getChucVu(),
            e.getNgayThamGia(), e.isThamGia() ? "Có" : "Không"};
        return obj;
    }
    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        vtEmploySearch = search(cbSearchList.getSelectedIndex());
        loadData(1);
    }//GEN-LAST:event_tfSearchKeyReleased

    private void cbSearchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSearchListActionPerformed
    /*
     * @para option: 0: search follow name
     1: search follow id
     */
    
    private Vector<EmployeeUnion> search(int option) {
        vtEmploySearch.removeAllElements();
        switch (option) {
            case 0:
                for (EmployeeUnion e : vtEmploy) {
                    if (e.getTenNV().toLowerCase().trim().contains(tfSearch.getText().toLowerCase())) {
                        vtEmploySearch.add(e);
                    }
                }
                break;
            case 1:
                for (EmployeeUnion e : vtEmploy) {
                    if (e.getMaNV().toLowerCase().trim().contains(tfSearch.getText().toLowerCase())) {
                        vtEmploySearch.add(e);
                    }
                }
                break;
        }
        return vtEmploySearch;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRefesh;
    private javax.swing.JComboBox cbSearchList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUnionList;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    //Used for refreshing table (Udating from DB) & create new viewer
}
