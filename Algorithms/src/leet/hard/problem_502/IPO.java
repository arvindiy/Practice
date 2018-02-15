package leet.hard.problem_502;

//https://leetcode.com/problems/ipo/description/

import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int sum = 0;
        /*
         * Because we want to invest the minimum capital we make the capital's PQ as a
         * minHeap
         */
        PriorityQueue<Project> pqCapital = new PriorityQueue<Project>((a, b) -> (a.capital - b.capital));
        /*
         * With every project, we want to make more profit, so we make the profit PQ as
         * a maxHeap
         */
        PriorityQueue<Project> pqProfit = new PriorityQueue<Project>((a, b) -> (a.profit - b.profit));
        // We start with adding all the capital/profit tuples
        // into the capital PQ
        for (int i = 0; i < Capital.length; i++) {
            pqCapital.offer(new Project(Profits[i], Capital[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!pqCapital.isEmpty() && pqCapital.peek().capital <= W) {
                pqProfit.add(pqCapital.poll());
            }
            /*
             * If this priority queue is empty, that means we cannot find any project which
             * can be executed within the available budget
             */
            if (pqProfit.isEmpty())
                break;
            /*
             * The top of the pqProfit priority queue will have the project with the maximum
             * profit, which can be executed with the available capital Since we have to
             * return "pure" profit, we keep adding the profit from each project into the
             * incoming capital (W)
             */
            W += pqProfit.poll().profit;
        }
        return W;
    }

    class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
