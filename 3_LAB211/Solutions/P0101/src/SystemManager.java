
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {

	public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
		
        EmployeeList employeeslist = new EmployeeList();
        Menu menu = new Menu();
        ArrayList<String> options;
        Scanner sc = new Scanner(System.in);
        
		String filename = "src/employees.txt";
        employeeslist.loadFromFile(filename);
        
        while (true){
            options = new ArrayList<>();
            menu.makeOptions(options);
            int choice = menu.int_getChoice(options);
            switch(choice){
                case 0:
                    System.out.println("\nThanks for using my product.");
                    return;
                case 1:
                    System.out.println("================================================================\n");
                    System.out.println("                        List all employees:\n");
                    employeeslist.listemployees();
                    break;
                case 2: 
                    System.out.println("\n                      Add a new employee: \n");
                    employeeslist.addEmployee();
                    break;
                case 3: 
                    System.out.println("\n                Search an employee based on his/her ID\n");
                    while (true){
                        System.out.print("Enter the ID of the employee you want to search: ");
                        String ID = sc.nextLine();
                        if ("".equals(ID)){
                            System.out.println("ID cannot be blanked.");
                        }else{
							employeeslist.searchByID(ID);
                            break;
                        }
                    }
                    break;
                case 4: 
                    System.out.println("\n                       Update an employee\n");
					employeeslist.updateEmployee();
                    break;
                case 5:
                    System.out.println("\n                       Remove an employee\n");
                    employeeslist.removeEmployee();
                    break;
                case 6:
                    System.out.println("\n                List all employees in ascending order of salary\n");
                    employeeslist.listEmployeesBySalaryAscend();
                    break;
                case 7: 
                    System.out.println("\n                List all employyees in descending order of salary\n");
                    employeeslist.listEmployeesBySalaryDescend();
                    break;
                case 8:
                    System.out.println("\n                          Save employee to file\n");
					employeeslist.saveToFile(filename);
                    break;
            }
        }
	}
	
}
