
import java.lang.*;
import java.text.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException{

        Scanner sc = new Scanner(System.in);
	
		System.out.print("Please input date 1 (MMM/dd/yyyy): ");
		String d1 = sc.nextLine();	
		Date date1 = new SimpleDateFormat("MMM/dd/yyyy").parse(d1);

		System.out.print("Please input date 2 (dd/MM/yyyy): ");
		String d2 = sc.nextLine();
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(d2);

		System.out.println("");

        Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();			    
		cal1.setTime(date1);
		cal2.setTime(date2);

		if (cal1.after(cal2)) {
			System.out.println("Date1 is after Date2");
		}

		if (cal1.before(cal2)) {	    
			System.out.println("Date1 is before Date2");
		}

		if (cal1.equals(cal2)) {
			System.out.println("Date1 is equal Date2");
		}
	}
}	
