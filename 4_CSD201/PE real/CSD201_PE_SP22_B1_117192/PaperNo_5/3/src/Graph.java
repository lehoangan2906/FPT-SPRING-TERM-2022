/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) {  //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void depth1(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        ArrayList<Character> l = new ArrayList<>();
        depth1(visited, k, f, l);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth1(visited, i, f, l);
            }
        }

    }

    void depth1(boolean[] visited, int k, RandomAccessFile f, ArrayList<Character> l) throws Exception {
        this.fvisit1(k, f, l);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth1(visited, i, f, l);
            }
        }
    }

    void fvisit1(int i, RandomAccessFile f, ArrayList<Character> l) throws Exception {
        l.add(v[i]);
        if (l.size() >= 3 && l.size() <= 6) {
            f.writeBytes("  " + v[i]);
        }

    }

    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        this.depth1(1, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=================================================================
    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
        this.dijkstra(1, 5, f);
        this.dijkstra(0, 6, f);
        this.dijkstra2(0, 6, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void dijkstra(int startVertex, int endVertex, RandomAccessFile f) throws IOException {
        boolean[] checked = new boolean[n]; //danh dau dinh da duoc xac dinh hay chua
        int[] d = new int[n]; //khoang cach tu dinh startV den dinh i
        int[] previous = new int[n]; //luu dinh truoc dinh i
        int min_d;
        for (int i = 0; i < n; i++) {
            checked[i] = false;
        }

        for (int i = 0; i < n; i++) {
            d[i] = 99;
        }

        d[startVertex] = 0;

        for (int i = 0; i < n; i++) {
            previous[i] = -1;
        }

        int u = startVertex;
        while (u != -1) {
            checked[u] = true;
            for (int i = 0; i < n; i++) {
                if (!checked[i] && (d[i] > d[u] + a[u][i])) {
                    d[i] = d[u] + a[u][i];
                    previous[i] = u;
                }
            }
            min_d = 999;
            u = -1;
            for (int i = 0; i < n; i++) {
                if (!checked[i] && (d[i] < min_d)) {
                    min_d = d[i];
                    u = i;
                }
            }
            if (u == endVertex) {
                u = -1;
            }
        }

        displayPath(startVertex, endVertex, d[endVertex], previous, d, f);
//        for (int i = startVertex; i < endVertex; i++) {
//            System.out.print(" " + d[i]);
//        }
//        for (int i = 0; i < previous.length; i++) {
//            System.out.println(previous[i]);
//            
//        }
    }

    void displayPath(int startVertex, int endVertex, int d, int[] p, int[] dis,
            RandomAccessFile f) throws IOException {
        if (d == 999) {
            System.out.println("No path from " + v[startVertex] + " to " + v[endVertex] + ". ");
            return;
        }
//        System.out.println("The shortest dustance from " + v[startVertex]
//                + " to " + v[endVertex] + " is " + d);
        Stack s = new Stack();
        int u = endVertex;
        int i = u;
        while (u != -1) {
            s.push(u);
            u = p[u];
        }
        u = (int) s.pop();
//        ArrayList<Integer> distance = new ArrayList<>();
//        distance.add(u);
        f.writeBytes(Character.toString(v[u]));
        while (!s.isEmpty()) {
            u = (int) s.pop();
//            distance.add(u);
            f.writeBytes(" " + v[u]);
        }
        f.writeBytes(" " + dis[i]);
        f.writeBytes("\n");
//        for (Integer i : distance) {
//            f.writeBytes(dis[i] + " ");
//        }
//        f.writeBytes("\n");
    }

    void dijkstra2(int startVertex, int endVertex, RandomAccessFile f) throws IOException {
        boolean[] checked = new boolean[n]; //danh dau dinh da duoc xac dinh hay chua
        int[] d = new int[n]; //khoang cach tu dinh startV den dinh i
        int[] previous = new int[n]; //luu dinh truoc dinh i
        int min_d;
        for (int i = 0; i < n; i++) {
            checked[i] = false;
        }

        for (int i = 0; i < n; i++) {
            d[i] = 99;
        }

        d[startVertex] = 0;

        for (int i = 0; i < n; i++) {
            previous[i] = -1;
        }

        int u = startVertex;
        int h = 1;
        while (u != -1) {
            checked[u] = true;
            for (int i = 0; i < n; i++) {
                if (!checked[i] && (d[i] > d[u] + a[u][i])) {
                    d[i] = d[u] + a[u][i];
                    previous[i] = u;
                }
            }
            if (h <= 3) {
                f.writeBytes("(" + v[u] + "," + d[u] + ") ");
            }
            h++;
            min_d = 999;
            u = -1;
            for (int i = 0; i < n; i++) {
                if (!checked[i] && (d[i] < min_d)) {
                    min_d = d[i];
                    u = i;
                }
            }
            if (u == endVertex) {
                u = -1;
            }
        }

//        for (int i = startVertex; i < endVertex; i++) {
//            System.out.print(" " + d[i]);
//        }
//        for (int i = 0; i < previous.length; i++) {
//            System.out.println(previous[i]);
//            
//        }
    }

}
