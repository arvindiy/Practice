package algo;

//february 13 2018

//https://www.careercup.com/question?id=20308668

import java.util.List;
import java.util.ArrayList;

class Replace_Questions_with_1_and_0 {

	// Given a string pattern of 0s, 1s, and ?s (wildcards),
	// generate all 0-1 strings that match this pattern.
	// e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]
	// 1?0?1?001 -> [100010001, 100011001, 100110001, 100111001, 110010001,
	// 110011001, 110110001, 110111001]
	private List<String> generate(String input, int index, List<String> resultList) {

		/*
		 * 0?0?1 -> [010 , 000] add the string to the result when number of "?" is 0
		 * return resultList;
		 * 
		 * 1. Iterate over the input String { 2. Get charAt(i), check if it is a ? 3.
		 * zeroString = substring(0,i-1) + "0" + substring(i+1,n) "000" 3.1 recursively
		 * call the same method (zeroString)
		 * 
		 * 4. oneString = substring(0,i-1) + "1" + substrin (i+1,n) 5.
		 * result.add(oneString); 6. result.add(zerString); } 7. return result;
		 * 
		 */

		// Base case
		/*
		 * 0?0?1 010?1 01011 - Add this element to the resultList -> return
		 * 
		 * 01011 - Add this 01001 - Add this
		 * 
		 * 000?1 00011 - Add this element to the resultList -> return 000
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		if (input != null && (!input.contains("?"))) {
			resultList.add(input);
			return resultList;
		}

		String s = input.replaceFirst("\\?", "1");
		generate(s, 0, resultList);
		s = input.replaceFirst("\\?", "0");
		generate(s, 0, resultList);

		return resultList;

		//

	}

	/** Provided **/
	private void test(String input) {
		System.out.print("input = " + input + " --> ");

		List<String> result = new ArrayList<String>();

		//result = output(input, 0, result);
		result = outputAllString(input);

		for (String s : result) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	public static List<String> outputAllString(String pattern) {
		
		ArrayList<String> potential_pattern = new ArrayList<String>();
		potential_pattern.add("");
		for (int i = 0; i < pattern.length(); i++) {
			/*
			 * for each potential pattern, either add the non-? character
			 * or for each ?, add 2 instances of all the available matches
			 * 11?? - 
			 * 1,1
			 * [1,1,0], [1,1,1]
			 * [1,1,0,1],[1,1,0,0],[1,1,1,1],[1,1,10]
			 */
			for (int j = potential_pattern.size() - 1; j >= 0; j--) {
				String s = potential_pattern.remove(j);
				if (pattern.charAt(i) != '?') {
					s += pattern.charAt(i);
					potential_pattern.add(j, s);
				} else {
					String temp = s + "0";
					potential_pattern.add(j, temp);
					temp = s + "1";
					potential_pattern.add(j, temp);
				}
			}
		}
		return potential_pattern;
	}

	/** Provided **/
	public static void main(String[] args) {

		Replace_Questions_with_1_and_0 pattern = new Replace_Questions_with_1_and_0();

		pattern.test("1?00?101");
		pattern.test("1?0?1?001");
		pattern.test("?");
		pattern.test("?00000?");
		pattern.test("????");
		pattern.test("abdefhi?jkl");
	}
}
