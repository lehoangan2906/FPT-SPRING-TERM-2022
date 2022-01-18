import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class Validation {

    private static final Scanner in = new Scanner(System.in);

    public static int checkInputInt(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("You must input integer number between " + min + " - " + max + ".");
                System.out.print("Please re-enter: ");
            }
        }
    }

    public static String checkInputString() { //yêu cầu người dùng không nhập vào chuỗi rỗng
        while (true) { 
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("You must input non-empty string.");
                System.out.print("Please re-enter: ");
            } else {
                return result;    
            }
        }
    }

    public static double checkInputPrice() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("You must input positive price");
                System.out.print("Please re-enter: ");
            }

        }
    }

    public static boolean checkInputYN() {

        while (true) {
            String result = in.nextLine();

            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("You must input y/Y or n/N.");
            System.out.print("Please re-enter: ");
        }
    }

    

   
}