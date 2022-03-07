
import java.io.FileNotFoundException;



/**
 *
 * @author tourist
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BSTree tree = new BSTree();
        
        /*
        Question 1: Read each song information from file "song.txt", 
        if the name contains "Paris" or the rating <3, do nothing, otherwise 
        insert that song information to the tree
        */
        System.out.println("Question 1:\n");
        tree.loadFromFile("src\\song.txt");
        tree.BFT(tree.root);
        System.out.println("\n");
        
        /*
        Question 2: Calculate balance factor of all nodes. Write to file "q2.out". 
        All node with balance factor by breadth-first traverse, also the information
        about a given binary search tree is height balanced (AVL tree) or not.
        */
        System.out.println("Question 2:\n");
        tree.writeToFile2(tree, "src\\q2.out");
        System.out.println("\n");
        
        /*
        Question 3: Perform breadth first traverse from the root and delete by copying 
        the first node having both 2 sons and height < 5, write the tree to the file "q3.txt".
        */
        System.out.println("Question 3:\n");
        tree.writeToFile3(tree, "src\\q3.txt");
        System.out.println("\n");
        
        /*
        Question 4: Balance a binary search tree by simple balancing algorithm. Display all node 
        by breadth-first traverse.
        */
        System.out.println("Question 4:\n");
        tree.question4(tree.root);
        
    }
    
}
