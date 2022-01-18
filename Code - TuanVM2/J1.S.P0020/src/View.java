/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class View {

    public static void main(String[] args) {
        Controller conn = new Controller();
        Validate vd = new Validate();
        int size = vd.inputInteger("Enter number of array: ", 1, Integer.MAX_VALUE);
        int[] array = conn.inputArray(size);
        System.out.println("Unsorted array: ");
        conn.displayArray(array);
        conn.selectionSort(array);
        System.out.println("Sorted array: ");
        conn.displayArray(array);
        System.out.println();
    }
}
