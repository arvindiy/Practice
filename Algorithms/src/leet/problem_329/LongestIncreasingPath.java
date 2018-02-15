package leet.problem_329;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingPath {

    public static void main(String args[]) {
        /*
         * int[][] nums = { { 3, 4, 5, 7, 8 }, { 3, 2, 6, 1, 3 }, { 2, 2, 8, 2, 1 } };
         */
        int[][] nums = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29}, {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49}, {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89}, {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(nums));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // Declaring an array so that, with repeated calls to the same method
        // the value in the array persists
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(len, max);
            }
        }

        return max;
    }

    /**
     * @param matrix
     * @param i
     * @param j
     * @param max
     * @param len
     */
    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];

        int m = matrix.length;
        int n = matrix[0].length;

        /*
         * From one element, the four directions we can move are 1. Top 2. Left 3.
         * Bottom 4. Right The 'x' dimension would
         *
         * 1. Reduce by 1, while moving to the top 2. Would remain the same, while
         * moving to the left 3. Increase by 1, while moving to the bottom 4. Would
         * remain the same, while moving to the right
         *
         * Hence the following values in dx as {-1,-0,1,0} Same logic applies for the
         * 'y' dimension too
         */
        // {TOP, LEFT, BOTTOM, RIGHT}
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int max = 1;

        // All the 4 possibilities (TOP,LEFT,BOTTOM,RIGHT)
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            /*
             * 1. Make sure X and Y remain inside the boundaries 2. Check if the next value
             * is greater than the current value in (i,j)
             */
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, cache);
                max = Math.max(len, max);

            }
        }
        cache[i][j] = max;
        return max;
    }
}
