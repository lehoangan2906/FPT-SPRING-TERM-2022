import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VINH
 */
public class DataInput {

    public int inputChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String raw = scanner.nextLine().trim();
            raw = raw.replaceAll("\\s+", " ");
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
}
