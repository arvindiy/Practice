package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		String input = "{{}{{}()()(}{}{}}}";
		System.out.println(isBalanced(input));
		input ="((()()(())))";
		System.out.println(isBalanced(input));
		input ="[()()[]]}";
		System.out.println(isBalanced(input));
		
		
		List<String> names =Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		
	}

	private static boolean isBalanced(String input) {
		if(input == null || input.length() < 2) {
			//If length is less than two, it will be either 0 or 1, in which case,
			//the input string cannot be balanced
			return false;
		}
		
		ArrayList <Character> openList = new ArrayList<Character>();
		openList.add(Character.valueOf('{'));
		openList.add(Character.valueOf('['));
		openList.add(Character.valueOf('('));
		
		ArrayList <Character> closeList = new ArrayList<Character>();
		closeList.add(Character.valueOf('}'));
		closeList.add(Character.valueOf(']'));
		closeList.add(Character.valueOf(')'));
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if(openList.contains(Character.valueOf(c))) {
				stack.push(Character.valueOf(c));
			}else if(closeList.contains(Character.valueOf(c))) {
				if(stack.size() == 0)
					return false;
				char open = stack.pop();
				char close = (char) (open=='('?open+1:open+2);
				if(close != c)
					return false;				
			}else {
				//Its neither a right nor a left. Returning false;
				return false;
			}
		}
		return stack.size() == 0;
		
	}

}
