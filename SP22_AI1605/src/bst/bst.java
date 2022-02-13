
package bst;

public class bst {
    Node root;

    public bst(){
	this.root = null;
    }

    public boolean isEmpty(){
        if (root == null)
            return true;
	else
            return false;
    }

    public void clear(){
	root = null;
    }


    public Node search(Node p, int x){
        if (p == null){
            return p;
	}	

	if (p.info == x){
            return p;
        }else{
            Node foundNode = search(p.left, x);
            if (foundNode == null){
		foundNode = search(p.right, x);
            }
            return foundNode;
        }
    }

    public Node insertRec(Node root, int x){
	// if the tree is empty return a new node
	if (root == null){
            root = new Node(x);
            return root;
        }

        // otherwise, recur down the tree
	if (x < root.info)
            root.left = insertRec(root.left, x);
	else if (x > root.info)
            root.right = insertRec(root.right, x);

            // return the node pointer
            return root;
    }

    public void insert(int key){
	root = insertRec(root, key);
    }

// breadth first search on bineary tree

    // return the height of the tree
    public int height(Node root){
	if (root == null)
            return 0;
	else{
            // compute height of each subtree
            int leftheight = height(root.left);
            int rightheight = height(root.right);

            // use the larger one
            if (leftheight > rightheight)
		return (leftheight + 1);
            else
		return (rightheight + 1);
        }
    }

    // print nodes at the current level 
    public void printCurrentLevel(Node root, int level){
	if (root == null)
            return;
	if (level == 1)
            System.out.print(root.info + " ");	
	else if (level > 1){
            printCurrentLevel(root.left, level - 1); // level - 1: subtract the level of the root from each subtree
            printCurrentLevel(root.right, level - 1);
        }
    }

    // print level order traversal of tree
    public void printLevelOrder(){
	int h = height(root);
	int i;
	for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }


// Depth first search on binary tree
	/*
		preOrder
	1. Ghé thăm Node root
	2. Gọi đệ quy duyệt qua cây con bên trái
	3. Gọi đệ quy duyệt qua cây con bên phải
*/
    public void preOrder(Node p){
	if (p == null){
            return;
	}

	// first print data of p
	System.out.print(p.info + " ");

	// then recur on left subtree
	preOrder(p.left);

	// recur on right subtree
	preOrder(p.right);
    }

    public void printPreorder(){
	preOrder(root);
    }

	/*
		Inorder traversal
	1. Gọi đệ quy duyệt qua cây con bên trái
	2. Ghé thăm Node root
	3. Gọi đệ quy duyệt qua cây con bên phải
	*/
    public void inOrder(Node p){
	if (p == null){
            return;
	}
		
	// recur on the left child
	inOrder(p.left);

	// then print the data of p
	System.out.print(p.info + " ");

	// recur on the right child
	inOrder(p.right);
    }

    public void printInOrder(){
	inOrder(root);
    }

    /*
	postOrder
	1. Gọi đệ quy duyệt qua cây con bên trái
	2. Gọi đệ quy duyệt qua cây con bên phải
	3. Ghé thăm Node root
    */
    public void postOrder(Node p){
	if ( p == null){
            return;
	}

	// recur on the left child
	postOrder(p.left);

	// recur on the right child
	postOrder(p.right);

	// print the data of p
	System.out.print(p.info + " ");
    }

    public int Count(Node root){
	// tree is empty
	if (root == null)
            return 0;
		
        return 1 + Count(root.left) + Count(root.right);
    }

    public void printPostOrder(){
	postOrder(root);
    }

    public int minValue(Node root){
	int min = root.info;
	while(root.left != null){
            min = root.left.info;
		root = root.left;
            }
	return min;
    }

    public Node deleteRec(Node root, int key){
	if (root == null)
            return root;

            if (key < root.info){
		root.left = deleteRec(root.left, key);
            }else if (key > root.info){
		root.right = deleteRec(root.right, key);
            }else{
		// key is equal to root's key
		if (root.left == null)
                    return root.right;
		else if (root.right == null)
                    return root.left;

                    // node with two children: get the smallest in the right subtree (inorder successor)
                    root.info = minValue(root.right);

                    // delete the inorder successor
                    root.right = deleteRec(root.right, root.info);
            }
        return root;
    }

	public void deleteKey(int key){
		root = deleteRec(root, key);
	}

    public int minNode(Node root){
	Node current = root;
		
	// loop down to find the leftmost leaf
	while(current.left != null){
            current = current.left;
	}
	return current.info;
    }

    public int maxNode(Node root){
        Node current = root;
		
	// loop down to find the rightmost leaf
	while(current.right != null){
            current = current.right;
            }
            return current.info;
    }

    public int Sum(Node root){
	// tree is empty
	if (root == null)
            return 0;
        return (root.info + Sum(root.left) + Sum(root.right));
    }

    public double avg(Node root){
        if (root == null){
            return 0;
	}

        int sum = Sum(root); 
        int num = Count(root);
        double avg = sum/num;
        return avg;
	}
        
    public void del(int x) {
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        
        //traverse
        while (p != null) {
            if (p.info == x) {
                break;
            }
            parent = p;
            if (p.info > x) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //p=null, x not found
        if (p == null) {
            return;
        }
        //p==x
        //if p has no leaf or p is a leaf
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            //if p has only one child
        } else if (p.left != null && p.right == null) {
            if (parent == null) {
                root = p.left;
            } else if (parent.left == p) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else if (p.left == null && p.right != null) {
            if (parent == null) {
                root = p.right;
            } else if (parent.left == p) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
            //if p has 2 childs
        } else {
            delByCopying(p);
        }
    }
    
    public void delByCopying(Node p) {
        Node rm = p.left;
        Node parentRm = p;
        while (rm.right != null) {
            parentRm = rm;
            rm = rm.right;
        }
        p.info = rm.info;
        if (parentRm == p) {
            /*
                delete
              /        \
       skip this        *
        /
        *    
            */
            p.left = rm.left;
        } else {
            
            parentRm.right = null;
        }
        /*
              p=parent  ->         p=rm
          p.l=rm    p.r        *           p.r
      *                    *     * 
        
   *    * 
        
                    p   ->      ->                 p= rm
      p.l =parent       p.r             p.l = parent      p.r
        
  p.l.l        p.l.r = rm        p.l.l    p.l.r=rm
         */
    }
    
    public int mystery(Node x) {
        if (x == null)
            return 0;
        else
            return Math.max(mystery(x.left), mystery(x.right));
    }
    
    public int maxCostPath(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.info;
        }
        int left = maxCostPath(root.left);
        int right = maxCostPath(root.right);
        return ((left > right) ? left : right) + root.info;
    }
}
