
public class Main {

	public static void main(String[] args) {
		
		// create instance of class
		Stack obj = new Stack();
		
		// insert stack value
		obj.push(12);
		obj.push(22);
		obj.push(34);
		obj.push(44);

		// print stack elements
		obj.display(obj.top);

		// print top element of stack
		System.out.printf("\nTop element is %d\n", obj.peek());

		// delete top element of stack
		obj.pop();
		obj.pop();

		// print stack elements
		obj.display(obj.top);

		// print top element of stack
		System.out.printf("\nTop element is %d\n", obj.peek());
	}
	
}
