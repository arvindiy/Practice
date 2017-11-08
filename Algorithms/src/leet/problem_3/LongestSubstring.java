package leet.problem_3;

import java.util.HashSet;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
	
		int max = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, i - start + 1);
			} else {
				for (int j = start; j < i; j++) {
					char c1 = s.charAt(j);
					set.remove(c1);
					if (c == c1) {
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
