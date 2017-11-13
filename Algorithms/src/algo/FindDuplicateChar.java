package algo;

public class FindDuplicateChar {
	public static void main(String args[]) {
		String str = "asdfhlksajdfhasdh,bcskuguwehbf";
		findDuplicateChar(str);
	}

	//This problem can also be solved using a HashMap/Set
	private static void findDuplicateChar(String str) {
		if(str == null || str.length() == 0) {
			return;
		}
		int [] allChars = new int[256];
		//This would populate an array
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(allChars[c] > 0)
				System.out.println("DUPLICATE " + c);
			allChars[c] += 1; 
		}
	}

}
