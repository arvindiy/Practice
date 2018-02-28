package leet.hard.problem_159;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters

public class Longest_Substring_With_2_Distinct_Chars {

	public static void main(String[] args) {
		String[] s = { "aabaacs", "", "aa", "aaba", "abcd" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(lengthOfLongestSubstringTwoDistinct(s[i]));
		}
	}

	static int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] charCount = new int[256];
		int numberOfDistinctChars = 0;
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			//If this character has not occured, increase the 
			//number of distinct characters
			if (charCount[s.charAt(j)] == 0)
				numberOfDistinctChars++;
			//Increment the count of this character
			charCount[s.charAt(j)]++;
			/*
			 * If the number of distinct characters are more than 2,
			 * keep moving the window until the distinct characters
			 * are back to 2.
			 */
			while (numberOfDistinctChars > 2) {
				//with every character, reduce the count
				charCount[s.charAt(i)]--;
				//if this character has exhausted all its occurences, 
				//it means we can reduce the number of distinct characters
				//by 1
				if (charCount[s.charAt(i)] == 0)
					numberOfDistinctChars--;
				//move the window
				i++;
			}
			//get the maximum length
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
}
