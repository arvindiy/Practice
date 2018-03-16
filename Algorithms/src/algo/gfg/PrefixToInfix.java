package algo.gfg;
//https://www.geeksforgeeks.org/prefix-infix-conversion/

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {		
		System.out.println(prefixToInfix("*+AB-CD"));
		System.out.println(prefixToInfix("*-A/BC-/AKL"));		
	}

	private static boolean isOperator(char c) {
		switch (c) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}

	private static String prefixToInfix(String s) {		
		Stack<String> stack = new Stack<String>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (isOperator(c)) {
				StringBuilder exp = new StringBuilder();
				String oper1 = stack.pop();
				String oper2 = stack.pop();				
				stack.push(exp.append("(").append(oper1).append(c).append(oper2).append(")").toString());
			} else {
				stack.push(c + "");
			}
		}
		return stack.pop();
	}

}