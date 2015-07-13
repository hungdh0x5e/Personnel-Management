/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author HuyHung
 */
public class DateTime {

    private static String datePattern = "dd - MM - yyyy";

    public static String getToday() {
        Calendar cal = new GregorianCalendar();
        String day = cal.get(cal.DAY_OF_MONTH) < 10 ? "0" + cal.get(cal.DAY_OF_MONTH) : "" + cal.get(cal.DAY_OF_MONTH);
        String month = cal.get(cal.MONTH) < 10 ? "0" + (1 + cal.get(cal.MONTH)) : "" + (1 + cal.get(cal.MONTH));
        String year = "" + cal.get(cal.YEAR);
        return day + "/" + month + "/" + year;
    }

    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        String hour = cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(cal.HOUR_OF_DAY) : "" + cal.get(cal.HOUR_OF_DAY);
        String minute = cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(cal.MINUTE) : "" + cal.get(cal.MINUTE);
        String second = cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(cal.SECOND) : "" + cal.get(cal.SECOND);
        return hour + ":" + minute + ":" + second;
    }
    // convert to format
    public static String convertDate(Date date) {
        DateFormat df = new SimpleDateFormat(datePattern);
        System.out.println("Convert Date 1 (Date->String): " + date + " -> " + df.format(date));
        return df.format(date);
    }

    public static Date convertDate(java.util.Date date) {
        if (date == null) {
            JOptionPane.showMessageDialog(null, "Date is null");
            return null;
        }
        Date a = new Date(date.getTime());
        System.out.println("Convert Date " + date + " -> " + a);
        return a;
    }

}
