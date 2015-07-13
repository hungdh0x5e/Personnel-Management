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
public class Message {

    public static final String OPTION_ERROR = "Có lỗi xảy ra. \nVui lòng kiểm tra lại. ";
    public static final String ERROR = " không đúng định dạng. ";
    public static final String NAME_VI = ERROR + "Chỉ cho phép [a-zA-Z] ";
    public static final String ADDRESS_VI = ERROR + "Chỉ cho phép [a-zA-Z0-9 -]";
    public static final String PHONE = ERROR + "Chỉ cho phép [0-9];  10, 11 kí tự";
    public static final String EMAIL = ERROR + "Ví dụ: at9b@gmail.com, ...";
    public static final String EMPTY =  " không được để trống. ";
    public static final String DATE = ERROR + "Định dạng: dd - MM - yyyy ";
    public static final String NUMBER = ERROR + "Định dạng: dd - MM - yyyy ";
    public static final String DELETE_OK ="Xóa thành công!";
    public static final String DELETE_ERROR = ERROR + "Xóa không thành công!";

}
