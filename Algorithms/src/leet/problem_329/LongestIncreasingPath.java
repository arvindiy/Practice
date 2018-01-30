package leet.problem_329;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingPath {

	public static void main(String args[]) {
		int[][] nums = { { 3, 4, 5, 7, 8 }, { 3, 2, 6, 1, 3 }, { 2, 2, 8, 2, 1 } };
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(nums));
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		// Declaring an array so that, with repeated calls to the same method
		// the value in the array persists
		int[] max = new int[1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j, max, 1);
			}
		}

		return max[0];
	}

	/**
	 * 
	 * @param matrix
	 * @param i
	 * @param j
	 * @param max
	 * @param len
	 */
	public void dfs(int[][] matrix, int i, int j, int[] max, int len) {

		max[0] = Math.max(max[0], len);

		int m = matrix.length;
		int n = matrix[0].length;

		/*
		 * From one element, the four directions we can move are 1. Top 2. Left 3.
		 * Bottom 4. Right The 'x' dimension would
		 * 
		 * 1. Reduce by 1, while moving to the top 
		 * 2. Would remain the same, while moving to the left 
		 * 3. Increase by 1, while moving to the bottom 
		 * 4. Would remain the same, while moving to the right
		 * 
		 * Hence the following values in dx as {-1,-0,1,0} Same logic applies for the
		 * 'y' dimension too
		 */
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		// All the 4 possibilities (TOP,LEFT,BOTTOM,RIGHT)
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			/*
			 * 1. Make sure X and Y remain inside the boundaries
			 * 2. Check if the next value is greater than the current value in (i,j)
			 */
			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
				dfs(matrix, x, y, max, len + 1);
			}
		}
	}
}
