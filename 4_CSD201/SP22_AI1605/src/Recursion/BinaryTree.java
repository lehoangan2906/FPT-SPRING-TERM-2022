
package Recursion;

public class BinaryTree {
	Node root;

	/*
		maxDepth()
		1. If tree is empty then return -1
		2. Else
			 (a) Get the max depth of left subtree recursively  i.e., 
				  call maxDepth( tree->left-subtree)
			 (a) Get the max depth of right subtree recursively  i.e., 
				  call maxDepth( tree->right-subtree)
			 (c) Get the max of max depths of left and right 
				  subtrees and add 1 to it for the current node.
				 max_depth = max(max dept of left subtree,  
									 max depth of right subtree) 
									 + 1
			 (d) Return max_depth
*/

	public int maxDepth(Node node){
		if (node == null)
			return -1;
		else{
			
			// compute depth of each subtree
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);

			// return the depth of the larger one
			if ( leftDepth > rightDepth){
				return (leftDepth + 1);
			}else{
				return (rightDepth + 1);
			}
		}
	}

	/*
	size(tree)
	1. If tree is empty then return 0
	2. Else
		 (a) Get the size of left subtree recursively  i.e., call 
			  size( tree->left-subtree)
		 (a) Get the size of right subtree recursively  i.e., call 
			  size( tree->right-subtree)
		 (c) Calculate size of the tree as following:
				tree_size  =  size(left-subtree) + size(right-
								   subtree) + 1
		 (d) Return tree_size
*/

	public int size(Node node){
		if (node == null)
			return 0;
		
		return (size(node.left) + size(node.right) + 1);
	}
}
