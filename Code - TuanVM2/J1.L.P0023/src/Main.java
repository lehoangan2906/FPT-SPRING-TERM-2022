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
        Shop owner = new Shop();
        while (true) {
            //display menu
            displayMenu();
            //get integer number and assign to option variable
            int option = Validation.getInt("Enter your option", "Option[1-4]", 1, 4);
            //detail
            switch (option) {
                //option 1: create new fruit
                case 1:
                    owner.createNewFruit();
                    break;
                //option 2: view orders
                case 2:
                    owner.viewOrders();
                    break;
                //option 3: shopping
                case 3:
                    owner.shopping();
                    break;
                //option 4: exit
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit");
    }
}
