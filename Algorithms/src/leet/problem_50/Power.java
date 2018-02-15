package leet.problem_50;

//https://leetcode.com/problems/powx-n/description/
public class Power {

    public static void main(String[] args) {
        //This should return 5 * 5 * 5
        System.out.println(new Power().myPow(5, 3));
    }

    public double myPow(double x, int n) {
        //If n == 0, then any 'x' would result in a '1'
        if (n == 0) return 1;

        //If x is 0 or 1, then the result would be x
        if (x == 0 || x == 1) return x;

        //If n < 0, then we inverse x, and negate n.
        if (n < 0) {
            x = 1 / x;
            n = n * (-1);
        }

        //If n == MIN value,
        //and x > 0, any x would result in a 1.
        //If x < 0, any x would result in a 0.
        if (n == Integer.MIN_VALUE) {
            if (x > 0) {
                return 1;
            } else
                return 0;
        }

        //If n is even, recursively call the same method with doubled x, and halved n.
        //If n is not even, recursively call the same method with tripled x, and halved n.
        if (n % 2 == 1) {
            return x * myPow(x * x, n / 2);
        } else
            return myPow(x * x, n / 2);
    }
}
