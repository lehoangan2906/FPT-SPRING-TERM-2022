
package Linked_List_with_Object;

public class Node {
	Person info;
	Node next;

	Node(Person x){
		info = new Person(x.name, x.age);
		next = null;
	}

	Node(String name, int age){
		info = new Person(name, age);
		next = null;
	}
}
