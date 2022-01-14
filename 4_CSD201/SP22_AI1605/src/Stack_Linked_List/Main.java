
package Stack_Linked_List;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Stack stack = new Stack();
		
		System.out.print("Enter decimal num: ");
		int num = in.nextInt();
		
		while (num != 0){
			int d = num % 2;
			stack.push(d);
			num /= 2;
		}

		System.out.println("\nBinary representation is: ");
		while(!(stack.isEmpty())){
			System.out.print(stack.pop());
		}
		System.out.println(" ");
	}
}
