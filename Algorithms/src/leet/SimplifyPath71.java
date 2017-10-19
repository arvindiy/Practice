package leet;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Given an absolute path for a file (Unix-style), simplify it. For example,
 * path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 *
 * @author akrishnaniyer
 */
public class SimplifyPath71 {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// String path = "/home/..";
		String path = "/a//./b/../../c/d/";
		String simplifiedPath = simplifyPath(path);
		System.out.println(simplifiedPath);
	}

	private static String simplifyPath(String path) {
		StringTokenizer dirTokens = new StringTokenizer(path, "/");
		StringBuffer result = new StringBuffer();
		ArrayList<String> list = new ArrayList<>();

		while (dirTokens.hasMoreTokens()) {
			String dir = dirTokens.nextToken();
			// System.out.println(dir);
			if (dir.equals("..")) {
				if (list.size() > 0) {
					list.remove(list.size() - 1);
				}
			} else if (dir.equals(".")) {

			} else {
				list.add(dir);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			String d = list.get(i);
			result.append("/").append(d);
		}
		return result.toString();
	}

}
