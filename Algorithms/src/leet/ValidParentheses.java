package leet;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(new ValidParentheses().isValid(s));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (s == null || s.length() < 2) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char c1 = (stack.size() > 0 ? stack.peek() : '0');
			switch (c) {
			case '}':
				if (c1 != '{') {
					return false;
				}
				stack.pop();
				break;
			case '{':
				stack.push(c);
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				if (c1 != '(') {
					return false;
				}
				stack.pop();
				break;
			case ']':
				if (c1 != '[') {
					return false;
				}
				stack.pop();
				break;
			case '[':
				stack.push(c);
				break;
			default:
				return false;
			}
			
		}
		return stack.size() == 0;
	}

}
