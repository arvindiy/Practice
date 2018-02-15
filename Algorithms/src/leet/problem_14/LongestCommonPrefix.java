package leet.problem_14;

//https://leetcode.com/problems/longest-common-prefix/description/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        //String[] strs = { "abc", "abcd", "ab" };
        String[] strs = {};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] != null && strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        int currentIndex = 0;
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean allSameChars = true;
            char c = strs[0].charAt(currentIndex);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(currentIndex)) {
                    allSameChars = false;
                    break;
                }
            }
            if (!allSameChars) {
                break;
            } else {
                returnValue.append(c);
                currentIndex++;
            }

        }
        return returnValue.toString();
    }

}
