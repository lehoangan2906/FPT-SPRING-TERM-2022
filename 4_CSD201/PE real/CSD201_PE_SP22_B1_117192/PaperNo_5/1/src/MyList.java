/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    // check if xTower.charAt(0) == 'A' then do
    // nothing, otherwise add new node with tower = xTower,
    // sound = xSound, type = xType to the end of
    // the list.
    void addLast(String xTower, int xSound, int xType) {
        //  check if xTower.charAt(0) == 'A' then do nothing
        if (xTower.charAt(0) == 'A') {
            return;
        } else {
            // add new node with tower = xTower, sound = xSound, type = xType to the end of the list.
            Bell newBell = new Bell(xTower, xSound, xType);
            Node p = new Node(newBell);
            if (isEmpty()) {
                head = tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
        }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // helper function for f2()
    public void insertPositionK(Bell x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bell x, y;
        x = new Bell("X", 1, 2);
        y = new Bell("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        insertPositionK(y, 2);
        insertPositionK(x, 4);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // helper functions for f3()
    //get node max
    public Node getMaxNode() {
        if (isEmpty()) {
            return null;
        }
        Node max = head;
        Node p = head;
        while (p != null) {
            if (p.info.type > max.info.type) {
                max = p;
            }
            p = p.next;
        }
        //return max; 
        Node q = p.next;
        return q;
    }

    // remove the node from the list
    public void remove(Node p) {
        if (p == null) {
            return;
        }
        //find q where q.next = p
        Node f = head, q = null;
        while (f != null && f != p) {
            q = f;
            f = f.next;
        }
        //remove head
        if (q == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            q.next = p.next;
            if (p == tail) {
                tail = q;
            }
        }
        p.next = null;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node canxoa = getMaxNode();
        remove(canxoa);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // helper functions for f4()
    
//==================================================================

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
       // this.sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
