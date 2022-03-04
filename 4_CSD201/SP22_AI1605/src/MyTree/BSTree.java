package MyTree;

import java.util.*;

public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    /*
    public boolean readFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null) {
                //Process this line, format: Name | age)
                line = line.trim();
                if (line.length() > 0) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String name = stk.nextToken().trim();
                    if (name.endsWith("y")) {
                        continue;
                    }
                    String artist = stk.nextToken().trim();
                    int rated = Integer.parseInt(stk.nextToken().trim());
                    if (rated <= 1) {
                        continue;
                    }
                    Song p = new Song(name, artist, rated);
                    Node newNode = new Node(p);
                    if (isEmpty()) {
                        addToHead(p);
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    */

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
    }

    public Node search1(Node p, int x) {
        if (p == null) {
            return p;
        }

        if (p.info == x) {
            return p;
        } else {
            Node foundNode = search(p.left, x);
            if (foundNode == null) {
                foundNode = search(p.right, x);
            }
            return foundNode;
        }
    }

    // return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info == key) {
            return p;
        } else if (p.info > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    public Node insertRec(Node root, int x) {
        // if the tree is empty return a new node
        if (root == null) {
            root = new Node(x);
            return root;
        }

        // otherwise, recur down the tree
        if (x < root.info) {
            root.left = insertRec(root.left, x);
        } else if (x > root.info) {
            root.right = insertRec(root.right, x);
        }

        // return the node pointer
        return root;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Insert a key x to the tree
    public void insert1(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while (q != null) {
            if (q.info == x) {
                System.out.println("Key cannot be duplicated...");
                return;
            }

            if (q.info < x) {
                f = q;
                q = q.right;
            } else {
                f = q;
                q = q.left;
            }
        }

        if (f == null) {
            root = p;
        } else if (p.info > f.info) {
            f.right = p;
        } else {
            f.left = p;
        }
    }

    // preorder traversal - (root, left, right)
    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // postorder traversal - (left, right, root)
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    // Inorder traversal (left, root, right)
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void BFT(Node p) {
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    // breadth first search on bineary tree
    // return the height of the tree
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            // compute height of each subtree
            int leftheight = height(root.left);
            int rightheight = height(root.right);

            // use the larger one
            if (leftheight > rightheight) {
                return (leftheight + 1);
            } else {
                return (rightheight + 1);
            }
        }
    }

    // print nodes at the current level 
    public void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.info + " ");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1); // level - 1: subtract the level of the root from each subtree
            printCurrentLevel(root.right, level - 1);
        }
    }

    // print level order traversal of tree
    public void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    // height of the tree
    public int height1(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);
            int rDepth = height(p.right);

            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    // Depth first search on binary tree
    /*
		preOrder
	1. Ghé thăm Node root
	2. Gọi đệ quy duyệt qua cây con bên trái
	3. Gọi đệ quy duyệt qua cây con bên phải
     */
    public void preOrder1(Node p) {
        if (p == null) {
            return;
        }

        // first print data of p
        System.out.print(p.info + " ");

        // then recur on left subtree
        preOrder(p.left);

        // recur on right subtree
        preOrder(p.right);
    }

    public void printPreorder() {
        preOrder(root);
    }

    /*
		Inorder traversal
	1. Gọi đệ quy duyệt qua cây con bên trái
	2. Ghé thăm Node root
	3. Gọi đệ quy duyệt qua cây con bên phải
     */
    public void inOrder1(Node p) {
        if (p == null) {
            return;
        }

        // recur on the left child
        inOrder(p.left);

        // then print the data of p
        System.out.print(p.info + " ");

        // recur on the right child
        inOrder(p.right);
    }

    public void printInOrder() {
        inOrder(root);
    }

    /*
		postOrder
	1. Gọi đệ quy duyệt qua cây con bên trái
	2. Gọi đệ quy duyệt qua cây con bên phải
	3. Ghé thăm Node root
     */
    public void postOrder1(Node p) {
        if (p == null) {
            return;
        }

        // recur on the left child
        postOrder(p.left);

        // recur on the right child
        postOrder(p.right);

        // print the data of p
        System.out.print(p.info + " ");
    }

    public int Count(Node root) {
        // tree is empty
        if (root == null) {
            return 0;
        }

        return 1 + Count(root.left) + Count(root.right);
    }

    public void printPostOrder() {
        postOrder(root);
    }

    public int minValue(Node root) {
        int min = root.info;
        while (root.left != null) {
            min = root.left.info;
            root = root.left;
        }
        return min;
    }

    public Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.info) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.info) {
            root.right = deleteRec(root.right, key);
        } else {
            // key is equal to root's key
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: get the smallest in the right subtree (inorder successor)
            root.info = minValue(root.right);

            // delete the inorder successor
            root.right = deleteRec(root.right, root.info);
        }
        return root;
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    public int minNode(Node root) {
        Node current = root;

        // loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }
        return current.info;
    }

    public int maxNode(Node root) {
        Node current = root;

        // loop down to find the rightmost leaf
        while (current.right != null) {
            current = current.right;
        }
        return current.info;
    }

    public int Sum(Node root) {
        // tree is empty
        if (root == null) {
            return 0;
        }
        return (root.info + Sum(root.left) + Sum(root.right));
    }

    public double avg(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = Sum(root);
        int num = Count(root);
        double avg = sum / num;
        return avg;
    }

    // delete a node on BST
    public void deleteByCopy(int x) {
        Node p = search(root, x);

        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }

        // find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }

        // Case 1: p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } // Case 2: p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } // Case 3: p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } // Case 4: p has both child
        else if (p.left != null && p.right != null) {
            // Tim q la node lon nhat cua nhanh con trai cua p -> q la con phai nhat cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }

            p.info = q.info;

            // delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does mot exists, deletion failed.");
            return;
        }

        // find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }

        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }

            Node rp = p.right;
            q.right = rp;

            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    // balancing a BST
    // inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    // insert all items from an array to a neww BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        insert(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);

        int l = a.size(), f = 0;

        // create a new tree and insert all items from a to the BST
        BSTree t = new BSTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    public Node rotateLeft(Node p) {
        if (p.right == null) {
            return p;
        }
        Node p1 = p.right;
        p.right = p1.left;
        p1.left = p;
        return p1;
    }

    public Node rotateRight(Node p) {
        if (p.left == null) {
            return p;
        }
        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        return p1;
    }
    
    // kiem tra xem node co 2 con khong
    public boolean checkDescendant(Node p){
        if (p.left != null && p.right != null){
            return true;
        }
        
        return false;
    }
    
    // duyệt preorder, tìm node đầu tiên khác root có 2 con, xoay trái node này
    public void quesion1(Node p){
        // duyet preorder
        if (p == null) {
            return;
        }
        
        if (p != root && checkDescendant(p)) {
            System.out.println("The first node other than root that has 2 descendants is: " + p.info);
            rotateLeft(p);
        }
        
        //visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    // duyệt inorder, tìm node đầu tiên khác root có height <3, xoay trái node này
    // duyệt preorder, breadth first, postorder, inorder, tìm node đầu tiên khác root có 2 con, xoá node này
    // bst with person, key là id
    

}
