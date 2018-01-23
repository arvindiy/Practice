package algo;

public class TwoRepeatingNumbers {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		// int[] nums = {1, 1, 2, 3, 2};
		/*
		 * int[] nums = {4,2,4,5,6,3,1}; System.out.println(findRepeat(nums));
		 */
	}

	public static int strStr(String haystack, String needle) {
		if(needle == null || needle.length() == 0)
			return -1;
		int needleLength = needle.length();
		
		for (int i = 0; i < haystack.length(); i++) {
			char c = haystack.charAt(i);
			if (c == needle.charAt(0) && haystack.substring(i, i + needleLength).equals(needle))
				return i;
		}
		return -1;
	}

	public static int findRepeat(int[] theArray) {

		int floor = 1;
		int ceiling = theArray.length - 1;

		while (floor < ceiling) {

			// divide our range 1..n into an upper range and lower range
			// (such that they don't overlap)
			// lower range is floor..midpoint
			// upper range is midpoint+1..ceiling
			int midpoint = floor + ((ceiling - floor) / 2);
			int lowerRangeFloor = floor;
			int lowerRangeCeiling = midpoint;
			int upperRangeFloor = midpoint + 1;
			int upperRangeCeiling = ceiling;

			// count number of items in lower range
			int itemsInLowerRange = 0;
			for (int item : theArray) {

				// is it in the lower range?
				if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
					itemsInLowerRange += 1;
				}
			}

			int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

			if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

				// there must be a duplicate in the lower range
				// so use the same approach iteratively on that range
				floor = lowerRangeFloor;
				ceiling = lowerRangeCeiling;
			} else {

				// there must be a duplicate in the upper range
				// so use the same approach iteratively on that range
				floor = upperRangeFloor;
				ceiling = upperRangeCeiling;
			}
		}

		// floor and ceiling have converged
		// we found a number that repeats!
		return floor;
	}

}
