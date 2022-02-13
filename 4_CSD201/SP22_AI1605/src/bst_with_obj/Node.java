
package bst_with_obj;

public class Node {
    String info;
    Node left, right;
    
    public Node(String x){
        this.info = x;
        left = right = null;
    }
    
    public Node(String x, Node p, Node q){
        this.info = x;
        this.left = p;
        this.right = q;
    }
}
