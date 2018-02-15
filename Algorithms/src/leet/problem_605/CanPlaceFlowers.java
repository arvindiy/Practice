package leet.problem_605;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        // int[] flowerbed = { 1, 0, 0, 0, 1 };
        // int[] flowerbed = { 0, 0, 1, 0, 1 };
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > flowerbed.length)
            return false;

        int curr = -1, prev = 0, next = 0;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            curr = flowerbed[i];
            if (i == (flowerbed.length - 1) && curr == 0 && prev == 0) {
                count++;
                if (count >= n)
                    return true;
                break;
            }
            if (prev == 0 && curr == 0 && flowerbed[i + 1] == 0) {
                count++;
                i++;
            }
            if (count >= n)
                return true;
            prev = curr;
        }
        return false;
    }

}
