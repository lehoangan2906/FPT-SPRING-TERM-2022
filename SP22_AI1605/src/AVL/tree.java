
package AVL;

public class tree {
	private Node root;

	public int height(Node n){
		return n == null ? -1 : n.height;
	}

	public void updateHeight(Node n){
		n.height = 1 + Math.max(height(n.left), height(n.right));
	}

	public int getBalance(Node n){
		return (n == null) ? 0 : height(n.right) - height(n.left);
	}

	public Node rotateRight(Node y){
		Node x = y.left;
		Node z = x.right;
		x.right = y;
		y.left = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	public Node rotateLeft(Node y){
		Node x = y.right;
		Node z = x.left;
		x.left = y;
		y.right = z;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	public Node rebalance(Node z){
		updateHeight(z);
		int balance = getBalance(z);
		if (balance > 1){
			if (height(z.right.right) > height (z.right.left)){
				z = rotateLeft(z);
			} else {
				z.right = rotateRight(z.right);
				z = rotateLeft(z);
			}
		} else if (balance < -1) {
			if (height(z.left.left) > height (z.left.right))
				z = rotateRight(z);
			else
				z.left = rotateLeft(z.left);
				z = rotateRight(z);
		}
		return z;
	}


	// one key is unique on the entire tree
	public Node insert(Node node, int key){
		if (node == null){
			return new Node(key);
		}else if (node.key > key) {
			node.left = insert(node.left, key);
		}else if (node.key < key) {
			node.right = insert(node.right, key);
		}else{
			throw new RuntimeException("duplicate Key!");
		}
		return rebalance(node);
	}

}
