/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import javax.swing.JOptionPane;

/**
 *
 * @author Huy Hung
 */
public class Dialog {
    public static void showMsg(String msg, int option){
        JOptionPane.showMessageDialog(null, msg, "Pop-up",option);
    }
}
