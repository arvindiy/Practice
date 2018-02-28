package algo;

public class Remove_Alternate_Duplicates {

	public static void main(String[] args) {
		String s = "you got beautiful eyes";
		System.out.println(removeAlternateDuplicates(s));

	}

	static String removeAlternateDuplicates(String s) {
		if (s == null || s.length() == 0)
			return "";
		s = s.toLowerCase();
		boolean[] alt = new boolean[256];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!alt[c]) {
				sb.append(c);
			}
			alt[c] = !alt[c];
		}
		return sb.toString();
	}

}
