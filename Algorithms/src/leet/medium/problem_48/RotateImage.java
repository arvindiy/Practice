package leet.medium.problem_48;
//https://leetcode.com/problems/rotate-image/description/

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        print(matrix);
        new RotateImage().rotate(matrix);
        System.out.println();
        print(matrix);

    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        /*
         * Swap the rows
         */
        while (start <= end) {
            int[] tmp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmp;
            end--;
            start++;
        }

        // Move the elements
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
