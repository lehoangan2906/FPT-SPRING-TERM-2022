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
        TaskManagement manager = new TaskManagement();
        while (true) {
            //display menu
            displayMenu();
            //enter option
            int option = Validation.getInt("Enter your option: ", "Option[1-4]", 1, 4);
            //function detail
            switch (option) {
                //add new task
                case 1:
                    manager.addNewTask();
                    break;
                //delete task
                case 2:
                    manager.deleteTask();
                    break;
                //display task
                case 3:
                    manager.displayTask();
                    break;
                //exit
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
