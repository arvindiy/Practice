package algo;

//https://www.careercup.com/question?id=5718772282294272

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Michelle_Word_Game {

	public static void main(String[] args) {
		System.out.println(findSubstrings("awaglkkoi", 4));
		System.out.println(subString("awaglknagawunagwkwagi", 4));
	}

	private static ArrayList<String> findSubstrings(String s, int n) {
		// Use a set to avoid duplicates
		Set<String> set = new HashSet<String>();
		/*
		 * Iterate over the string, and get a substring each time, of n characters Check
		 * the number of duplicate characters that substring has. if its not 1, dont add
		 * it to the result.
		 */
		for (int i = 0; i < s.length() - n + 1; i++) {
			String s1 = s.substring(i, i + n);
			int[] rep = new int[26];
			int numberOfRepeatingChars = 0;
			for (int j = 0; j < n; j++) {
				char c = s1.charAt(j);
				if (rep[c - 'a'] == 0) {
					rep[c - 'a']++;
				} else if (rep[c - 'a'] == 1) {
					numberOfRepeatingChars++;
				}
			}
			if (numberOfRepeatingChars == 1) {
				set.add(s1);
			}
		}
		return new ArrayList(set);
	}

	public static ArrayList<String> subString(String inputStr, int num) {
		int i = 0;
		int[] arr = new int[26];
		Set<String> result = new HashSet<String>();
		int numOfRepeatedChars = 0;
		for (int j = 0; j < num; j++) {
			if (++arr[inputStr.charAt(j) - 'a'] > 1) {
				numOfRepeatedChars++;
			}
		}
		if (numOfRepeatedChars == 0) {
			result.add(inputStr.substring(0, num));
		}
		for (int k = num; k < inputStr.length(); k++) {
			if (++arr[inputStr.charAt(k) - 'a'] > 1) {
				numOfRepeatedChars++;
			}
			if (--arr[inputStr.charAt(i++) - 'a'] == 1) {
				numOfRepeatedChars--;
			}
			if (numOfRepeatedChars == 0) {
				result.add(inputStr.substring(i, k + 1));
			}
		}
		return new ArrayList<String>(result);
	}

}
