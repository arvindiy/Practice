package geeks4geeks;
//This algorithm is to find out if an 8-Puzzle is solvable or not
//http://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/

public class EightPuzzle {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 0, 5}, {8, 6, 7}};
        System.out.println(isSolvable(grid));

    }

    private static boolean isSolvable(int nums[][]) {
        boolean retVal = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println(nums[i][j]);
            }
        }
        return retVal;
    }

}
