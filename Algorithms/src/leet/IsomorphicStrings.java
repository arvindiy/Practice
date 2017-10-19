package leet;

import java.util.HashMap;

//https://leetcode.com/problems/isomorphic-strings/description/

public class IsomorphicStrings {

	public static void main(String[] args) {
		String s1 = "foo";
		String s2 = "abc";
		System.out.println(s1 + " and " + s2 + " " + isIsomorphic(s1, s2));

	}

	public static boolean isIsomorphic(String a, String b) {

		if (a != null && b != null) {
			if (a.length() == b.length()) {
				HashMap<Character, Character> map = new HashMap<Character, Character>();
				for (int i = 0; i < a.length(); i++) {
					char c1 = a.charAt(i);
					char c2 = b.charAt(i);
					if (map.containsKey(c1)) {
						if (map.get(c1) != c2)
							return false;
					} else {
						if (map.containsValue(c2)) {
							return false;
						}
						map.put(c1, c2);
					}
				}
			} else
				return false;
		} else
			return false;

		return true;
	}

}
