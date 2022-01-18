/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class Main {
    
    public static void main(String[] args) {
        AccountManagement manager = new AccountManagement();
        manager.setFileName("abc.dat");
        while (true) {
            System.out.println("====== USER MANAGEMENT SYSTEM ======\n"
                    + "1. Create a new account\n"
                    + "2. Login system\n"
                    + "3. Exit");
            int choose = Validation.getInt("> Choose:", "Choose[1-3].Please enter again!", 1, 3);
            switch (choose) {
                case 1:
                    manager.createAccount();
                    break;
                case 2:
                    manager.login();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
        
    }
}
