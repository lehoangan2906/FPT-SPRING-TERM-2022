
package bst;

public class Node {
    int info;
	Node left, right;

	Node (int x){
		info = x;
		left = right = null;
	}

	Node (int x, Node p, Node q){
		info = x;
		left = p;
		right = q;
	}
}
