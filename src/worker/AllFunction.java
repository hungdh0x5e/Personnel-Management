/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

/**
 *
 * @author Huy Hung
 */
public class AllFunction {

    // NV0001
    public static String generatorID(String lastID, String id) {
        String[] temp = lastID.split(id);
        String result = id;
        try {
            int value = Integer.parseInt(temp[1])+1;
            result += value < 10 ? "000" + value : value < 100 ? "00" + value : value < 1000 ? "0" + value : "" + value;
        } catch (NumberFormatException e) {
            Dialog.showMsg("Lỗi tạo mã", 0);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(AllFunction.generatorID("NV00012", "NV"));
    }
}
