package algo;

public class Compress {

    public static void main(String[] args) {
        String str = "aabbdeee";
        System.out.println(compress(str));
    }

    private static String compress(String str) {
        char last = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(last);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (last != c) {
                sb.append(c);
                last = c;
            }
        }
        return sb.toString();
    }

}
