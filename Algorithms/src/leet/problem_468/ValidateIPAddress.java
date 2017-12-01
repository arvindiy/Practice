package leet.problem_468;

import java.util.StringTokenizer;

public class ValidateIPAddress {

	public static void main(String[] args) {
		// String ip = "255.234.2.2";
		String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		System.out.println(new ValidateIPAddress().validIPAddress(ip));
	}

	public String validIPAddress(String ip) {
		String ipv4 = "IPv4";
		String ipv6 = "IPv6";
		String neither = "neither";
		if (ip == null || ip.length() == 0)
			return neither;

		if (ip.contains(".")) {
			if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.')
				return neither;
			StringTokenizer st = new StringTokenizer(ip, ".");
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				try {
					if (Integer.parseInt(str) > 255) {
						return neither;
					}
				} catch (NumberFormatException nfe) {
					return neither;
				}
			}
			return ipv4;
		} else if (ip.contains(":")) {
			if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':')
				return neither;
			StringTokenizer st = new StringTokenizer(ip, ":");
			System.out.println(st.countTokens());
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (str.length() == 0)
					return neither;
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					if ((c >= 65 && c <= 90) || (c >= 48 && c <= 57) || (c >= 97 && c <= 122))
						continue;
					else
						return neither;
				}
			}
			return ipv6;
		}

		return neither;
	}

}
