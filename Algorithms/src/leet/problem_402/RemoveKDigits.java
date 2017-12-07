package leet.problem_402;

//https://leetcode.com/problems/remove-k-digits/description/

public class RemoveKDigits {

	public static void main(String[] args) {
		String num = "1430";
		System.out.println(new RemoveKDigits().removeKdigits(num, 3));
	}

	public static String removeKdigits(String num, int k) {
		//Use this string builder as a stack
		StringBuilder sb = new StringBuilder();
		
		//Iterate over the array
		for (char c : num.toCharArray()) {
			/*
			 * if the character on top of the stack is greater than the latest char,
			 * remove the character.
			 */
			while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
				sb.setLength(sb.length() - 1);
				k--;
			}
			
			//Make sure you don't make a number like 02
			//Only append when it is not leading zero
			if (sb.length() != 0 || c != '0')
				sb.append(c); 
		}
		/*
		 * if k is greater than the length of the constructed string, that means
		 * 
		 */
		if (k >= sb.length()) {
			System.out.println("Chec" + sb.toString());
			return "0";
		}
		sb.setLength(sb.length() - k); // use all remaining k
		return sb.toString();
	}
}
