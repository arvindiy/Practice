package leet.easy.problem_367;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(new ValidPerfectSquare().isPerfectSquare(14));

	}

	public boolean isPerfectSquare(int num) {
		int i = 0;
		while (0 < num) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
}
