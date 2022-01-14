
import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

public class EmployeeList {
	ArrayList<Employees> Employeeslist;
	Scanner sc;

	public EmployeeList() {
		Employeeslist = new ArrayList<>();
		sc = new Scanner(System.in);
	}

	String filename = "src/employees.txt";

	public boolean loadFromFile(String filename) throws FileNotFoundException, IOException, ParseException{
        Employeeslist.removeAll(Employeeslist);
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = "";
                while ((line = br.readLine()) != null) {
                    Employees employee = new Employees();
                    String datas[] = line.split(", ");
                    employee.setID(datas[0]);
                    employee.setFirstName(datas[1]);
					employee.setLastName(datas[2]);
					Date DateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(datas[3]);
					employee.setDoB(DateOfBirth);
					employee.setSex(datas[4]);
					employee.setAddress(datas[5]);
					employee.setPhone(datas[6]);
					employee.setMail(datas[7]);
					employee.setAgency(datas[8]);
					employee.setSalary(Double.parseDouble(datas[9]));
                    Employeeslist.add(employee);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
                return false;
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }

	public boolean saveToFile(String filename){
        PrintWriter out;
        try {
            out = new PrintWriter(filename);
            String line = "";
            for (Employees i : Employeeslist) {
                line = i.getID()+ ", " + i.getFirstName() + ", "
                        + i.getLastName() + ", " + i.getDoB() + ", " + i.getSex()
						 + ", " + i.getAddress() + ", " + i.getPhone() + ", " + i.getMail() + ", " + i.getAgency() + ", " + i.getSalary();
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

	public void searchByID(String ID){
        int count = 0;
        for (int i = 0; i < Employeeslist.size(); i++){
            if (Employeeslist.get(i).getID().equals(ID)){
                System.out.println("\n ----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|    ID    |  first name  |  last name  |  Date of Birth |  sex  |       Address       |    phone    |        mail       |    agency    |    Salary    |");
                System.out.println(" ----------|--------------|-------------|----------------|-------|---------------------|-------------|-------------------|--------------|--------------|");
                System.out.println("\n" + Employeeslist.get(i).screenString() + "\n");
                count++;
            }
        }
        if (count == 0){
            System.out.println("Brand with this ID does not exist.\n");
        }
    }

	public int searchID(String ID){
        for (int i = 0; i < Employeeslist.size(); i++){
            if (Employeeslist.get(i).getID().equals(ID)){
                return i;
            }
        }return -1;
    }
    
    public void addEmployee() throws ParseException{
        String ID, firstname, lastname, sex, date, address, phone, mail, agency;
        double salary;

        while(true){
            // constraint. Input ID can not exist in the list
            System.out.print("Enter new ID: ");
            ID = sc.nextLine();
            if ("".equals(ID)){
                System.err.println("Employee ID cannot be blank, reEnter the ID: ");
            }else{
                if (searchID(ID) >= 0){
                    System.out.println("ID Existed! Enter new ID: ");
                }else{
                    break;
                }
            }
        }
        
        while (true){
            // The First name is not blank
            System.out.print("Enter new First name: ");
            firstname = sc.nextLine();
            if("".equals(firstname)){
                System.err.println("First name cannot be blank. reEnter new First name: ");
            }else{
                break;
            }
        }
        
        while (true){
            // The Last name is not blank
            System.out.print("Enter new Last name: ");
            lastname = sc.nextLine();
            if ("".equals(lastname)){
                System.err.println("Last name cannot be blank, reEnter new Last name: ");
            }else{
                break;
            }
        }

		while (true){
            // The DoB is not blank
            System.out.print("Enter new Date of Birth: ");
            date = sc.nextLine();
            if("".equals(date)){
                System.err.println("Date of Birth cannot be blank. reEnter new DoB: ");
            }else{
                break;
            }
        }

		while (true){
            // The sex is not blank
            System.out.print("Enter new sex: ");
            sex = sc.nextLine();
            if("".equals(sex)){
                System.err.println("Sex cannot be blank. reEnter new sex: ");
            }else{
                break;
            }
        }

		while (true){
            // The adress is not blank
            System.out.print("Enter new address: ");
            address = sc.nextLine();
            if("".equals(address)){
                System.err.println("Adress cannot be blank. reEnter new adress: ");
            }else{
                break;
            }
        }

		while (true){
            // The phone number is not blank
            System.out.print("Enter new phone number: ");
            phone = sc.nextLine();
            if("".equals(phone)){
                System.err.println("Phone number cannot be blank. reEnter new phone number: ");
            }else{
                break;
            }
        }

		while (true){
            // The Mail is not blank
            System.out.print("Enter new Mail: ");
            mail = sc.nextLine();
            if("".equals(mail)){
                System.err.println("Mail cannot be blank. reEnter new mail: ");
            }else{
                break;
            }
        }

		while (true){
            // The Agency is not blank
            System.out.print("Enter new Agency: ");
            agency = sc.nextLine();
            if("".equals(mail)){
                System.err.println("Agency cannot be blank. reEnter new agency: ");
            }else{
                break;
            }
        }
        
        while (true){
            // Salary
            System.out.print("Enter new Salary: ");
            salary = Double.parseDouble(sc.nextLine());
            if (salary <= 0){
                System.err.println("Salary cannot be negative or zero, please reEnter new Salary: ");
            }else{
                break;
            }
        }
        
		Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        // Create a new employee from inputted data
        Employees newEmployee = new Employees(address, phone, mail, ID, agency, firstname, lastname, sex, salary, dob);

        // Add a new brand to the list
        Employeeslist.add(newEmployee);
        System.out.println("New employee added.");
    }

	public boolean removeEmployee(){
        System.out.println("Enter ID of the employee you want to remove: ");
        String eID = sc.nextLine();
        int pos = searchID(eID);
        if(pos < 0){
            System.out.println("No employee detected");
            return false;
        }else{
            Employeeslist.remove(pos);
        }
        return true;
    }

	public void updateEmployee() throws ParseException{
        String ID, firstname, lastname, sex, date, address, phone, mail, agency;
        double salary;
		
		System.out.print("Enter ID of the employee to be updated: ");
        ID = sc.nextLine();
        int pos = searchID(ID);
        if (pos < 0){
            System.out.println("Not found!");
        }else{

			while(true){
				// constraint. Input ID can not exist in the list
				System.out.print("Enter new ID: ");
				ID = sc.nextLine();
				if ("".equals(ID)){
					System.err.println("Employee ID cannot be blank, reEnter the ID: ");
				}else{
					if (searchID(ID) >= 0){
						System.out.println("ID Existed! Enter new ID: ");
					}else{
						break;
					}
				}
			}

			while (true){
				// The First name is not blank
				System.out.print("Enter new First name: ");
				firstname = sc.nextLine();
				if("".equals(firstname)){
					System.err.println("First name cannot be blank. reEnter new First name: ");
				}else{
					break;
				}
			}

			while (true){
				// The Last name is not blank
				System.out.print("Enter new Last name: ");
				lastname = sc.nextLine();
				if ("".equals(lastname)){
					System.err.println("Last name cannot be blank, reEnter new Last name: ");
				}else{
					break;
				}
			}

			while (true){
				// The DoB is not blank
				System.out.print("Enter new Date of Birth: ");
				date = sc.nextLine();
				if("".equals(date)){
					System.err.println("Date of Birth cannot be blank. reEnter new DoB: ");
				}else{
					break;
				}
			}

			while (true){
				// The sex is not blank
				System.out.print("Enter new sex: ");
				sex = sc.nextLine();
				if("".equals(sex)){
					System.err.println("Sex cannot be blank. reEnter new sex: ");
				}else{
					break;
				}
			}

			while (true){
				// The adress is not blank
				System.out.print("Enter new address: ");
				address = sc.nextLine();
				if("".equals(address)){
					System.err.println("Adress cannot be blank. reEnter new adress: ");
				}else{
					break;
				}
			}

			while (true){
				// The phone number is not blank
				System.out.print("Enter new phone number: ");
				phone = sc.nextLine();
				if("".equals(phone)){
					System.err.println("Phone number cannot be blank. reEnter new phone number: ");
				}else{
					break;
				}
			}

			while (true){
				// The Mail is not blank
				System.out.print("Enter new Mail: ");
				mail = sc.nextLine();
				if("".equals(mail)){
					System.err.println("Mail cannot be blank. reEnter new mail: ");
				}else{
					break;
				}
			}

			while (true){
				// The Agency is not blank
				System.out.print("Enter new Agency: ");
				agency = sc.nextLine();
				if("".equals(mail)){
					System.err.println("Agency cannot be blank. reEnter new agency: ");
				}else{
					break;
				}
			}

			while (true){
				// Salary
				System.out.print("Enter new Salary: ");
				salary = Double.parseDouble(sc.nextLine());
				if (salary <= 0){
					System.err.println("Salary cannot be negative or zero, please reEnter new Salary: ");
				}else{
					break;
				}
			}
        
			Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		
			Employeeslist.get(pos).setID(ID);
			Employeeslist.get(pos).setFirstName(firstname);
			Employeeslist.get(pos).setLastName(lastname);
			Employeeslist.get(pos).setDoB(dob);
			Employeeslist.get(pos).setSex(sex);
			Employeeslist.get(pos).setAddress(address);
			Employeeslist.get(pos).setPhone(phone);
			Employeeslist.get(pos).setMail(mail);
			Employeeslist.get(pos).setSalary(salary);
			Employeeslist.get(pos).setAgency(agency);
		}
		System.out.println("Employee's informations updated successfully!!");
    }

	public void listemployees() throws IOException{
		System.out.println("\n ------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    ID    |  first name  |  last name  |  Date of Birth |  sex  |       Address       |    phone    |        mail       |    agency    |    Salary    |");
        System.out.println(" ----------|--------------|-------------|----------------|-------|---------------------|-------------|-------------------|--------------|--------------|");
		for (int i = 0; i < Employeeslist.size(); i++){
			System.out.println(Employeeslist.get(i).screenString());
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

    public void listEmployeesBySalaryAscend(){
        Collections.sort(Employeeslist, new Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) {
                return(Double.compare(o1.getSalary(), o2.getSalary()));
            }
        });
		System.out.println("\n ------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    ID    |  first name  |  last name  |  Date of Birth |  sex  |       Address       |    phone    |        mail       |    agency    |    Salary    |");
        System.out.println(" ----------|--------------|-------------|----------------|-------|---------------------|-------------|-------------------|--------------|--------------|");
		for(Employees i: Employeeslist){
            System.out.println(i.screenString());
        }
        System.out.println(" ----------------------------------------------\n");
    }

	public void listEmployeesBySalaryDescend(){
        Collections.sort(Employeeslist, new Comparator<Employees>() {
            @Override
            public int compare(Employees o1, Employees o2) {
                return(-(Double.compare(o1.getSalary(), o2.getSalary())));
            }
        });
		System.out.println("\n ------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|    ID    |  first name  |  last name  |  Date of Birth |  sex  |       Address       |    phone    |        mail       |    agency    |    Salary    |");
        System.out.println(" ----------|--------------|-------------|----------------|-------|---------------------|-------------|-------------------|--------------|--------------|");
		for(Employees i: Employeeslist){
            System.out.println(i.screenString());
        }
        System.out.println(" ----------------------------------------------\n");
    }
}
