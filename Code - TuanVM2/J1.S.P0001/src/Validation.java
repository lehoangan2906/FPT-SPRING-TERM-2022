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

    public static Scanner in = new Scanner(System.in);

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Enter again: ");
            }

        }
    }
}