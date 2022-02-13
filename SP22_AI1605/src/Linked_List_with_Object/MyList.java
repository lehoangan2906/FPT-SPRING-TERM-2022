
package Linked_List_with_Object;

public class MyList {
	Node head;
	Node tail;

	MyList(){
		head = null;
		tail = null;
	}

	boolean isEmpty(){
		return head == null;
	}

	void clear(){
		head = null;
		tail = null;
	}


	void addFirst(Person x){
		// create a Node contain information x
		Node p = new Node(x);
		
		if(isEmpty()){
			head = p;
			tail = p;
		}else{
			p.next = head;
			head = p;
		}
	}

	public int size(){
		int size = 0;
		Node p = head;
		while(p != null){
			size += 1;
			p = p.next;
		}
		return size;
	}
	
	void traverse(Node p){
		while(p != null){
			System.out.print(p.info + " ");
			if (p.next != null){
				System.out.print(" -> ");
			}
			p = p.next;
		}
	}

	void addTail(Person x){
        Node p = new Node(x);
		if (isEmpty()){
			head = p;
			tail = p;
		} else{
			while (p.next != null){
				p = p.next;
			}
			tail = p;
		}
	}
	
	void addAfter(Node prev_node, Person x){
		// check if a given Node is null
		if (prev_node == null){
			System.out.println("The given node cannot be null");
			return;
		}

		// allocate the node and put in the data
		Node new_node = new Node(x);
		
		// make next of new node as next of prev_node
		new_node.next = prev_node.next;

		// make next of prew_node as new node
		prev_node.next = new_node;
	}
	
	Person deleteFromHead(){
		// delete the head and return its info

		// check if the linked list is empty or not
		if (head == null){
			System.out.println("cannot delete from an empty list");
			return null;
		}
		
		// set head to point to the next node of the initial head
		head = head.next;
		return head.info;
	}

	Person deleteFromTail(){
		// delete the tail and return its info
		
		// check if the list if empty or not
		if (head == null){
			System.out.println("cannot delete from an empty list");
			return null;
		}

		// find the second last node and set this node to tail
		Node second_last = head;
		while(second_last.next.next != null){
			second_last = second_last.next;
		}
		second_last.next = null;
		tail = second_last;
		return second_last.info;
	}

	Person deleteAfter(Node p){
		// delete the node after the node P and returns its info
		
		// check if the linked list is empty or not
		if (head == null){
			System.out.print("cannot delete from an empty list");
			return null;
		}else if (head.next == null){
			// check if the linked list has only one node or not
			System.out.println("the list has only one node");
			return null;
		}

		// check if the node p is in the linked list or not
		Node running = head;
		int check = 0;
		while(running.next != null){
			if (running.info == p.info){
				check += 1;
			}
			running = running.next;
		}
		
		Person info = p.next.info;

		if (check == 1){
			// set the next node of node P to the next node of the node is about to be deleted
			p.next = p.next.next;
		}

		return info;
	}

	void delete(Person x){
		// delete the first node whose info is equal to x
		
		// Store the head node
		Node run = head, prev = null;

		// if head node itself has the value to be deleted
		if(run != null && run.info == x){
			head = run.next;	// change head
			return;
		}

		// search for the key to be deleted, keep track of the previous node 
		// as we need to change temp.next
		while(run != null && run.info != x){
			prev = run;
			run = run.next;
		}
		
		// if key is not present in linked list
		if (run == null){
			return;
		}

		// delete the node
		prev.next = run.next;

	}

	public Person get(int i){
		Node run = head;
		int count = 0;
		while(run != null && count != i){
			count += 1;
			run = run.next;
		}

		if (run == null){
			return null;
		}

		return run.info;
	}

	Node search(Person x){
		// search and return the reference to the first node having info x
		
		Node run = head;
		int count;
		while(run != null && run.info != x){
			run = run.next;
		}
		
		if (run == null){
			return null;
		}
		
		return run;
	}

	int count(){
		// count and return the number of nodes in the linked list
		
		int count = 0;
		Node counter = head;
		while(counter != null){
			count += 1;
			counter = counter.next;
		}

		return count;
	}

	void dele(int i){
		// delete an ith node in the list, besure that such node exists.
		
		int count = 0;
		Node running = head, init = null;
		while(running != null && count < i-1){
			// the linked list indices starting from 0 so the ith node is in the index i-1
			count += 1;
			init = running;
			running = running.next;
		}

		if (running == null){
			System.out.println("The linked list doesn't contain the " + i + "th node");
			return;
		}else{
			// delete the ith node
			System.out.println("The " + i + "th node's info is " + running.info + " and it was deleted ");
			init.next = running.next;
		}

	}

	void dele(Node p){
		// delete node p if it exists in the list

		// check if the list is empty or not
		if (head == null){
			System.out.println("The linked list is null");
			return ;
		}

		Node run = head, prev = null;
		while(run != null && run != p){
			prev = run;
			run = run.next;
		}
		
		// if p is not in linked list
		if (run == null){
			return ;
		}

		prev.next = run.next;

	}

	void addBefore(Node p, Person x){
		// add a node with value x before the node p

		// check if a given Node is null
		if (p == null){
			System.out.println("The given node cannot be null");
			return;
		}
		
		Node run = head, prev = null;
		while(run.info != p.info && run != null){
			prev = run;
			run = run.next;
		}

		Node new_node = new Node(x);
		new_node.next = run;
		prev.next = new_node;
	}

	void attach(MyList listb){
		// attach a singly linked list to the end of another singly linked list
		
		Node a = this.head;
		while (a.next != null){
			a = a.next;
		}
		
		a.next = listb.head;
	}

	boolean sorted(){
		// check and return true if the list is sorted, return false if the list is not sorted
		
		// check if the list is empty or not
		if (head == null)
			return true;

		for (Node t = head; t.next != null; t = t.next){
			if (t.info.compareTo(t.next.info) > 0){
				return false;
			}
		}
		return true;
	}

	Node reverse(Node p){
		// reverse a singly linked list using only one pass through the list
		
		Node prev = null;
		Node current = p;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		p = prev;
		return p;
	}
	
	boolean checkContents(MyList list2){
		// check whether two singly linked list have the same contents.
		
		Node a = this.head;
		Node b = list2.head;
		while (a != null && b != null){
			if (a.info != b.info){
				return false;
			}
			
			a = a.next;
			b = b.next;
		}
		return (a == null && b == null);
	}
}
