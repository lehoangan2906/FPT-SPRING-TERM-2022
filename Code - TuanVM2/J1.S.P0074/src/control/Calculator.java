/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author VINH
 */
public class Calculator {

    public static int[][] inputMatrix(int n) {

        System.out.print("Enter Row Matrix " + n + ":");
        int row = Validation.checkInputInt();
        System.out.print("Enter Colum Matrix " + n + ":");
        int col = Validation.checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix " + n + "[" + i + "]" + "[" + j + "]:");
                matrix[i][j] = Validation.checkInputInt();
            }
        }
        return matrix;
    }

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;

        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        if (col1 == col2 && row1 == row2) {

            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < row1; j++) {
                    matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        } else {
            return null;
        }
        return matrixResult;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        if (col1 == col2 && row1 == row2) {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];

                }
            }
        } else {
            return null;
        }
        return matrixResult;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            return null;
        }
        // so cot cua ma tran 1 phai bang so dong cua ma tran 2
        // sinh ra 1 mang 2 chieu với so dong cua ma tran 1 va so cot cua ma tran 2
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
