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
        DoctorManagement manager = new DoctorManagement();
        while (true) {
            System.out.println("========= Doctor Management ==========\n"
                    + "1.	Add Doctor\n"
                    + "2.	Update Doctor\n"
                    + "3.	Delete Doctor\n"
                    + "4.	Search Doctor\n"
                    + "5.	Exit");
            int option = Validation.getInt("Enter your option: ", "Option[1-5]. Please enter again", 1, 5);
            switch (option) {
                case 1:
                    manager.addDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    break;
                case 4:
                    manager.searchDoctor();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
