/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Calculator;
import static control.Calculator.displayMatrix;
import control.Validation;

/**
 *
 * @author VINH
 */
public class Main {

    public static void main(String[] args) {
        Calculator m = new Calculator();
        //Validation c = new Validation();
        while (true) {
            System.out.println("======Calcuator program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = Validation.checkIntLimit(1, 4);

            int[][] matrix1;// = new int[0][0];
            int[][] matrix2;// = new int[0][0];
            int[][] matrixResult;// = new int[0][0];
            switch (choice) {
                case 1:
                    matrix1 = m.inputMatrix(1);
                    matrix2 = m.inputMatrix(2);
                    System.out.println("-----------Result-----------");
                    matrixResult = m.additionMatrix(matrix1, matrix2);
                    if (matrixResult != null) {
                        displayMatrix(matrix1);
                        System.out.println("+");
                        displayMatrix(matrix2);
                        System.out.println("=");
                        displayMatrix(matrixResult);
                    } else {
                        System.out.println("Not same size!");
                    }

                    break;
                case 2:
                    matrix1 = m.inputMatrix(1);
                    matrix2 = m.inputMatrix(2);
                    System.out.println("-----------Result-----------");
                    matrixResult = m.additionMatrix(matrix1, matrix2);
                    if (matrixResult != null) {
                        displayMatrix(matrix1);
                        System.out.println("-");
                        displayMatrix(matrix2);
                        System.out.println("=");
                        displayMatrix(matrixResult);
                    } else {
                        System.out.println("Not same size!");
                    }

                    break;
                case 3:
                    matrix1 = m.inputMatrix(1);
                    matrix2 = m.inputMatrix(2);
                    System.out.println("-----------Result-----------");
                    matrixResult = m.multiplicationMatrix(matrix1, matrix2);
                    if (matrixResult != null) {
                        displayMatrix(matrix1);
                        System.out.println("*");
                        displayMatrix(matrix2);
                        System.out.println("=");
                        displayMatrix(matrixResult);
                    } else {
                        System.out.println("Can not multi");
                    }

                    break;
                case 4:
                    System.exit(0);
                    return;
            }
        }
    }

}
