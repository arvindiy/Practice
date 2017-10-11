package search;

/**
 *
 * @author akrishnaniyer
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {-3, -2, 0, 1, 2, 4, 67, 89, 90, 123, 123465, 324235};
        int num = 4;
        System.out.println(array[binarySearch(array, num)]);

    }

    private static int binarySearch(int[] array, int num) {
        int low = 0;
        int high = array.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num < array[mid]) {
                high = mid - 1;
            } else if (num > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
