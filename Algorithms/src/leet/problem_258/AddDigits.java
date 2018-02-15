package leet.problem_258;

//https://leetcode.com/problems/add-digits/description/

public class AddDigits {

    public static void main(String[] args) {
        //This problem can also use the concept that if we divide the number by 9
        //the remainder will be the sum
        System.out.println(new AddDigits().addDigits(167));
    }

    public int addDigits(int num) {
        int sum = 0;
        if (num < 10)
            return num;
        while (true) {
            int rem = num % 10;
            sum += rem;
            if (num < 10)
                return addDigits(sum);
            num /= 10;
        }
    }

}
