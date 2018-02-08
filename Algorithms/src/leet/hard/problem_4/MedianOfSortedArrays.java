package leet.hard.problem_4;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

import java.util.Arrays;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		System.out.println(new MedianOfSortedArrays().findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergedArray = mergeArrays(nums1, nums2);
		//System.out.println(Arrays.toString(mergedArray));
		return median(mergedArray);
	}

	public double median(int[] arr) {
		int n = arr.length;
		double median = 0;
		if (n % 2 == 0) {
			median = (double) (arr[n / 2] + arr[((n / 2) - 1)]) / 2;
		} else
			median = (arr[(n / 2)]);
		return median;
	}

	public int[] mergeArrays(int[] nums1, int[] nums2) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int n = nums1.length;
		int m = nums2.length;
		int arr3[] = new int[m + n];
		while (p1 < n || p2 < m) {
			int num1 = p1 < n ? nums1[p1] : Integer.MAX_VALUE;
			int num2 = p2 < m ? nums2[p2] : Integer.MAX_VALUE;
			if (num1 > num2) {
				arr3[p3] = num2;
				p2++;
			} else {
				arr3[p3] = num1;
				p1++;
			}
			p3++;
		}
		return arr3;
	}
}
