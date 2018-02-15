package leet.problem_363;

public class Max_Sum_Of_Rectangle_No_Greater_Than_K {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        Max_Sum_Of_Rectangle_No_Greater_Than_K obj = new Max_Sum_Of_Rectangle_No_Greater_Than_K();
        int k = 2;
        System.out.println(obj.maxSumSubmatrix(matrix, k));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = 0;
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        return result;
    }
}