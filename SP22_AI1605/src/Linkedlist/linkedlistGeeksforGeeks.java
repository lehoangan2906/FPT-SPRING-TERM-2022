
package Linkedlist;

// A comple working Java program to demonstrate all insert on linked list
class LinkedList{
	Node head; // head of the list

	/* Linked list Node */
	class Node{
		int data;
		Node next;

		Node (int d){
			data = d;
			next = null;
		}
	}
	
	/* inserts a new node at front of the list */
	public void push(int new_data){

		// allocate the Node and Put in the data
		Node new_node = new Node(new_data);
		
		// make next of the new Node as head
		new_node.next = head;

		// move the head to point to new Node
		head = new_node;
	}

	/* inserts a new node after the given prev_node */
	public void insertAfter(Node prev_node, int new_data){
		
		// check if the given node is null
		if (prev_node == null){
			System.out.println("The given node cannot be null");
			return;
		}

		// allocate the Node and put in the data
		Node new_node = new Node(new_data);
		
		// make next of the new node as the next of the prev_node
		new_node.next = prev_node.next;

		// make the next of prev_node as the new_node
		prev_node.next = new_node;
	}

	/* appends a new node at the end. This method is defined inside linkedlist class shown above */
	public void append(int new_data){
		/* 1. Allocate the Node & 2. Put in the data 3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the new node as head */
        if (head == null){
            head = new_node;
			// because this node is the first node in the linked list so the next node is automatically set to null
            return;
        }

        /* 4. Else traverse till the last node */
        Node last = head; 
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
	}

	/* this function prints contents of linked list starting at the given node */
	public void printList(){
		Node tnode = head;
		while (tnode != null){
			System.out.print(tnode.data);
			if (tnode.next != null){
				System.out.print(" -> ");
			}
			tnode = tnode.next;
		}
	}


} // end of class


/* driver code */
public class linkedlistGeeksforGeeks {
	public static void main(String[] args) {
		
		// start with the empty list
		LinkedList list = new LinkedList();

		// Insert the node with data "6". Linked list becomes 6 -> Null
		list.append(6);

		// Insert the node with data "7". Linked list becomes 6 -> 7 -> Null
		list.append(7);

		// Insert the node with data "1" at the beginning. Linked list becomes 1 -> 6 -> 7 -> Null
		list.push(1);

		// Insert 4 at the end. Linked list becomes 1 -> 6 -> 7 -> 4 -> Null
		list.append(4);

		// Insert 8 after 7. Linked list becomes 1 -> 6 -> 7 -> 8 -> 4 -> Null
		list.insertAfter(list.head.next.next, 8);

		list.printList();
	}
}
