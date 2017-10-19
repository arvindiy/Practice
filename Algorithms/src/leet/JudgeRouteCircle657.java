/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;

/**
 *
 * @author akrishnaniyer
 */
public class JudgeRouteCircle657 {
	public static void main(String[] args) {
		String moves = "UD";
		System.out.println(new JudgeRouteCircle657().judgeCircle(moves));
	}

	public boolean judgeCircle(String moves) {
		boolean retval = false;
		int x = 0;
		int y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
			switch (c) {
			case 'U':
				y -= 1;
				break;
			case 'L':
				x -= 1;
				break;
			case 'D':
				y += 1;
				break;
			case 'R':
				x += 1;
				break;
			default:
				return false;
			}

		}
		return x == 0 && y == 0;
	}
}
