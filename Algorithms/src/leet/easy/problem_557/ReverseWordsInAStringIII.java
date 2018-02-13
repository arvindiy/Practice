package leet.easy.problem_557;

public class ReverseWordsInAStringIII {

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
	}

	/**
	 * Everytime a ' ' is encountered in the array
	 * we reverse the previous word. This algorithm can be made
	 * more efficient by using a character array, instead of a StringBuffer
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		int startingIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				String sub = s.substring(startingIndex, i );
				System.out.println(sub);
				sb.append(reverseWord(sub)).append(" ");
				startingIndex = i + 1;
			}
		}

		return sb.append(reverseWord(s.substring(startingIndex, s.length()))).toString();
	}

	public String reverseWord(String word) {

		int n = word.length();
		char[] rev = new char[n];
		int j = 0;
		for (int i = n - 1; i >= 0; i--) {
			rev[j++] = word.charAt(i);
		}

		return new String(rev);
	}

}
