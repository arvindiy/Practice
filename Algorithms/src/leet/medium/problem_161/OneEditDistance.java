package leet.medium.problem_161;

public class OneEditDistance {

	public static void main(String[] args) {
		String s = "abcde";
		String t = "abcde";
		System.out.println(isOneEditDistance(s, t));
	}

	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length();
		int n = t.length();
		// Keep the longer string as the second parameter
		// switch the parameters if that is the case
		if (n < m)
			return isOneEditDistance(t, s);
		// if the difference between these two strings'
		// length is more than 1, return false.
		if (n - m > 1)
			return false;
		int i = 0;
		// This value should be 0 or 1.
		int shift = n - m;
		// Move the index on the shorter string until
		// we find a non-matching character
		while (i < m && s.charAt(i) == t.charAt(i)) {
			i++;
		}
		// If we have already gotten to the end of the string
		// return true if the difference is 1.
		// Else these two strings are the same
		if (i == m)
			return shift > 0;
		// if the difference is 0, we have to skip the two non-matching
		// characters.
		if (shift == 0)
			i++;
		// Move the index to the next non-matching character
		while (i < m && s.charAt(i) == t.charAt(i + shift)) {
			i++;
		}
		// If we are not at the end of the shorter string
		// these two strings are not at oneEditDistance.
		return i == m;
	}
}
