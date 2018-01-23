package leet.problem_591;

public class TagValidator {

	public static void main(String[] args) {
		String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
		System.out.println(new TagValidator().isValid(code));

	}

	public boolean isValid(String code) {
		if (code == null || code.length() == 0)
			return false;
		char[] arr = code.toCharArray();
		
		return true;
	}

}
