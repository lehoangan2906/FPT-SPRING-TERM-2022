import entity.Users;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VINH
 */

public class Main {
   public static void main(String[] args) {
        ArrayList<Users> listUser = new ArrayList<>();
        listUser.add(new Users("1234567890", "1234abcd"));
        DataInput in = new DataInput();
        LoginSystem loginSystem = new LoginSystem(listUser);
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
        int choice = in.inputChoice(1, 3);
        switch (choice) {
            case 1: {
                loginSystem.changeLanguage(1);
                break;
            }
            case 2: {
                loginSystem.changeLanguage(2);
                break;
            }
            case 3: {
                return;
            }
        }
        loginSystem.login();
   }
}


