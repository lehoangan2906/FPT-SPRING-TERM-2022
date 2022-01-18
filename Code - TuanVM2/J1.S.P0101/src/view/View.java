/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Management;
import controller.Validate;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author VINH
 */
public class View {

    Management m = new Management();

    public void menu() {
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
    }

    public void addEmployeeView() {
        System.out.println("\n-------- Add Employees --------");
        Validate validate = new Validate();
        int id = 0;
        while (true) {
            id = validate.inputIntLimit("Id: ", "Invalid Id!", 1, Integer.MAX_VALUE);
            if (validate.checkDuplicateId(id, m.getListEmployees())) {
                System.out.println("Duplicate!");
            } else {
                break;
            }
        }
        String fName = validate.inputString("First Name: ",
                "First name is required!", "[a-zA-Z ]+");
        String lName = validate.inputString("Last Name: ",
                "Last name is required!", "[a-zA-Z ]+");
        String phone = validate.inputString("Phone: ",
                "Phone is required and is ditgits!", "[0-9]{10,11}");
        String Email = validate.inputString("Email: ",
                "Invalid is Email!", "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$");
        String Address = validate.inputString("Adrress: ",
                "Adress is required!", "[a-zA-Z ]+");
        String dob = validate.inputDate("DOB: ", "Invalid format!", "dd/MM/yyyy");
        int boo = validate.inputIntLimit("Sex(1.Male/2.Female): ", "Invalid sex!", 1, 2);
        Boolean sex = null;
        if (boo == 1) {
            sex = true;
        } else if (boo == 2) {
            sex = false;
        }
        double salary = validate.inputDoubleLimit("Salary: ", "Invalid salary!",
                1, Double.MAX_VALUE);
        String egency = validate.inputString("Egency: ", "invalid!", "[a-zA-Z ]+");
        boolean checkadd = m.addEmployee(id, fName, lName, phone, Email, Address, dob, sex, salary, egency);
        if (checkadd == true) {
            System.out.println("Add successful!");
        } else {
            System.err.println("Add fail!");
        }
    }

    public void UpdateEmployeeView() {
        System.out.println("\n-------- Update Employee --------");
        Validate validate = new Validate();
        int id = 0;
        id = validate.inputIntLimit("Id: ", "Invalid Id!", 0, Integer.MAX_VALUE);
        Employee em = null;
        em = m.getEployeeById(id);
        if (em == null) {
            System.out.println("Id not exist!");
            return;
        }
        String fName = validate.inputString("First Name: ",
                "Invalid", "[a-zA-Z ]+");
        String lName = validate.inputString("Last Name: ",
                "Invalid", "[a-zA-Z ]+");
        String phone = validate.inputString("Phone: ",
                "Invalid", "[0-9]{10,11}");
        String Email = validate.inputString("Email: ",
                "Invalid", "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$");
        String Address = validate.inputString("Adrress: ",
                "Invalid", "[a-zA-Z ]+");
        String dob = validate.inputDate("DOB: ", "Invalid", "dd/MM/yyyy");
        int boo = validate.inputIntLimit("Sex(1.Male/2.Female): ", "Invalid", 1, 2);
        Boolean sex = null;
        if (boo == 1) {
            sex = true;
        } else if (boo == 2) {
            sex = false;
        }
        double salary = validate.inputDoubleLimit("Salary: ", "Invalid", 1, Integer.MAX_VALUE);
        String egency = validate.inputString("Egency: ", "Invalid!", "[a-zA-Z ]+");
        m.updateEmployee(id, fName, lName, phone, Email, Address, dob, sex, salary, egency);
        System.out.println("Update succesfull!");
    }

    public void searchEmployeeView() {
        Validate validate = new Validate();
        System.out.println("-------- Search Employee --------");
        System.out.println("");
        String searchValue = validate.inputSearchValue("Enter name: ");
        ArrayList<Employee> listEmployee = m.searchEmployeeByName(searchValue);
        if(listEmployee.isEmpty()){
            System.out.println("Not found");
            return;
        }
        showEmployees(listEmployee);
    }

    public void RemoveEmployeeView() {
        Validate validate = new Validate();
        System.out.println("-------- Remove Employee --------");
        int id = validate.inputIntLimit("Id: ", "Invalid id!", 0, Integer.MAX_VALUE);
        if (m.removeEmployee(id)) {
            System.out.println("Remove successful!");
        } else {
            System.out.println("Not found employee");
        }
    }

    public void sortEmployeeView() {
        ArrayList<Employee> listEmployee = m.sortEmployeeBySalary();
        showEmployees(listEmployee);
    }

    public void showEmployees(ArrayList<Employee> listEmployee) {
        if (listEmployee.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("\n%-5s%-15s%-15s%-15s%-26s%-10s%-12s%-10s%-10s%-10s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Adress", "DOB",
                "Sex", "Salary", "Egency");
        for (int i = 0; i < listEmployee.size(); i++) {
            Employee employee = listEmployee.get(i);
            System.out.printf("%-5s%-15s%-15s%-15s%-26s%-10s%-12s%-10s%-10.1f%-10s\n",
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPhone(),
                    employee.getEmail(),
                    employee.getAddress(),
                    employee.getDob(),
                    employee.isSex() ? "Male" : "Female",
                    employee.getSalary(),
                    employee.getAgency()
            );
        }
    }

    public void display() {
        Validate validate = new Validate();
        while (true) {
            menu();
            int choice = validate.inputIntLimit("Your choice: ",
                    "Input must in range[1-6]!", 1, 6);
            switch (choice) {
                case 1:
                    addEmployeeView();
                    break;
                case 2:
                    UpdateEmployeeView();
                    break;
                case 3:
                    RemoveEmployeeView();
                    break;
                case 4:
                    searchEmployeeView();
                    break;
                case 5:
                    sortEmployeeView();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        View v = new View();
        v.display();
    }
}
