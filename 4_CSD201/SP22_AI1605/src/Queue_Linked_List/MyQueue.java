
package Queue_Linked_List;

import static java.lang.System.exit;

public class MyQueue {
	protected Node head, tail;
	
	public MyQueue(){
		head = tail = null;
	}
	
	public boolean isEmpty(){
		return (head == null);
	}

	public void clear(){
		head = null;
	}
	
	// return the first element in the queue without removing it
	Object front() throws Exception{
		if (isEmpty()) 
			throw new Exception();
		return (head.data);
	}

	// take the first element from the queue
	public Object dequeue() throws Exception{
		if (isEmpty())
			throw new Exception();
		Object x = head.data;
		head = head.next;
		if (head == null){
			tail = null;
		}
		return x;
	}

	// Put the element el at the end of the queue
	void enqueue(Object x){
		if (isEmpty()){
			head = tail = new Node(x);
		}else{
			tail.next = new Node(x);
			tail = tail.next;
		}
	}

	public void display(Node p){
		// check for stack underflow
		if (head == null){
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
