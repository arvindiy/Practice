package search;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 10, 12, 14, 16, 18, 19, 20 };
		int key = 10;
		System.out.println(binarySearch(arr, key));
	}

	//This is a simple binary search implementation
	
	private static int binarySearch(int[] arr, int key) {
		int l = 0;
		int h = arr.length - 1;
		while (l < h) {
			int m = (h - l) / 2;
			if (key < arr[m]) {
				h = m - 1;
			} else if (key > arr[m]) {
				l = m + 1;
			}else {
				return m;
			}
		}
		return -1;
	}

}
