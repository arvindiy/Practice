package leet.problem_151;

//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class ReverseWordsInAString {

    public static void main(String[] args) {
        //String s = "the sky is blue";
        String s = "   a   b ";
        // System.out.println(new ReverseWordsInAString().reverseString(s));
        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

    public String reverseString(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (s == null || s.length() == 0)
            return "";

        char[] array = s.toCharArray();
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(array);
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0)
            return "";
        s = reverseString(s.trim());
        // System.out.println(s);
        StringBuilder sb = new StringBuilder();
        boolean firstWord = true;
        int wordStartingIndex = 0;
        boolean prevCharASpace = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && !prevCharASpace) {
                String wordToReverse = s.substring(wordStartingIndex, i);
                String reversedWord = reverseString(wordToReverse);
                sb.append(firstWord ? "" : " ").append(reversedWord);
                firstWord = false;
                wordStartingIndex = i + 1;
                prevCharASpace = true;
            } else
                prevCharASpace = false;
        }
        String wordToReverse = s.substring(wordStartingIndex);
        String reversedWord = reverseString(wordToReverse);
        sb.append(firstWord ? "" : " ").append(reversedWord);
        return sb.toString();
    }

}
