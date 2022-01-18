/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validator {

    public static int inputNumber() {

        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int n = 0;

        while (check) {

            try {
                n = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter again");
            }
        }
        return n;
    }

    public static double inputTimeFrom() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        double From = 0;

        while (check) {

            try {

                From = Double.parseDouble(sc.nextLine());

                if (From >= 8 && From <= 17.5 && From % 0.5 == 0) {
                    break;
                } else {
                    System.out.println("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!:");
            }
        }
        return From;

    }

    public static double inputTimeTo(double From) {

        Scanner sc = new Scanner(System.in);
        boolean check = true;
        double To = 0;

        while (check) {

            try {

                To = Double.parseDouble(sc.nextLine());

                if (To >= 8 && To <= 17.5 && To % 0.5 == 0 && To >= From) {
                    break;
                } else {
                    System.out.println("Enter from phai lon hon to : ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!:");
            }
        }
        return To;
    }

    public static int inputTaskType() {

        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int Type = 0;

        while (check) {

            try {

                Type = Integer.parseInt(sc.nextLine());

                if (Type >= 1 && Type <= 4) {
                    break;
                } else {
                    System.out.println("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid choice, please input again!:");
            }
        }
        return Type;
    }

    public static String inputDate() {
        Scanner sc = new Scanner(System.in);
        boolean bcheck = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        Date date = null;

        while (bcheck) {

            try {
                System.out.println("Date: ");
                date = sdf.parse(sc.nextLine());
                bcheck = false;
            } catch (Exception e) {
                System.err.println("Invalid Date: ");
            }
        }
        return sdf.format(date);
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String s = null;
        boolean check = true;

        while (check) {
            s = sc.nextLine().trim();
            if (s.length() == 0) {
                System.out.println("Enter again: ");
            } else {
                check = false;
            }
        }
        return s;
    }

}
