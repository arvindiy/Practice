package leet.medium.problem_678;

//https://leetcode.com/problems/valid-parenthesis-string/description/

public class ValidParenthesisString {
    public static void main(String args[]) {
        String s = "((**)";
        System.out.println(new ValidParenthesisString().checkValidString(s));
    }


    public boolean search(String s, int index, int count) {
        if (s.length() == index) {
            return count == 0;
        }
        if (count < 0)
            return false;
        if (s.charAt(index) == '(') {
            return search(s, index + 1, count + 1);
        } else if (s.charAt(index) == ')') {
            return search(s, index + 1, count - 1);
        } else {
            return (search(s, index + 1, count) || search(s, index + 1, count + 1) || search(s, index + 1, count - 1));
        }
    }

    public boolean checkValidString(String s) {
        return search(s, 0, 0);
    }

}
