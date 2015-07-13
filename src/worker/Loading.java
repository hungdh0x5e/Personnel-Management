/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Huy Hung
 */
public class Loading extends Thread {

    private boolean isRunning = true;
    private JDialog d;

    public synchronized void run() {
        ImageIcon loading = new ImageIcon("D:\\Project for QLNS\\PersonnelManagement\\src\\icon\\loading.gif");
        d = new JDialog();
        JLabel lb = new JLabel("Đang tải dữ liệu ... ", loading, JLabel.CENTER);
        lb.setFont(new Font("Tahoma", Font.BOLD, 14));
        lb.setForeground(new Color(255, 0, 0));
        d.add(lb);
        d.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        d.setSize(200, 100);
        d.setLocation(500, 400);
        d.setModal(true);
        d.setUndecorated(true);
        d.getRootPane().setOpaque(false);
        d.getContentPane().setBackground(new Color(0, 0, 0, 0));
        d.setBackground(new Color(0, 0, 0, 0));
        d.setVisible(true);
        while (isRunning) {
            continue;
        }
    }

    public void kill() {
        isRunning = false;
        d.setVisible(false);
    }

    public static void main(String[] args) {
        Loading load = new Loading();
        load.start();
        for(int i=1;i<100;i+=3)
            System.out.println("123");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
        }
        load.kill();
        System.exit(0);
    }
}
