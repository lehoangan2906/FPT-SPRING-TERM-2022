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
        CountryManagement manager = new CountryManagement();
        while (true) {
            displayMenu();
            int option = Validation.getInt("Enter your option: ", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    manager.addCountry();
                    break;
                case 2:
                    manager.displayCountry();
                    break;
                case 3:
                    manager.searchCountry();
                    break;
                case 4:
                    manager.sortCountry();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }
}
