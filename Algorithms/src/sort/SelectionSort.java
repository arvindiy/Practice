package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int nums[] = {4, 2, 56, 11, 45645, 0, -2, -23, 42};
        doSelectionSort(nums);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    private static void doSelectionSort(int nums[]) {
        /*
         * 1. Take the first position
         * 2. Put the minimum element in that position
         * 3. Keep doing the same or all positions until you reach the end of the array
         */
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    private static void swap(int[] nums, int i, int min) {
        int tmp = nums[i];
        nums[i] = nums[min];
        nums[min] = tmp;
    }
}
