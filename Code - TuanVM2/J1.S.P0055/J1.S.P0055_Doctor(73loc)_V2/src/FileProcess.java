
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
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

    public static Map<String, Doctor> readDoctors(String fileName) {
        try {
            //kiểm tra xem file tồn tại hay chưa
            File file = new File(fileName);
            if (!file.exists()) {
                writeDoctors(fileName, new HashMap<>());
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            Map<String, Doctor> map = (Map<String, Doctor>) ois.readObject();
            return map;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new HashMap<>();
    }

    public static void writeDoctors(String fileName, Map<String, Doctor> map) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(map);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
