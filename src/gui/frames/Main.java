/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.frames;

import db.connection.PersonnelDAO;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import entities.CompanyDetails;
import gui.panel.PanelInfo;
import gui.panel.PanelCompany;
import gui.panel.PanelPersonnelList;
import gui.panel.PanelUnion;
import gui.panel.TreePanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import worker.ButtonTabComponent;
import worker.Loading;

/**
 *
 * @author HUNGUYEN
 */
public class Main extends javax.swing.JFrame {

    public static int indexTab;
    private PersonnelDAO pDAO = new PersonnelDAO();

    private PanelPersonnelList panelList = null;
    private PanelInfo panelAddInfo = null;
    private PanelUnion panelUnion = null;
    private static final String[] TITLE_QLNV = {"Thêm mới NV", "Thành viên công đoàn", "Danh sách NV",
        "Thông tin hợp đồng", "Quản lý nghỉ phép"};

    public Main() {
        initComponents();
        setIcon();
        setFrame();
        checkCompanyName();
        this.pack();
    }

    public JTabbedPane getTpRight() {
        return tpRight;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolBar = new javax.swing.JToolBar();
        tbBtHideShow = new javax.swing.JToggleButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        tbBtAddPerson = new javax.swing.JButton();
        spMain = new javax.swing.JSplitPane();
        pnLeft = new javax.swing.JPanel();
        tpRight = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbTimer = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        lbUsername = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        lbDBName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miHideShowList = new javax.swing.JCheckBoxMenuItem();
        miHideTb = new javax.swing.JCheckBoxMenuItem();
        miDeclare = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miCloseAllTab = new javax.swing.JMenuItem();
        miLogOut = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        miExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miAddPerson = new javax.swing.JMenuItem();
        miAddMember = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miPersonnelList = new javax.swing.JMenuItem();
        miContractInfo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miRest = new javax.swing.JMenuItem();
        miQuitInfo = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenuItem();
        miInstruction = new javax.swing.JMenuItem();
        miCbShowInstruction = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân sự");
        setMinimumSize(new java.awt.Dimension(1200, 680));

        ToolBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ToolBar.setFloatable(false);

        tbBtHideShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/List.png"))); // NOI18N
        tbBtHideShow.setSelected(true);
        tbBtHideShow.setToolTipText("Ẩn/Hiện danh sách cây");
        tbBtHideShow.setFocusable(false);
        tbBtHideShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtHideShow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBtHideShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBtHideShowActionPerformed(evt);
            }
        });
        ToolBar.add(tbBtHideShow);
        ToolBar.add(jSeparator5);

        tbBtAddPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/toolbar/EmployAdd.png"))); // NOI18N
        tbBtAddPerson.setToolTipText("Thêm một nhân viên mới");
        tbBtAddPerson.setFocusable(false);
        tbBtAddPerson.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtAddPerson.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(tbBtAddPerson);

        spMain.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnLeft.setMinimumSize(new java.awt.Dimension(220, 100));
        pnLeft.setLayout(new java.awt.BorderLayout());
        spMain.setLeftComponent(pnLeft);

        tpRight.setAutoscrolls(true);
        tpRight.setMinimumSize(new java.awt.Dimension(400, 5));
        spMain.setRightComponent(tpRight);

        lbTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTimer.setText("Time:");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsername.setText("Username:");

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbDBName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDBName.setText("Database: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDBName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addComponent(jSeparator7)
            .addComponent(lbDBName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Hệ thống");

        miHideShowList.setSelected(true);
        miHideShowList.setText("Ẩn hiện danh sách cây");
        miHideShowList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List.png"))); // NOI18N
        miHideShowList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHideShowListActionPerformed(evt);
            }
        });
        jMenu1.add(miHideShowList);

        miHideTb.setText("Ẩn/Hiện Toolbar");
        miHideTb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Pin.png"))); // NOI18N
        miHideTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHideTbActionPerformed(evt);
            }
        });
        jMenu1.add(miHideTb);

        miDeclare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Database.png"))); // NOI18N
        miDeclare.setText("Khởi tạo dữ liệu");
        miDeclare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeclareActionPerformed(evt);
            }
        });
        jMenu1.add(miDeclare);
        jMenu1.add(jSeparator3);

        miCloseAllTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CloseAll.png"))); // NOI18N
        miCloseAllTab.setText("Đóng tất cả các Tab");
        miCloseAllTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCloseAllTabActionPerformed(evt);
            }
        });
        jMenu1.add(miCloseAllTab);

        miLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LogOut.png"))); // NOI18N
        miLogOut.setText("Đăng xuất");
        jMenu1.add(miLogOut);
        jMenu1.add(jSeparator4);

        miExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/TurnOff.png"))); // NOI18N
        miExit.setText("Thoát");
        jMenu1.add(miExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Quản lý nhân viên");

        miAddPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EmployeeAdd.png"))); // NOI18N
        miAddPerson.setText("Thêm nhân viên mới");
        miAddPerson.setToolTipText("");
        miAddPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddPersonActionPerformed(evt);
            }
        });
        jMenu2.add(miAddPerson);

        miAddMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group.png"))); // NOI18N
        miAddMember.setText("Thành viên công đoàn");
        miAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddMemberActionPerformed(evt);
            }
        });
        jMenu2.add(miAddMember);
        jMenu2.add(jSeparator2);

        miPersonnelList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EmployInfo.png"))); // NOI18N
        miPersonnelList.setText("Danh sách thông tin nhân viên");
        miPersonnelList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPersonnelListActionPerformed(evt);
            }
        });
        jMenu2.add(miPersonnelList);

        miContractInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EmployInfo.png"))); // NOI18N
        miContractInfo.setText("Thông tin hợp đồng làm việc");
        jMenu2.add(miContractInfo);
        jMenu2.add(jSeparator1);

        miRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EmployInfo.png"))); // NOI18N
        miRest.setText("Quản lý nghỉ phép");
        jMenu2.add(miRest);

        miQuitInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/EmployInfo.png"))); // NOI18N
        miQuitInfo.setText("Thông tin nhân viên nghỉ việc");
        jMenu2.add(miQuitInfo);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Máy chấm công");

        jMenuItem12.setText("Updating...");
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Bảng tính lương");

        jMenuItem13.setText("Updating...");
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(null);
        jMenu5.setText("Help");

        miAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Info.png"))); // NOI18N
        miAbout.setText("Về phần mềm");
        jMenu5.add(miAbout);

        miInstruction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HelpBook.png"))); // NOI18N
        miInstruction.setText("Hướng dẫn sử dụng");
        jMenu5.add(miInstruction);

        miCbShowInstruction.setSelected(true);
        miCbShowInstruction.setText("Hiển thị hướng dẫn");
        miCbShowInstruction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HelpBook.png"))); // NOI18N
        miCbShowInstruction.setRolloverEnabled(true);
        jMenu5.add(miCbShowInstruction);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addComponent(spMain)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spMain, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miHideTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHideTbActionPerformed
        if (ToolBar.isVisible()) {
            ToolBar.hide();
        } else {
            ToolBar.setVisible(true);
        }
    }//GEN-LAST:event_miHideTbActionPerformed

    private void tbBtHideShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBtHideShowActionPerformed
        HideShowTreeList();
    }//GEN-LAST:event_tbBtHideShowActionPerformed

    private void miPersonnelListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPersonnelListActionPerformed
        loadPanel(1);
    }//GEN-LAST:event_miPersonnelListActionPerformed

    private void miHideShowListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHideShowListActionPerformed
        HideShowTreeList();
    }//GEN-LAST:event_miHideShowListActionPerformed

    private void miAddPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddPersonActionPerformed
        loadPanel(0);
    }//GEN-LAST:event_miAddPersonActionPerformed

    private void miCloseAllTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCloseAllTabActionPerformed
        tpRight.removeAll();
    }//GEN-LAST:event_miCloseAllTabActionPerformed

    private void miDeclareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeclareActionPerformed
        CompanyDetails com = pDAO.getCompanyDetails();
        tpRight.add("Thông tin công ty", new PanelCompany(com));
    }//GEN-LAST:event_miDeclareActionPerformed

    private void miAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddMemberActionPerformed
        loadPanel(2);
    }//GEN-LAST:event_miAddMemberActionPerformed
    public void loadPanel(int i) {
        Loading load = new Loading();
        switch (i) {
            // Thêm mới nhân viên
            case 0:
                if (panelAddInfo == null) {
                    load.start();
                    panelAddInfo = new PanelInfo();
                    tpRight.add(TITLE_QLNV[0], panelAddInfo);
                    initTabComponent(indexTab);
                    load.kill();
                } else {
                    if (!setSelectedTab(TITLE_QLNV[0])) {
                        tpRight.add(TITLE_QLNV[0], panelAddInfo);
                        initTabComponent(indexTab);
                    }
                }
                break;
            // Danh sách sinh viên
            case 1:
                if (panelList == null) {
                    load.start();
                    panelList = new PanelPersonnelList(this);
                    tpRight.add(TITLE_QLNV[2], panelList);
                    initTabComponent(indexTab);
                    load.kill();
                } else {
                    if (!setSelectedTab(TITLE_QLNV[2])) {
                        tpRight.add(TITLE_QLNV[2], panelList);
                        initTabComponent(indexTab);
                    }
                }
                break;
            // Danh sách thành viên công đoàn
            case 2:
                if (panelUnion == null) {
                    load.start();
                    panelUnion = new PanelUnion(this);
                    tpRight.add(TITLE_QLNV[1], panelUnion);
                    initTabComponent(indexTab);
                    load.kill();
                } else {
                    if (!setSelectedTab(TITLE_QLNV[1])) {
                        tpRight.add(TITLE_QLNV[1], panelUnion);
                        initTabComponent(indexTab);
                    }
                }
                break;
        }
    }

    public void initTabComponent(int i) {
        tpRight.setTabComponentAt(i,
                new ButtonTabComponent(tpRight));
        tpRight.setSelectedIndex(indexTab);
        indexTab++;
    }

    public boolean setSelectedTab(String title) {
        for (int index = 0; index < tpRight.getTabCount(); index++) {
            if (tpRight.getTitleAt(index).equals(title)) {
                tpRight.setSelectedIndex(index);
                return true;
            }
        }
        return false;
    }

    public void removeTab(String title) {
        for (int index = 0; index < tpRight.getTabCount(); index++) {
            if (tpRight.getTitleAt(index).equals(title)) {
                tpRight.remove(index);
                indexTab--;
                return;
            }
        }
    }

    private void HideShowTreeList() {
        if (pnLeft.isVisible()) {
            pnLeft.setVisible(false);
            tbBtHideShow.setSelected(false);
            miHideShowList.setSelected(false);
        } else {
            pnLeft.setVisible(true);
            spMain.setDividerLocation(250);
            tbBtHideShow.setSelected(true);
            miHideShowList.setSelected(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                new Main().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lbDBName;
    private javax.swing.JLabel lbTimer;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JMenuItem miAbout;
    private javax.swing.JMenuItem miAddMember;
    private javax.swing.JMenuItem miAddPerson;
    private javax.swing.JCheckBoxMenuItem miCbShowInstruction;
    private javax.swing.JMenuItem miCloseAllTab;
    private javax.swing.JMenuItem miContractInfo;
    private javax.swing.JMenuItem miDeclare;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JCheckBoxMenuItem miHideShowList;
    private javax.swing.JCheckBoxMenuItem miHideTb;
    private javax.swing.JMenuItem miInstruction;
    private javax.swing.JMenuItem miLogOut;
    private javax.swing.JMenuItem miPersonnelList;
    private javax.swing.JMenuItem miQuitInfo;
    private javax.swing.JMenuItem miRest;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JSplitPane spMain;
    private javax.swing.JButton tbBtAddPerson;
    private javax.swing.JToggleButton tbBtHideShow;
    private javax.swing.JTabbedPane tpRight;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        URL url = ClassLoader.getSystemResource("icon/Manager.png");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.createImage(url);
        this.setIconImage(image);
    }

    private void setFrame() {
        ToolBar.setVisible(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void setTree(String name) {
        pnLeft.add(new TreePanel(name));
    }

    private void checkCompanyName() {
        CompanyDetails com = pDAO.getCompanyDetails();

        if (com.getTenCtyVN() == null) {
            tpRight.add("Khởi tạo dữ liệu", new PanelCompany(this));
        } else {
            setTree(com.getTenCtyVN());
        }
    }
}