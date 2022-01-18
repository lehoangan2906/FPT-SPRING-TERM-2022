
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class EmployeeManagement {

    private List<Employee> listEmployees = new ArrayList<>();

    public EmployeeManagement() {
        listEmployees.add(new Employee("Nguyen", "Van A",
                "0123456789", "a@gmail.com", "Ha Noi",
                Validation.toDate("10/01/1999", "dd/MM/yyyy"), "male", 1000, "Ha Noi"));
        listEmployees.add(new Employee("Nguyen", "Van B",
                "0123456789", "b@gmail.com", "Ha Noi",
                Validation.toDate("10/01/1999", "dd/MM/yyyy"), "female", 800, "Ha Noi"));
        listEmployees.add(new Employee("Nguyen", "Van C",
                "0123456789", "c@gmail.com", "Ha Noi",
                Validation.toDate("10/01/1999", "dd/MM/yyyy"), "female", 1300, "Ha Noi"));
        listEmployees.add(new Employee("Nguyen", "Van D",
                "0123456789", "d@gmail.com", "Ha Noi",
                Validation.toDate("10/01/1999", "dd/MM/yyyy"), "male", 1500, "Ha Noi"));
    }

    public void addEmployee() {
        String firstName = Validation.getString("Enter first name: ", "First name invalid", "^[a-zA-Z ]+$", null);
        String lastName = Validation.getString("Enter last name: ", "Last name invalid", "^[a-zA-Z ]+$", null);
        String phone = Validation.getString("Enter phone: ", "Phone invalid", "^0\\d{9}+$", null);
        String email = Validation.getString("Enter email: ", "Email invalid", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", null);
        String address = Validation.getString("Enter address: ", "Address invalid", "^[a-zA-Z -]+$", null);
        Date dob = Validation.getDate("Enter dob: ", "DOB invalid", "dd/MM/yyyy", null);
        String sex = Validation.getString("Enter sex: ", "Sex(male,female)", "^(male|female)$", null);
        double salary = Validation.getDouble("Enter salary", "Salary invalid", 0, Double.MAX_VALUE, null);
        String agency = Validation.getString("Enter agency", "Agency invalid", "^[a-zA-Z ]+$", null);
        listEmployees.add(new Employee(firstName, lastName, phone, email, address, dob, sex, salary, agency));
    }

    public void updateEmployee() {
        int id = Validation.getInt("Enter Id: ", "Id is a positive integer", 1, Integer.MAX_VALUE, null);
        int index = indexOfID(id);
        if (index != -1) {
            //tien hanh update
            Employee employee = listEmployees.get(index);
            final String IGNORE_STR = "";
            String firstName = Validation.getString("Enter first name: ", "First name invalid", "^[a-zA-Z ]+$", IGNORE_STR);
            String lastName = Validation.getString("Enter last name: ", "Last name invalid", "^[a-zA-Z ]+$", IGNORE_STR);
            String phone = Validation.getString("Enter phone: ", "Phone invalid", "^0\\d{9}+$", IGNORE_STR);
            String email = Validation.getString("Enter email: ", "Email invalid", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", IGNORE_STR);
            String address = Validation.getString("Enter address: ", "Address invalid", "^[a-zA-Z -]+$", IGNORE_STR);
            Date dob = Validation.getDate("Enter dob: ", "DOB invalid", "dd/MM/yyyy", IGNORE_STR);
            String sex = Validation.getString("Enter sex: ", "Sex(male,female)", "^(male|female)$", IGNORE_STR);
            Double salary = Validation.getDouble("Enter salary", "Salary invalid", 0, Double.MAX_VALUE, IGNORE_STR);
            String agency = Validation.getString("Enter agency", "Agency invalid", "^[a-zA-Z ]+$", IGNORE_STR);
            if (firstName != null) {
                employee.setFirstName(firstName);
            }
            if (lastName != null) {
                employee.setLastName(lastName);
            }
            if (phone != null) {
                employee.setPhone(phone);
            }
            if (email != null) {
                employee.setEmail(email);
            }
            if (address != null) {
                employee.setAddress(address);
            }
            if (dob != null) {
                employee.setDob(dob);
            }
            if (sex != null) {
                employee.setSex(sex);
            }
            if (salary != null) {
                employee.setSalary(salary);
            }
            if (agency != null) {
                employee.setAgency(agency);
            }
        } else {
            System.out.println("Id not found");
            System.out.println("Update employee fail!");
        }
    }

    public void removeExployee() {
        int id = Validation.getInt("Enter Id: ", "Id is a positive integer", 1, Integer.MAX_VALUE, null);
        int index = indexOfID(id);
        if (index != -1) {
            listEmployees.remove(index);
            System.out.println("Delete employee successful!");
        } else {
            System.out.println("Id not found");
            System.out.println("Delete employee fail!");
        }
    }

    public void searchEmployee() {
        String name = Validation.getString("Enter name: ", "Name invalid", "^[a-zA-Z ]+$", null);
        System.out.println("List result: ");

        boolean isExisted = false;
        for (Employee E : listEmployees) {
            String fullName = E.getFirstName() + " " + E.getLastName();
            if (fullName.contains(name)) {
                if (!isExisted) {
                    System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                            "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Egency");
                }
                isExisted = true;
                System.out.println(E);
            }
        }
        if (!isExisted) {
            System.out.println("Not Found");
        }
    }

    public void sortEmployee() {
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
    }

    public void display() {
        for (Employee E : listEmployees) {
            System.out.println(E);
        }
    }

    private int indexOfID(int id) {
        for (int i = 0; i < listEmployees.size(); i++) {
            Employee employee = listEmployees.get(i);
            if (employee.getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
