package leet.problem_650;

//https://leetcode.com/problems/2-keys-keyboard/description/

public class TwoKeysKeyboard {

	public static void main(String[] args) {
		System.out.println(new TwoKeysKeyboard().minSteps(95));
	}

	/**
	 * n==1, return 0
	 * n==2, return 1 (1 Copy, 1 Paste)
	 * n==3, return 3 (1 Copy, 2 Paste)
	 * n==6, return 5 
	 * 		Copy 3 As two times (2)
	 * 		To get 3 As, return 3 (above)
	 * 		Soution is 3 + 2 = 5
	 * 
	 * n==95, 95 % 5 == 0. 
	 * 		Copy 5 As 19 times.
	 * 		To get 5 As, return 5
	 * 		So, answer == 19 + 5 = 24 		
	 * 
	 * @param n
	 * @return
	 */
	public int minSteps(int n) {
		int res = 0;
		if (n == 1)
			return 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				res += i;
				n = n / i;
			}
		}
		return res;
	}
}
