package leet.problem_204;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countPrimes(int n) {
		int count = 0;

		for (int i = 0; i <= n; i++) {
			if (isPrime(i))
				count++;
		}
		return count;
	}

	public boolean isPrime(int n) {
		if(n <=1)
			return false;
		else if(n<=3)
			return false;
		else if (n % 2 == 0 || n % 3 == 0)
			return false;
		int i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
			i += 6;
		}
		return true;
	}

}
