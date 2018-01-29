package leet.problem_273;

public class IntegerToEnglishWords {

	final String[] THOUSANDS = { "", "THOUSAND", "MILLION", "BILLION" };
	final String[] TENS = { "", "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY" };
	final String[] LESSTHAN20 = { "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
			"ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN",
			"TWENTY" };

	public static void main(String[] args) {
		// int num = 673;
		//int num = 2234345;
		int num = 2147483633;
		System.out.println(new IntegerToEnglishWords().numberToWords(num));

	}

	public String numberToWords(int num) {
		int thousandsIndex = 0;
		String result = "";

		while (num > 0) {
			// sb.append(LESSTHAN20[])
			result = convertThreeDigits(num % 1000) + THOUSANDS[thousandsIndex++] + " " + result;
			num = num / 1000;
		}

		return result;
	}

	public String convertThreeDigits(int num) {
		String result = "";
		if (num < 10) {
			result += LESSTHAN20[num] + " ";

		} else if (num < 20) {
			result += LESSTHAN20[num] + " ";

		} else if (num < 100) {
			result += TENS[num / 10] + " " + convertThreeDigits(num % 10);
		} else {
			result += LESSTHAN20[num / 100] + " HUNDRED " + convertThreeDigits(num % 100);
		}
		return result;
	}

}
