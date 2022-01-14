
import java.util.Date;


public class Employees implements Comparable<Employees>{
	private String address, phone, mail, ID, agency, FirstName, LastName, sex;
	private double salary;
	private Date DoB;

	public Employees(){

	}

	public Employees(String address, String phone, String mail, String ID, String agency, String FirstName, String LastName, String sex, double salary, Date DoB) {
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		this.ID = ID;
		this.agency = agency;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.sex = sex;
		this.salary = salary;
		this.DoB = DoB;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	public String getID() {
		return ID;
	}

	public String getAgency() {
		return agency;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getSex() {
		return sex;
	}

	public double getSalary() {
		return salary;
	}

	public Date getDoB() {
		return DoB;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDoB(Date DoB) {
		this.DoB = DoB;
	}


	public String screenString(){
		System.out.printf("|%8s|%15s|%15s|%15s|%8s|%30s|%10s|%15s|%8s|%10s|", ID, FirstName, LastName, DoB, sex, address, phone, mail, agency, salary);
		return "";
	}

	@Override
    public int compareTo(Employees o2) {
		int d = Double.compare(this.salary, o2.salary);
        if (d!=0) 
            return d;
        // they are in the same brand, comparing based on their ID
        return Double.compare(this.salary, o2.salary);
    }
}
