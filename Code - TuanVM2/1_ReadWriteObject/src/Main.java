
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        //        ObjectOutputStream objectOutputStream = null;
//        try {
//            List<Account> listAccounts = new ArrayList<>();
//            listAccounts.add(new Account("user", "123456"));
//            listAccounts.add(new Account("admin", "123456"));
//            objectOutputStream = new ObjectOutputStream(new FileOutputStream("account.txt"));
//            objectOutputStream.writeObject(listAccounts);
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                objectOutputStream.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        List<Account> listAccounts = FileProcess.readFile("account.txt");
//        listAccounts.add(new Account("customer", "123456"));
//        FileProcess.writeFile(listAccounts, "account.txt");
        System.out.println(listAccounts);
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("account.txt", true));
            oos.writeObject(new Account("new", "1234567"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
