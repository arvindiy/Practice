package algo;


/**
 *
 * @author akrishnaniyer
 */
import java.util.Arrays;

public class ManachersAlgorithm {

    public static String findLongestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] s2 = preprocess(s);
        int[] p = new int[s2.length];
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i < s2.length; i++) {
            if (i > r) {
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int i2 = c * 2 - i;
                if (p[i2] < (r - i - 1)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below. 
                } else {
                    p[i] = r - i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }
            if ((i + p[i]) > r) {
                c = i;
                r = i + p[i];
            }
        }
        int len = 0;
        c = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);

        return removeFillers(ss);
    }

    public static void main(String args[]) {
        String s = "abbacdfgdcaba";
        //String s = "arvind";
        String f = findLongestPalindrome(s);
        
        System.out.println(f);
    }

    private static char[] preprocess(String s) {
        char[] c = new char[2 * s.length() + 1];
        char filler = '$';
        c[0] = filler;
        int j = 1;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            c[2 * i + j] = x;
            c[2 * i] = filler;
        }
        c[2 * s.length()] = filler;
        return c;
    }

    private static String removeFillers(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if(c != '$'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
