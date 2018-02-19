package leet.medium.problem_207;

//https://leetcode.com/problems/course-schedule/description/

import java.util.LinkedList;

public class CourseSchedule {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 3;
		// int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		// int[][] prerequisites = { { 1, 0 } };
		int[][] prerequisites = { { 1, 0 }, { 2, 1 } };
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		LinkedList<Integer> q = new LinkedList<Integer>();
		/*
		 * Iterate over the prerequisites, and set the indegree of nodes
		 */
		for (int i = 0; i < prerequisites.length; i++)
			indegree[prerequisites[i][1]]++;

		/*
		 * If the indegree of nodes is 0, add it to the queue
		 */
		for (int i = 0; i < indegree.length; i++)
			if (indegree[i] == 0)
				q.offer(i);

		while (!q.isEmpty()) {
			int i = q.poll();
			// Dequeue the poll
			for (int j = 0; j < prerequisites.length; j++) {
				// If the starting node of the prerequisites
				// is the same as the 0 indegree node,
				// decrement the indegree of the ending node
				if (prerequisites[j][0] == i) {
					indegree[prerequisites[j][1]]--;
					// if the indegree of the ending node is 0,
					// add it to the queue
					if (indegree[prerequisites[j][1]] == 0)
						q.offer(prerequisites[j][1]);
				}
			}
		}

		// If any of the indegree of the nodes is not 0
		// it has a cycle
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] != 0)
				return false;
		}
		return true;
	}
}
