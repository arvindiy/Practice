package algo;

import java.util.Random;

public class Weighted_Random_Numbers {

	public static void main(String[] args) {
		/*
		 * Given two arrays. One with elements and another with the probability of each
		 * of these elements to occur.
		 * 
		 * Write a method which would pick one of these elements, based on the provided
		 * probabilities In the below example, the changes of picking watermelon should
		 * be 60%
		 */
		String[] fruits = { "Apple", "Orange", "Watermelon" };
		double[] prob = { 0.2, 0.2, 0.6 };
		randomlyChoose(fruits, prob);
	}

	private static void randomlyChoose(String[] fruits, double[] prob) {
		Random rand = new Random();
		double randProb = rand.nextDouble();
		System.out.println(randProb);
		double currProbLimit = 0.0;
		for (int i = 0; i < fruits.length; i++) {
			currProbLimit += prob[i];
			System.out.println(currProbLimit);
			if (randProb < currProbLimit) {
				System.out.println(fruits[i]);
				return;
			}

		}
	}
}
