package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class test {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countBits(5)));

        /*
         * System.out.println(5 << 1); String input = "{{}{{}()()(}{}{}}}";
         * System.out.println(isBalanced(input)); input = "((()()(())))";
         * System.out.println(isBalanced(input)); input = "[()()[]]}";
         * System.out.println(isBalanced(input));
         *
         * List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
         *
         * Collections.sort(names, new Comparator<String>() {
         *
         * @Override public int compare(String a, String b) { return b.compareTo(a); }
         * });
         */
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int p = 1;
        int pow = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow) {
                result[i] = 1;
                pow = pow * 2;
                p = 1;
            } else {
                result[i] = result[p] + 1;
                p++;
            }
        }
        return result;
    }

    private static boolean isBalanced(String input) {

        if (input == null || input.length() < 2) {
            // If length is less than two, it will be either 0 or 1, in which case,
            // the input string cannot be balanced
            return false;
        }

        ArrayList<Character> openList = new ArrayList<Character>();
        openList.add(Character.valueOf('{'));
        openList.add(Character.valueOf('['));
        openList.add(Character.valueOf('('));

        ArrayList<Character> closeList = new ArrayList<Character>();
        closeList.add(Character.valueOf('}'));
        closeList.add(Character.valueOf(']'));
        closeList.add(Character.valueOf(')'));

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (openList.contains(Character.valueOf(c))) {
                stack.push(Character.valueOf(c));
            } else if (closeList.contains(Character.valueOf(c))) {
                if (stack.size() == 0)
                    return false;
                char open = stack.pop();
                char close = (char) (open == '(' ? open + 1 : open + 2);
                if (close != c)
                    return false;
            } else {
                // Its neither a right nor a left. Returning false;
                return false;
            }
        }
        return stack.size() == 0;

    }

}
