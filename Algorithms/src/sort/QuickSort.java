package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int nums[] = {4, 2, 56, -23, 42};
        doQuickSort(nums);
        System.out.println("Sorted Array..." + Arrays.toString(nums));
    }

    /**
     * 1. Pick an element, call it the pivot element 2. Ensure that all elements
     * before it are smaller (considering its sorting in ascending order), and all
     * elements after it are larger that the pivot 3. Repeat for the left half
     * (smaller), and the right half (larger) recursively
     *
     * @param nums
     */

    private static void doQuickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private static void doQuickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            // partitionIndex is the position of the element, which is in the
            // right place.
            int partitionIndex = partition(nums, lo, hi);
            // Sort the left half.
            doQuickSort(nums, lo, partitionIndex - 1);
            // sort the right half.
            doQuickSort(nums, partitionIndex + 1, hi);
        }
    }

    /**
     * Pick the last
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(int[] nums, int lo, int hi) {
        int pivotElement = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivotElement) {
                i++;
                if (i != j)
                    swap(nums, j, i);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    private static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
