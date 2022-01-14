
import java.lang.*;
import java.util.*;

public class Person{
	protected String FirstName, LastName, sex;
	protected Date DoB;
	// DoB = Date of birth

	public Person() {
	}

	public Person(String FirstName, String LastName, Date DoB, String sex) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DoB = DoB;
		this.sex = sex;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public Date getDoB() {
		return DoB;
	}

	public String getSex() {
		return sex;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public void setDoB(Date DoB) {
		this.DoB = DoB;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

}
