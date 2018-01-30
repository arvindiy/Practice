package leet.problem_204;

public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(100));

	}

	public int countPrimes(int n) {
		int count = 0;

		for (int i = 0; i <= n; i++) {
			if (isPrime(i))
				count++;
		}
		return count;
	}

	/**
	 * All prime numbers are of the form 6k+1 
	 * 1. If n <= 1, we would consider that number as a non-prime 
	 * 2. If the number is 2 or 3, we would consider them as prime 
	 * 3. 4 is not prime, since it is divisible by 2 
	 * 4. We iterate from 5 to n^2 (input number), incrementing it by 6
	 * 5. If the number is divisible by 2 or 3, its not prime
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i*i <= n; i += 6) {
			if(n%i ==0 || n%(i+2) == 0)
				return false;
		}
		return true;
	}

}
