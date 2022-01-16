
import static java.lang.System.exit;


public class Stack {
	Node top;
	
	// constructor

	public Stack() {
		this.top = null;
	}

	public void push(int x){
		// create new node temp and allocate memory
		Node temp = new Node();
		
		// check if stack (heap) is full. Then inserting an element 
		// would lead to stack overflow
		if (temp == null){
			System.out.println("\nHeap Overflow");
			return;
		}

		// initialize data into temp data field
		temp.data = x;
		
		// put top reference into temp link
		temp.link = top;

		// update top reference
		top = temp;
	}
	
	// utility function to check if the stack is empty or not
	public boolean isEmpty(){
		return top == null;
	}

	// utility function to return top element in a stack
	public int peek(){
		// check for empty stack
		if (!isEmpty()){
			return top.data;
		}else{
			System.out.println("Stack is empty");
			return -1;
		}
	}


	// utility function to pop top element from the stack 
	public void pop(){
		// check for stack underflow
		if (top == null){
			System.out.println("\nStack Underflow");
			return;
		}

		// update the top pointer to point to the next node
		top = (top).link;
	}

	public void display(Node p){
		// check for stack underflow
		if (top == null){
			System.out.println("\nStack Underflow");
			exit(1);
		}else{
			while(p != null){
				System.out.print(p.data + " ");
				if (p.link != null){
					System.out.print(" -> ");
				}
				p = p.link;
			}
		}
	}
}
