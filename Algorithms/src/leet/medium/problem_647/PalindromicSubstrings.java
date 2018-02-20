package leet.medium.problem_647;

//https://leetcode.com/problems/palindromic-substrings/description/
public class PalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "nitih";
		System.out.println(new PalindromicSubstrings().countSubstrings(s));
	}

	int count = 0;

	public int countSubstrings(String s) {
		// Iterate over all the characters of the string
		for (int i = 0; i < s.length(); i++) {
			// For each character, check odd length palindromes
			checkPalindrome(s, i, i);
			// for each character, check even length palindromes
			checkPalindrome(s, i, i + 1);
		}
		return count;
	}

	private void checkPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			count++;
			i--;
			j++;
		}
	}
}
