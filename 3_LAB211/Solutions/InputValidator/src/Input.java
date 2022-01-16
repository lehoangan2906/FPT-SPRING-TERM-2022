
import java.lang.*;
import java.util.*;

public class Input {
	public static Scanner sc = new Scanner(System.in);

	// constructor
	public Input(){

	}

	public static String inputStr(String msg, String input){
		String data;
		do{
			System.out.print(msg);
			data = sc.nextLine().trim();
		}while(!data.matches(input));

		return data;
	}

	public int inputInt(String msg, int min, int max){
		int data;
		do{
			System.out.print(msg);
			try{
				data = Integer.parseInt(sc.nextLine());
				if (min <= data && data <= max){
					return data;
				}
			}catch(Exception e){	
				System.out.println("Invalid value. Enter the input again");
			}
		}while(true);
	}


	// input non blank string
	public static String inputNonBlankStr(String msg){
		String data;
		do {
			System.out.print(msg);
			data = sc.nextLine().trim();
		}while(data.length() < 1);

		return data;
	}
	




	public static void main(String[] args) {
		
	}
	
}
