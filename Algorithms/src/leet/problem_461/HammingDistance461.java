/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet.problem_461;

/**
 *
 * @author akrishnaniyer
 */
public class HammingDistance461 {

	public static void main(String[] args) {
		new HammingDistance461().hammingDistance(1, 14);
	}

	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}
}
