
package Queue_Linked_List;

public class Node {
	Object data;
	Node next;

	Node(){
	}

	public Node(Object x, Node p){
		data = x;
		next = p;
	}

	Node (Object x){
		this(x, null);
	}
}
