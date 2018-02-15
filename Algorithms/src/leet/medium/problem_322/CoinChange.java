package leet.medium.problem_322;

//https://leetcode.com/problems/coin-change/description/


public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {2, 5, 3, 6};
        int sum = 4;
        int[] cache = new int[sum + 1];
        System.out.println(coinChange.coinCount(coins, sum, cache));

    }

    private int coinCount(int[] coins, int remainingSum, int[] cache) {
        //If the remaining sum to be calculated is 0
        //the problem has been solved. Return a 0
        if (remainingSum == 0)
            return 0;

        //If this is less than 0, then its not possible to solve this
        //return -1
        if (remainingSum < 0) {
            return -1;
        }
        //If we already have a solution for this problem,
        //instead of trying to solve it again, return it from the
        //cache
        if (cache[remainingSum] != 0)
            return cache[remainingSum];
        int count = Integer.MAX_VALUE;

        for (int coin : coins) {
            //Calculate the number of coins for a lesser sum.
            int tmpCount = coinCount(coins, remainingSum - coin, cache);

            if (tmpCount >= 0 && count > tmpCount)
                count = 1 + tmpCount;
        }
        //Store that calcualted sum, and return this value, which will be used
        //in calcualtions for higher values
        cache[remainingSum] = count == Integer.MAX_VALUE ? -1 : count;

        return cache[remainingSum];

    }

}
