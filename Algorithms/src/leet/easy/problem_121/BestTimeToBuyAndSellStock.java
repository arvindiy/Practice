package leet.easy.problem_121;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		System.out.println(obj.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int bought = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < bought) {
				bought = prices[i];
			} else {
				if (max < (prices[i] - bought))
					max = prices[i] - bought;
			}
		}
		return max;
	}

}
