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
        EmployeeManagement manager = new EmployeeManagement();
        while (true) {
            displayMenu();
            int option = Validation.getInt("Enter your option: ", "Option[1-6].", 1, 6, null);
            switch (option) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.updateEmployee();
                    break;
                case 3:
                    manager.removeExployee();
                    break;
                case 4:
                    manager.searchEmployee();
                    break;
                case 5:
                    manager.sortEmployee();
                    manager.display();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit");
    }
}
