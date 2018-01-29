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
		//StringBuilder result = new StringBuilder();
		String result = "";

		while (num > 0) {
			String firstThree = convertThreeDigits(num % 1000);
			//result.append(result).append(THOUSANDS[thousandsIndex]).append(firstThree);
			result =  firstThree + THOUSANDS[thousandsIndex] + " " + result;
			thousandsIndex++;
			num = num / 1000;
		}

		return result;
	}

	public String convertThreeDigits(int num) {
		StringBuilder result = new StringBuilder();
		if (num < 10) {
			result.append(LESSTHAN20[num]).append(" ");
		} else if (num < 20) {
			result.append(LESSTHAN20[num]).append(" ");
		} else if (num < 100) {
			result.append(TENS[num / 10]).append(" ").append(convertThreeDigits(num % 10));
		} else {
			result.append(LESSTHAN20[num / 100]).append(" HUNDRED ").append(convertThreeDigits(num % 100));
		}
		return result.toString();
	}

}
