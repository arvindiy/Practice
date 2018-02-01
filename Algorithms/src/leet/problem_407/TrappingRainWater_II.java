package leet.problem_407;
//https://leetcode.com/problems/trapping-rain-water-ii/description/

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater_II {

	public static void main(String[] args) {
		/*
		 * int[][] input = { { 12, 13, 0, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 }, {
		 * 12, 13, 12, 12 }, { 13, 13, 13, 13 } };
		 */
		//int[][] input = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		int[][] input = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(new TrappingRainWater_II().trapRainWater(input));

	}

	//Create a class, which holds the x,y
	//and the height of the respective cell
	class Cell {
		int x;
		int y;
		int height;
		Cell(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
			return 0;

		int rows = heightMap.length;
		int cols = heightMap[0].length;
		
		//This PQ will hold all the cells, based on their heights
		PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
			public int compare(Cell a, Cell b) {
				return a.height - b.height;
			}
		});

		boolean[][] visited = new boolean[rows][cols];

		//Add the TOP and BOTTOM		
		for (int i = 0; i < rows; i++) {
			visited[i][0] = true;
			visited[i][cols - 1] = true;
			pq.offer(new Cell(i, 0, heightMap[i][0]));
			pq.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
		}
		
		//Add the LEFT and RIGHT
		for (int i = 0; i < cols; i++) {
			visited[0][i] = true;
			visited[rows - 1][i] = true;
			pq.offer(new Cell(0, i, heightMap[0][i]));
			pq.offer(new Cell(rows - 1, i, heightMap[rows - 1][i]));
		}

		int sum = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (!pq.isEmpty()) {
			Cell cell = pq.poll();
			for (int i = 0; i < 4; i++) {
				int x = cell.x + dx[i];
				int y = cell.y + dy[i];
				if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
					visited[x][y] = true;
					pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
					sum += Math.max(0, cell.height - heightMap[x][y]);
				}
			}
		}
		return sum;
	}

}
