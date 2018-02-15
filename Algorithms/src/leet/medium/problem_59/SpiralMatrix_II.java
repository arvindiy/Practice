package leet.medium.problem_59;

import java.util.Arrays;

//https://leetcode.com/problems/spiral-matrix-ii/description/

public class SpiralMatrix_II {

    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrix_II().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int val = 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int rowBegin = 0;
        int rowEnd = n - 1;

        while (val <= n * n) {
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = val++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = val++;
            }
            colEnd--;

            if (rowBegin <= rowEnd)
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = val++;
                }
            rowEnd--;

            if (colBegin <= colEnd)
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = val++;
                }
            colBegin++;

        }
        return matrix;
    }

}
