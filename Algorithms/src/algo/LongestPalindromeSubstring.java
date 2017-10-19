package algo;

/*
  The following algorithm finds the longest palindrome substring in a given string
    This is a O(N2) algo
 */
public class LongestPalindromeSubstring {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// String s = "abacdfgdcaba";
		String s = "wbaabw";

		System.out.println(findLongestPalindromeSubstring(s));
	}

	private static String findLongestPalindromeSubstring(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int n = s.length();
		boolean t[][] = new boolean[n][n];
		char[] c = s.toCharArray();
		int maxLen = 1;
		int longestBegin = 0;

		// Palindromes of length 1
		for (int i = 0; i < n; i++) {
			t[i][i] = true;
		}

		// Palindrome of length 2
		for (int i = 0; i < n - 1; i++) {
			if (c[i] == c[i + 1]) {
				t[i][i + 1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (c[i] == c[j] && t[i + 1][j - 1]) {
					t[i][j] = true;
					maxLen = len;
					longestBegin = i;
				}
			}
		}
		return s.substring(longestBegin, longestBegin + maxLen);
	}

}
