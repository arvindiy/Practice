package leet.hard.problem_32;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/description/

public class LongestValidParantheses {

    public static void main(String[] args) {
        String s = "())";
        System.out.println(new LongestValidParantheses().longestValidParentheses(s));

    }

    /**
     * Insert the indexes of only those elements that do not match
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int len = 0;
        Stack<Integer> indexes = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If its an open parentheses, insert into the stack
            if (c == '(') {
                indexes.push(i);
            } else {
                /*
                 * If the current char is a ')'
                 *
                 * if the stack is empty, it means one of the following 1. The first character
                 * in the string is a ) 2. The rest of the matching parentheses have been
                 * removed
                 *
                 * Insert the index of ')' into the stack
                 *
                 * If the stack is not empty, we can have the following two cases 1. The
                 * previous index in the stack was an opening parentheses. Remove this opening
                 * parentheses 2. The previous index in the stack was a closing parentheses.
                 * Insert this closing parentheses into the stack
                 */
                if (!indexes.empty()) {
                    int prevIndex = indexes.peek();
                    if (s.charAt(prevIndex) == '(') {
                        indexes.pop();
                    } else
                        indexes.push(i);
                } else {
                    indexes.push(i);
                }
            }
        }

        //If the stack is empty, it means all the characters matched,
        //hence the full length was the return value
        if (indexes.empty())
            return s.length();
        else {
            /*
             * Iterate over the stack and calculate the maximum difference
             */
            int a = s.length(), b = 0;
            while (!indexes.empty()) {
                b = indexes.pop();
                len = Math.max(len, a - b - 1);
                a = b;
            }
            //The last element of the stack also needs to be accounted for.
            //Use case -> Only one parentheses '('
            len = Math.max(len, a);
        }

        return len;
    }

}
