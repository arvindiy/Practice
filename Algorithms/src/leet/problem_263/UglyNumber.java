package leet.problem_263;

//https://leetcode.com/problems/ugly-number/description/

public class UglyNumber {

    public static void main(String[] args) {
        new UglyNumber().isUgly(2);
    }

    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        if (num == 1)
            return true;
        if (num % 2 == 0) {
            num = num / 2;
            return isUgly(num);
        }
        if (num % 3 == 0) {
            num = num / 3;
            return isUgly(num);
        }
        if (num % 5 == 0) {
            num = num / 3;
            return isUgly(num);
        }
        return false;
    }

}
