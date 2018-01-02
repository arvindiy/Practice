package leet.problem_50;

//https://leetcode.com/problems/powx-n/description/
public class Power {

	public static void main(String[] args) {
		System.out.println(new Power().myPow(5, 3));
	}

	public double myPow(double x, int n) {
		if(n == 0) return 1;
		if (x == 0 || x == 1) return x;
		if(n < 0)		{
			x = 1/x;
			n = n * ( -1);
		}
		if(n == Integer.MIN_VALUE) {
			if(x>0) {
				return 1;				
			}else
				return 0;
		}

		if(n%2 ==1)
		{
			return x*myPow(x*x, n/2);
		}else
			return myPow(x*x, n/2);
	}
}
