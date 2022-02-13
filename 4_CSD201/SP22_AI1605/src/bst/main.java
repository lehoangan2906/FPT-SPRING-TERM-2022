
package bst;

public class main {
    public static void main(String[] args) {
		bst tree = new bst();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);

		/*
		2
	 
	  1    3
			  6
			5  
	  
*/

		// 1. isEmpty
		System.out.println("1. Isempty");
		System.out.println("   " + tree.isEmpty());

		// 2. Clear
		System.out.println("\n========================");
		System.out.println("2. Clear");
		//tree.clear();

		// 3. Search
		System.out.println("\n========================");
		System.out.println("3. Search");
		System.out.println(tree.search(tree.root,4));

		// 4. Insert
		System.out.println("\n========================");
		System.out.println("4. Insert");
		tree.insert(10);

		// 5. breadth traversal
		System.out.println("\n========================");
		System.out.println("Breadth first traversal: ");
		tree.printLevelOrder();

		// 6. preOrder
		System.out.println("\n========================");
		System.out.println("5. Preorder");
		tree.printPreorder();

		// 7. InOrder
		System.out.println("\n========================");
		System.out.println("6. InOrder");
		tree.printInOrder();

		// 8. PostOrder
		System.out.println("\n========================");
		System.out.println("8. PostOrder");
		tree.printPostOrder();

		// 9. count
		System.out.println("\n========================");
		System.out.println("9. Count");
		System.out.print(tree.Count(tree.root));

		// 10. delete key
		System.out.println("\n========================");
		System.out.println("10. Delete key 3");
		tree.deleteKey(3);
		System.out.println("After deletion: ");
		tree.printLevelOrder();

		// 11. Min value Node
		System.out.println("\n========================");
		System.out.println("11. Min value Node");
		System.out.println(tree.minNode(tree.root));

		// 12. Max value Node
		System.out.println("\n========================");
		System.out.println("12. Max value Node");
		System.out.println(tree.maxNode(tree.root));

		// 13. Sum
		System.out.println("\n========================");
		System.out.println("13. Sum");
		System.out.println(tree.Sum(tree.root));

		// 14. Average
		System.out.println("\n========================");
		System.out.println("14. AVG");
		System.out.println(tree.avg(tree.root));

		// 15. Height
		System.out.println("\n========================");
		System.out.println("15. Height of the tree");
		System.out.println(tree.height(tree.root));

	}
}
