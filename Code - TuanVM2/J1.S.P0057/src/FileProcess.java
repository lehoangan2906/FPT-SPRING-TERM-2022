
import java.io.File;
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
public class FileProcess {

    public static List<Account> readListAccount(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                writeListAccount(fileName, new ArrayList<>());
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            List<Account> listAccount = (List<Account>) ois.readObject();
            return listAccount;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Read file fail");
        }
        return null;
    }

    public static void writeListAccount(String fileName, List<Account> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
