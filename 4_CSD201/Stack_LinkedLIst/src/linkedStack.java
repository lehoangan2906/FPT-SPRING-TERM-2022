
import java.util.EmptyStackException;


public class linkedStack {
	protected Node head;

	public linkedStack(Node head) {
		this.head = null;
	}

	public boolean isEmpty(){
		return (head == null);
	}

	public void push(Object x){
		head = new Node(x, head);
		
	}

	Object top() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException();
		return (head.info);
	}

	public Object pop() throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException();
			Object x = head.info;
			head = head.next;
			return (x);
	}
	

}
