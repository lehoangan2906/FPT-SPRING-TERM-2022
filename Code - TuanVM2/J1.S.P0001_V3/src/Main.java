
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class Main {

    public static void main(String[] args) {
        //nhap size
        int n = Validation.getInt("Enter number of arrray:",
                "Number of arrray is a positive integer. Please enter again!", 1, Integer.MAX_VALUE);

        int a[] = new int[n];
        //random array
        randomArray(a);
        //display
        display(a);
        System.out.println("unsorted");
        //sort
        sort(a);
        //display
        display(a);

    }

    private static void mockData(int[] a) {
        int temp[] = new int[]{5, 1, 12, -5, 16};
        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
        }
    }

    private static void randomArray(int[] a) {
//        Random rand = new Random();
//        for (int i = 0; i < a.length; i++) {
//            a[i] = rand.nextInt(a.length);
//        }
        mockData(a);

    }

    private static void display(int[] a) {
        System.out.print(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                display(a);
                if (a[j] > a[j + 1]) {
                    System.out.println(a[j] + ">" + a[j + 1] + ", swap");
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                } else {
                    System.out.println(a[j] + "<" + a[j + 1] + ", ok");
                }
            }
        }
    }

}
