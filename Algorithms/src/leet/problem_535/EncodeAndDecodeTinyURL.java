package leet.problem_535;

import java.util.HashMap;

public class EncodeAndDecodeTinyURL {

	HashMap<String, String> index = new HashMap<String, String>();
	HashMap<String, String> revIndex = new HashMap<String, String>();
	String base_url = "http://tinyurl.com/";

	public static void main(String[] args) {
		EncodeAndDecodeTinyURL obj = new EncodeAndDecodeTinyURL();
		System.out.println(obj.encode("http://www.google.com"));
	}

	public String encode(String longUrl) {
		String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		boolean runLoop = true;
		StringBuilder key = new StringBuilder();

		while (true) {
			StringBuilder tmpKey = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int index = (int) (Math.random() * charSet.length());
				tmpKey.append(charSet.charAt(index));				
			}
			if(!index.containsKey(tmpKey.toString())) {
				key = tmpKey;
				break;			
			}
		}
		index.put(key.toString(), longUrl);
		revIndex.put(longUrl, key.toString());
		return key.toString();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return index.get(shortUrl);
	}

}
