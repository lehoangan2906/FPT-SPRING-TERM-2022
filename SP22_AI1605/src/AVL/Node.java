
package AVL;

public class Node {
	int key;
	int height;
	Node left;
	Node right;

	public Node() {
	}

	public Node(int key, int height, Node left, Node right) {
		this.key = key;
		this.height = height;
		this.left = left;
		this.right = right;
	}

	public Node (int x, Node p, Node q){
		key = x;
		right = p;
		left =	q;
	}

	public Node (int x){
		key = x;
		right = left = null;
	}
}
