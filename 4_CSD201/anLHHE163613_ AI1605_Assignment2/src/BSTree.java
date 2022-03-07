
import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Math.abs;

/**
 *
 * @author tourist
 */
public class BSTree {

    Song root;

    // Constructor
    BSTree() {
        root = null;
    }

    // return the height of the tree
    public int height(Song root) {
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

    public String minValue(Song root) {
        String min = root.id;
        while (root.left != null) {
            min = root.left.id;
            root = root.left;
        }
        return min;
    }

    // delete node in the tree
    public Song deleteRec(Song root, String id) {
        if (root == null) {
            return root;
        }

        if (id.compareTo(root.id) < 0) {
            root.left = deleteRec(root.left, id);
        } else if (id.compareTo(root.id) > 0) {
            root.right = deleteRec(root.right, id);
        } else {
            // key is equal to root's key
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: get the smallest in the right subtree (inorder successor)
            root.id = minValue(root.right);

            // delete the inorder successor
            root.right = deleteRec(root.right, root.id);
        }
        return root;
    }

    public void deleteKey(String id) {
        root = deleteRec(root, id);
    }

    // helper functions of question 1:
    // insert song
    public Song insertRec(Song root, String id, String name, double rating) {
        // if the tree is empty return a new node
        if (root == null) {
            root = new Song(id, name, rating);
            return root;
        }

        // otherwise, recur down the tree
        if (id.compareTo(root.id) > 0) {
            root.left = insertRec(root.left, id, name, rating);
        } else if (id.compareTo(root.id) < 0) {
            root.right = insertRec(root.right, id, name, rating);
        }

        // return the node pointer
        return root;
    }

    public void insert(String id, String name, double rating) {
        root = insertRec(root, id, name, rating);
    }

    public void visit(Song s) {
        if (s == null) {
            return;
        }
        System.out.print("(" + s.id + "," + s.name + "," + s.rating + ")\n");
    }

    public boolean loadFromFile(String filename) throws FileNotFoundException {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try (FileReader fr = new FileReader(f);
                    BufferedReader bf = new BufferedReader(fr)) {
                String line;
                while ((line = bf.readLine()) != null) {
                    line = line.trim();
                    if (line.length() > 0) {
                        StringTokenizer stk = new StringTokenizer(line, "|");
                        String id = stk.nextToken().trim();
                        String name = stk.nextToken();
                        double rated = Double.parseDouble(stk.nextToken().trim());
                        Song s = new Song(id, name, rated);
                        if (name.contains("Paris") || rated < 3) {

                        } else {
                            this.insert(id, name, rated);
                        }
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println(e);
                return false;
            }
        }
        return true;
    }

    // breadth first traversal
    public void BFT(Song p) {
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Song q = (Song) m.dequeue();
            visit(q);
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    // question 2 helper functions
    public boolean writeToFile2(BSTree tree, String filename) {
        try (FileWriter fw = new FileWriter(filename); PrintWriter pw = new PrintWriter(fw)) {
            Song song = this.root;
            this.BFT2(pw);
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    // breadth first traversal for question 2
    public void BFT2(PrintWriter pw) {
        if (root == null) {
            return;
        }

        MyQueue m = new MyQueue();
        m.enqueue(root);

        while (!m.isEmpty()) {
            try {
                Song q = (Song) m.dequeue();
                pw.print("(" + q.id + "," + q.name + "," + q.rating + "," + BalanceFactor(q) + ")\n");
                if (q.left != null) {
                    m.enqueue(q.left);
                }
                if (q.right != null) {
                    m.enqueue(q.right);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (AVL(this.root)) {
            pw.println("The tree is an AVL tree.");
        } else {
            pw.println("The tree is not an AVL tree");
        }
    }

    // return the balance factor of a node p
    public int BalanceFactor(Song root) {
        return this.height(root.left) - this.height(root.right);
    }

    // returns true if the given tree is AVL and vice versa
    public boolean AVL(Song root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (abs(leftHeight - rightHeight) <= 1 && AVL(root.left) && AVL(root.right)) {
            return true;
        }
        return false;
    }

    // helper functions of question 3
    public void deleteByCopy(Song song) {
        Song remove = song.left;
        Song parentRm = song;
        while (remove.right != null) {
            parentRm = remove;
            remove = remove.right;
        }

        song.id = remove.id;
        song.name = remove.name;
        song.rating = remove.rating;
        if (parentRm == song) {
            song.left = remove.left;
        } else {
            parentRm.right = null;
        }
    }

    // breadth first traversal
    public void BFT33(PrintWriter pw) {
        if (root == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(root);
        while (!m.isEmpty()) {
            Song q = (Song) m.dequeue();
            pw.println("(" + q.id + "," + q.name + "," + q.rating + ")");
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    public boolean writeToFile3(BSTree tree, String filename) {
        // traverse then delete
        this.BFT3();
        
        try (FileWriter fw = new FileWriter(filename); PrintWriter pw = new PrintWriter(fw)) {
            Song song = this.root;
            // write the deleted version to the file
            this.BFT33(pw);
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    // breadth first traversal
    // this function is used to delete the desire node as well
    public void BFT3() {
        if (root == null) {
            return;
        }

        MyQueue m = new MyQueue();
        m.enqueue(root);
        Song q = null;

        while (!m.isEmpty()) {
            try {
                Song p = (Song) m.dequeue();
                if (p.left != null) {
                    m.enqueue(p.left);
                }
                if (p.right != null) {
                    m.enqueue(p.right);
                }
                if (p != root && p.left != null && p.right != null && height(p) < 5) {
                    q = p;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        this.deleteByCopy(q);
    }
    
    // Helper functions for question 4

    // This function traverse the binary tree and stores its nodes pointers in vector nodes[]
    public void storeBSTNodes(Song root, Vector<Song> songs){
        if (root == null)
            return;
        
        // store nodes in Inorder (sorted order of BST)
        storeBSTNodes(root.left, songs);
        songs.add(root);
        storeBSTNodes(root.right, songs);
    }
    
    // Construct binary tree using array of nodes
    public Song BuildTree(Vector<Song> songs, int start, int end){
        if (start > end)
            return null;
        
        // get the middle element and make it root
        int mid = (start + end)/2;
        Song root = songs.get(mid);
        
        // using inorder traversal, construct left and right subtrees
        root.left = BuildTree(songs, start, mid - 1);
        root.right = BuildTree(songs, mid + 1, end);
        
        return root;
    }
    
    // function to balance a BST
    public Song Balance(Song root){
        // store nodes of given BST in sorted order
        Vector<Song> songs = new Vector<Song>();
        storeBSTNodes(root, songs);
        
        // Constructs AVL from these nodes
        int n = songs.size();
        return BuildTree(songs, 0, n - 1);
    }
    
    public void question4(Song root){
        Balance(root);
        BFT(root);
    }
}
