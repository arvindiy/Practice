package leet.problem_3;

import java.util.HashSet;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		char[] chars = s.toCharArray();
		int max = 0;
		int start = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, i - start + 1);
			} else {
				for (int j = start; j < i; j++) {
					set.remove(chars[j]);
					if (chars[j] == c) {
						start = j + 1;
						break;
					}
				}
				set.add(c);
			}
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(new LongestSubstring().lengthOfLongestSubstring("aabcaaabcd"));
	}

}
