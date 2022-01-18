/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
import java.util.Random;

public class Manager {

    private int[] a;

    public Manager(int n) {
        a = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            int number = rd.nextInt(n);
            a[i] = number;
        }
    }

    public int[] getDataArray() {
        return a;
    }

    public void bubbleSort() {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
