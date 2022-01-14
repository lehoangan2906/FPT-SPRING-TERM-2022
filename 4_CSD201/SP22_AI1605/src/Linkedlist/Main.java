
package Linkedlist;

public class Main {
	public static void main(String[] args) {
		MyList list = new MyList();
		list.addFirst(45);
		list.addFirst(13);
		list.addFirst(9);
		list.addFirst(99);
		list.addFirst(95);
		list.addFirst(96);
		list.addFirst(97);
		list.addFirst(98);
		list.addFirst(98);
		list.addFirst(99);
		list.addFirst(100);

		MyList list2 = new MyList();
		list2.addFirst(45);
		list2.addFirst(13);
		list2.addFirst(9);
		list2.addFirst(99);
		list2.addFirst(95);
		list2.addFirst(96);
		list2.addFirst(97);
		list2.addFirst(98);
		list2.addFirst(98);
		list2.addFirst(99);
		list2.addFirst(100);

		System.out.println("Linked list beginning contents: ");
		list.traverse(list.head);
		System.out.println("\n");

		int head_info = list.deleteFromHead();
		System.out.println("head info is: " + head_info);

		int tail_info = list.deleteFromTail();
		System.out.println("tail info is: " + tail_info);

		int deleteAfterInfo = list.deleteAfter(list.head.next.next.next);
		System.out.println("the node to be deleted: " + deleteAfterInfo);

		// delete the first node to have the given key in the linked list
		list.delete(98);
		System.out.println("The first node with the value 98 was deleted");

		// search and return the reference to the first node with the given value
		Node x = list.search(95);
		System.out.println("The reference of the node with the given value is: " + x);

		// count the number of nodes in the linked list
		int num = list.count();
		System.out.println("The number of node present in the linked list is: " + num);

		// delete an ith node in the list, besure that such node exists.
		list.dele(7);

		// sort the linked list by node's information
		//list.sort(list.head);

		// delete node p if it exists in the list
		list.dele(list.head.next);
		System.out.println("The node next to the head node is deleted");

		// an array contains all linked list's members' informations
		Array info = list.toArray();
		System.out.print("An array containing all linked list's members' info: ");
		info.print();

		// attach a singly linked list to the end of another singly linked list
		list.attach(list2);
		System.out.println("\ntwo lists after attached: ");
		list.traverse(list.head);

		// find and return the maximum value in the list
		int max = list.max();
		System.out.println("\nThe max value in linked list is: " + max);

		// find and retun the minimum value in the list
		int min = list.min();
		System.out.println("The min value in the linked list is: " + min);

		// return the sum of all values in the list
		int sum = list.sum();
		System.out.println("The sum of all value in the linked list is: " + sum);

		// return the average of all values in the list
		double avg = list.avg();
		System.out.println("The average of all value in the linked list: " + avg);

		// add before
		list.addBefore(list.head.next.next, 28);
		
		// reverse linked list
		System.out.println("\nOriginal Linked list: ");
		list.traverse(list.head);
		System.out.println("\nreversed linked list");
		Node head = list.reverse(list.head);
		list.traverse(head);
		System.out.println("");

	}
}
