package leet.problem_273;

public class IntegerToEnglishWords {

    final String[] THOUSANDS = {"", "Thousand ", "Million ", "Billion "};
    final String[] TENS = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety "};
    final String[] LESSTHAN20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen ", "Twenty "};

    public static void main(String[] args) {
        // int num = 673;
        int num = 1000000;
        // int num = 2147483633;
        System.out.println(new IntegerToEnglishWords().numberToWords(num));
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int thousandsIndex = 0;
        // StringBuilder result = new StringBuilder();
        String result = "";
        while (num > 0) {
            String firstThree = convertThreeDigits(num % 1000);
            // result.append(result).append(THOUSANDS[thousandsIndex]).append(firstThree);
            if (num % 1000 != 0)
                result = firstThree + THOUSANDS[thousandsIndex] + result;
            thousandsIndex++;
            num = num / 1000;
        }
        return result.trim();
    }

    public String convertThreeDigits(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 10) {
            result.append(LESSTHAN20[num]);
        } else if (num < 20) {
            result.append(LESSTHAN20[num]);
        } else if (num < 100) {
            result.append(TENS[num / 10]).append(convertThreeDigits(num % 10));
        } else {
            result.append(LESSTHAN20[num / 100]).append("Hundred ").append(convertThreeDigits(num % 100));
        }
        return result.toString();
    }

}
