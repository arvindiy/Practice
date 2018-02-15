package algo;

/**
 * @author Print all anagrams of a string
 */
public class AllAnagramsOfAString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "arvind";
        printAnagrams(s, "");
    }

    private static void printAnagrams(String s, String prefix) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                printAnagrams(s.substring(0, i) + s.substring(i + 1, n), c + prefix);
            }

        }
    }

}
