package leet.problem_386;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/lexicographical-numbers/description/

public class LexicographicalNumbers {

	public static void main(String[] args) {
		LexicographicalNumbers obj = new LexicographicalNumbers();
		/*char[] c = {'a','2'};
		System.out.println(obj.convert(c));*/
		System.out.println(obj.lexicalOrder(13));

	}
	
	public List<Integer> lexicalOrder(int n) {
        Integer[] res = new Integer[n];
        int cur = 1;
        for(int i = 0; i < n; i++) {
            res[i] = cur;
            if(cur * 10 <= n) {
                cur *= 10;
            } else {
                if(cur >= n) cur /= 10;
                cur++;
                while(cur%10 == 0) {
                    cur /= 10;
                }
            }
        }
        return Arrays.asList(res);
    }

	/*public List<Integer> lexicalOrder(int n) {
		int c = 0;
		int t = n;
		while (t > 0) {
			c++;
			t = t / 10;
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		char[] num = new char[c];

		helper(num, 0, n, result);

		return result;
	}

	public void helper(char[] num, int i, int max, ArrayList<Integer> result) {
		if (i == num.length) {
			int val = convert(num);
			if (val <= max)
				result.add(val);
			return;
		}

		if (i == 0) {
			for (char c = '1'; c <= '9'; c++) {
				num[i] = c;
				helper(num, i + 1, max, result);
			}
		} else {
			num[i] = 'a';
			helper(num, num.length, max, result);

			for (char c = '0'; c <= '9'; c++) {
				num[i] = c;
				helper(num, i + 1, max, result);
			}
		}

	}

	private int convert(char[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9')
				result = result * 10 + arr[i] - '0';
			else
				break;
		}
		return result;
	}*/

	/**
	 * The following solution would store the integers in a string array Use the
	 * Arrays.sort API, to sort the array Then iterate over the array, and add it to
	 * the return List, in lexicographical order
	 */
	/*
	 * public List<Integer> lexicalOrder(int n) { String[] strArray = new String[n +
	 * 1]; for (int i = 1; i <= n; i++) { strArray[i] = i + ""; }
	 * Arrays.sort(strArray, 1, n); List<Integer> result = new ArrayList<Integer>();
	 * for (int i = 1; i < strArray.length; i++) {
	 * result.add(Integer.parseInt(strArray[i])); } return result; }
	 */

}
