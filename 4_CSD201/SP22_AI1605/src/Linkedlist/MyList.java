
package Linkedlist;

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

	void addFirst(int x){
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
	
	void traverse(Node p){
		while(p != null){
			System.out.print(p.info + " ");
			if (p.next != null){
				System.out.print(" -> ");
			}
			p = p.next;
		}
	}

	void addTail(int x){
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
	
	void addAfter(Node prev_node, int x){
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
	
	int deleteFromHead(){
		// delete the head and return its info

		// check if the linked list is empty or not
		if (head == null){
			System.out.println("cannot delete from an empty list");
			return 0;
		}
		
		// set head to point to the next node of the initial head
		head = head.next;
		return head.info;
	}

	int deleteFromTail(){
		// delete the tail and return its info
		
		// check if the list if empty or not
		if (head == null){
			System.out.println("cannot delete from an empty list");
			return 0;
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

	int deleteAfter(Node p){
		// delete the node after the node P and returns its info
		
		// check if the linked list is empty or not
		if (head == null){
			System.out.print("cannot delete from an empty list");
			return 0;
		}else if (head.next == null){
			// check if the linked list has only one node or not
			System.out.println("the list has only one node");
			return 0;
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
		
		int info = p.next.info;

		if (check == 1){
			// set the next node of node P to the next node of the node is about to be deleted
			p.next = p.next.next;
		}

		return info;
	}

	void delete(int x){
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

	Node search(int x){
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

	Array toArray(){
		// Create and return array containing info of all nodes in the list

		int count = 0;
		Array dynamic = new Array(1);
		Node run = head;
		while(run != null){
			dynamic.add(run.info);
			count += 1;
			run = run.next;
		}

		return dynamic;
	}
	
	void Merge(){
		// merge two ordered singly linked lists of integers into one ordered list
	} 

	void addBefore(Node p, int x){
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

	int max(){
		// find and return the maximum value in the list

		// check if the linked list is empty or not
		if (head == null || head.next == null){
			return head.info;
		}
		int max = head.info;
		Node run = head.next;
		while(run != null){
			if (run.info >= max){
				max = run.info;
			}
			run = run.next;
		}
	
		return max;
	}

	int min(){
		// find and retun the minimum value in the list

		// check if the linked list is empty or not
		if (head == null || head.next == null){
			return head.info;
		}
		int min = head.info;
		Node run = head.next;
		while(run != null){
			if (run.info < min){
				min = run.info;
			}
			run = run.next;
		}
	
		return min;
	}

	int sum(){
		// return the sum of all values in the list

		// check if the linked list is empty or not
		if (head == null || head.next == null){
			return head.info;
		}
		int sum = 0;
		Node run = head;
		while(run != null){	
			sum += run.info;
			run = run.next;
		}
	
		return sum;
	}

	double avg(){
		// return the average of all values in the list

		// check if the linked list is empty or not
		if (head == null || head.next == null){
			return head.info;
		}

		int sum = 0;
		int count = 0;
		Node run = head;
		while(run != null){	
			sum += run.info;
			count += 1;
			run = run.next;
		}
		
		return sum/count;
	}

	boolean sorted(){
		// check and return true if the list is sorted, return false if the list is not sorted
		
		// check if the list is empty or not
		if (head == null)
			return true;

		for (Node t = head; t.next != null; t = t.next){
			if (t.info < t.next.info){
				return false;
			}
		}
		return true;
	}

	void insert(int x){
		// insert node with value x into sorted list so that the new list is sorted

		Node new_node = new Node(x);

		// If the list is empty then make the node as head and return it
		if (head == null){
			head = new_node;
		}

		// If the value of the node to be inserted is smaller than the value of the head node,
		// then insert the node at the start and make it head
		if (x < head.info){
			new_node.next = head;
			head = new_node;
		}
		
		// In a loop, find the appropiate node after which the input node is to be inserted.
		// To find the appropriate node start from the head, keep moving until you reach a node GN
		// whose value is greater than the input node. The node just before GN is the appropriate node.

		Node run = head, prev = null;
		while(run != null && run.info < x){
			prev = run;
			run = run.next;
		}
		
		new_node.next = run;
		prev.next = new_node;
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
