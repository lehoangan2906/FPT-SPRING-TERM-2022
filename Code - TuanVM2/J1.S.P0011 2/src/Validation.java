/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
import java.util.Scanner;


public class Validation {
    Scanner sc = new Scanner(System.in);
    public String inputBase(String msg, String err) {
        String base;

        while (true) {
            try {
                System.out.println(msg);
                base = sc.nextLine();
               // Nếu người dùng nhập cơ số 10, 2 hoặc 16 thì trả về cơ số đó
                if (base.equals("10") || base.equals("2") || base.equals("16")) {
                    return base;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
            // Nếu không sẽ hiển thị ra thông điệp
            System.out.println(err);
        }
    }

    // Hàm nhập vào giá trị để chuyển đổi
    public String inputValue(String msg, String err, String inBase) {

        while (true) {
            try {
                System.out.println(msg);
                String value = sc.nextLine();
                // Hệ cơ số 2 gồm có 0 và 1
                if (inBase.equals("2")) {
                    if (value.matches("[0-1]+")) {
                        return value;
                    }
                }
               // Hệ cơ số 10 gồm có các số từ 0 đến 9
                if (inBase.equals("10")) {
                    if (inBase.matches("[0-9]+")) {
                        return value;
                    }
                }
                // Hê cơ số 16 gồm các số từ 0 đến 9 và các chữ A B C D E F
                if (inBase.equals("16")) {
                    if (inBase.matches("[0-9A-F]+")) {
                        return value;
                    }
                }
            } catch (Exception e) {
                System.out.println(err);
            }
            // Hiển thị thông điệp nếu nhập sai
            System.out.println(err);
        }
    }

    // Hàm để tiếp tục hay không ?
    public String inputYesNo(String msg, String err) {

        while (true) {
            try {
                System.out.println(msg);
                String yesNo = sc.nextLine();
                if(yesNo.matches("[yYNn]")){
                    return yesNo;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            System.out.println(err);

        }
    }

}
