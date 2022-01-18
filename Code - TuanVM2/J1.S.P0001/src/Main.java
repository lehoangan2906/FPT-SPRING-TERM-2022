/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the size of array: ");
        int n = Validation.checkInputInt();
        Manager mer = new Manager(n);

        System.out.print("Unsorted array : ");
        displayArray(mer.getDataArray());

        mer.bubbleSort();
        System.out.println("");
        System.out.print("Sorted Array : ");
        displayArray(mer.getDataArray());
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(+array[i] + ", ");
            } else {
                System.out.print(array[i]);
                System.out.println("");
            }
        }
    }

}
