
package Stack_Linked_List;

import static java.lang.System.exit;
import java.util.EmptyStackException;

public class Stack {
	Node top;
	
	// constructor
	public Stack() {
		this.top = null;
	}

	public void push(int x){
		Node p = new Node(x);
		
		if(isEmpty()){
			top = p;
		}else{
			p.next = top;
			top = p;
		}
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

	// utility to clear the stack
	public void clear(){
		top = null;
	}

	// utility to return the top of the stack
	public int top() throws EmptyStackException{
		if (isEmpty()){
			throw new EmptyStackException();
		}
		return top.data;
	}

	// utility function to pop top element from the stack 
	public int pop() throws EmptyStackException{
		// check for stack underflow
		if (top == null){
			throw new EmptyStackException();
		}

		// update the top pointer to point to the next node
		int x = top.data;
		top = (top).next;
		return x;
	}

	public void display(Node p){
		// check for stack underflow
		if (top == null){
			System.out.println("\nStack Underflow");
			exit(1);
		}else{
			while(p != null){
				System.out.print(p.data + " ");
				if (p.next != null){
					System.out.print(" -> ");
				}
				p = p.next;
			}
		}
	}
}
