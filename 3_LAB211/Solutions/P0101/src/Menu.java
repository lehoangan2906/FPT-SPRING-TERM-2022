
import java.lang.*;
import java.util.*;

public class Menu {
	Scanner sc = new Scanner(System.in);
    
    public void makeOptions(ArrayList<String> options){
        options.add("================================================================");
        options.add("|                             Menu                             |");
        options.add("================================================================");
        options.add("|                                                              |");
        options.add("|  0. Exit Program                                             |");
        options.add("|  1. List all employees                                       |");
        options.add("|  2. Add a new employee                                       |");
        options.add("|  3. Search an employee based on his/her ID                   |");
        options.add("|  4. Update an employee                                       |");
        options.add("|  5. Remove an employee                                       |");
        options.add("|  6. List all employees in ascending order of salary          |");
        options.add("|  7. List all employees in descending order of salary         |");
        options.add("|  8. Save employee to file                                    |");
        options.add("|                                                              |");
        options.add("================================================================");
    } 
    
    public <E> int int_getChoice(ArrayList<E> options){
        int response;
        for (int i = 0; i < options.size(); i++){
            System.out.println(options.get(i));
        }
        System.out.println("\nPlease choose an option: 0 -> " + (options.size()-7));
        System.out.print("\nEnter your choice: ");
        response = Integer.parseInt(sc.nextLine());
        return response;
    }
}
