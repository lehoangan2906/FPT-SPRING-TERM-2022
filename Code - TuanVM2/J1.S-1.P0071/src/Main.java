
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {
  public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
        
        TaskManagement t = new TaskManagement();
        while (true) {
            t.menu();
            int choice = Utility.GetInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    t.addTask(list);
                    break;
                case 2:
                    t.delete(list);
                    break;
                case 3:
                    t.display(list);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }
}
