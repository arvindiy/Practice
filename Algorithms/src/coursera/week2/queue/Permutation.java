package coursera.week2.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

	public static void main(String[] args) {
		int subsetSize = Integer.parseInt(args[0]);
		String[] inputStrings = StdIn.readStrings();

		performSubset(subsetSize, inputStrings);
	}

	private static void performSubset(int subsetSize, String[] strings) {

		// Knuth shuffle
		for (int i = 1; i < strings.length; i++) {
			int randIndex = StdRandom.uniform(i + 1);

			String temp = strings[i];
			strings[i] = strings[randIndex];
			strings[randIndex] = temp;
		}

		// Output
		for (int j = 0; j < subsetSize; j++) {
			StdOut.println(strings[j]);
		}
	}
}
