package leet.problem_151;

//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "TODOC asdfasd asdfasd wert d";
		// System.out.println(new ReverseWordsInAString().reverseString(s));
		System.out.println(new ReverseWordsInAString().reverseString(s, 0, s.length() - 1));
	}

	public String reverseString(String s, int left, int right) {
		if (s == null || s.length() == 0)
			return "";

		char[] array = s.toCharArray();
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
		return String.valueOf(array);
	}

	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";
		s = reverseString(s, 0, s.length() - 1);
		int wordStartingIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				String wordToReverse = s.substring(wordStartingIndex, i);
				String reversedWord = reverseString(wordToReverse, wordStartingIndex, i);
				
			}
		}
		return s;
	}

}
