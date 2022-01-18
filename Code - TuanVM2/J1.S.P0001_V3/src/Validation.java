
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class Validation {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }
}
