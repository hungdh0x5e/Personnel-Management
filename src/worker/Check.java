/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Huy Hung
 */
public class Check {

    public Check() {
    }

    public static boolean checkStringVN(String fullName, boolean isName) {
        String strPattern = "^[a-zA-Z\\sàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
                    + "ìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰýÝỳỲỷỶỵỴỹỸ";
        if (!isName) {
            strPattern += "\\d";
        }
        strPattern += "_ -]{1,25}$";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(fullName.trim());
        return matcher.matches();
    }

    public static boolean checkNum(String n) {
        if (n == null || n.length() == 0) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean checkString(String n) {
        if (n == null || n.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkSpace(String n) {
        String[] a = n.split(" ");
        if (a.length > 1) {
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String n) {
        if (n == null) {
            return false;
        } else {
            String strPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n.trim());
            return m.find();

        }
    }

    public static boolean checkPhone(String n) {
        if (n == null || n.length() > 11 || n.length() < 9) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static int checkDay(int thang, int nam) {
        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0))) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;
    }

    public static boolean checkDate(String n) {
        if (n == null || n.length() > 10 || n.length() < 5) {
            return false;
        } else {

            String[] a = n.split("/");

            int ngay = 0, thang = 0, nam = 0;
            if ((a.length == 3)) {

                try {
                    ngay = Integer.parseInt(a[0]);
                    thang = Integer.parseInt(a[1]);
                    nam = Integer.parseInt(a[2]);
                } catch (NumberFormatException ev) {
                    return false;
                }
                if ((thang < 1) || (thang > 12) || (nam < 0)) {

                    return false;
                } else if ((ngay < 0) || (ngay > checkDay(thang, nam))) {

                    return false;
                }
            } else {
                return false;
            }
            return true;

        }
    }

    public static void main(String[] args) {
        String diachi = "02/12/1994";
        System.out.println(Check.checkNum("0988310608"));
        System.out.println(Check.checkStringVN("Huy Hùng",true));
        System.out.println(Check.checkStringVN("",false));
        System.out.println(Check.checkStringVN("141 Chiến Thắng",false));
    }
}
