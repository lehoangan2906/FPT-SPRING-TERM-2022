package MyTree;

public class Main {

    public static void main(String[] args) {
        //        int [] x = {60, 90, 80, 100, 50, 55, 40};
//        BSTree tree = new BSTree();
//        for(int i = 0; i < x.length; i++) tree.insert(x[i]);
//        tree.preOrder(tree.root);//60 50 40 55 90 80 100
//        System.out.println("");
//        tree.inOrder(tree.root);//40 50 55 60 80 90 100
//        System.out.println("");
//        tree.BFT(tree.root);
//        System.out.println("");
//
/*
         100                               100
        /   \        Insert 40            /    \
      20     500    --------->          20     500 
     /  \                              /  \  
    10   30                           10   30
                                              \   
                                              40
 */                                             
        int[] x = {100, 20, 10, 30, 500};
        BSTree tree = new BSTree();
        for (int i = 0; i < x.length; i++) {
            tree.insert(x[i]);
        }
        tree.BFT(tree.root);
        System.out.println("");
        tree.insert(40);
        System.out.println("After insert 40: ");
        tree.BFT(tree.root);
        
        System.out.println("\n Preorder traversal: ");
        tree.preOrder(tree.root);
        
        System.out.println("\n Find the first node other than root that has 2 descendants:");
        tree.quesion1(tree.root);
        System.out.println(" ");
        tree.BFT(tree.root);
        System.out.println(" ");
        
        tree.balance(tree.root);
        tree.BFT(tree.root);
        System.out.println("");
    }
}
