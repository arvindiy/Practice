package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Input - Two lists. One with target strings, another with available strings.
 *  Find the startindec and the end inde of the Minimum continuous subsequence of the array containing all the elements of the target 
 * list.
 * Output -
 */
public class Labelling_Its_Products {

	public static void main(String[] args) {
		ArrayList<String> availableList = new ArrayList<String>();
		ArrayList<String> targetList = new ArrayList<String>();
		availableList.add("made");
		availableList.add("weather");
		availableList.add("forecast");
		availableList.add("says");
		availableList.add("that");
		availableList.add("made");
		availableList.add("rain");
		availableList.add("in");
		availableList.add("spain");
		availableList.add("stays");

		targetList.add("made");
		targetList.add("in");
		targetList.add("spain");
		System.out.println(subSequenceTags(availableList, targetList));

	}

	private static ArrayList<Integer> subSequenceTags(ArrayList<String> availableList, ArrayList<String> targetList) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < targetList.size(); i++) {
			map.put(targetList.get(i), 1);
		}

		int start = 0;
		int minLength = Integer.MAX_VALUE;
		int elementsToFind = targetList.size();
		int startIndex = 0;
		int endIndex = 0;
		for (int tail = 0; tail < availableList.size(); tail++) {
			String key = availableList.get(tail);
			if (map.containsKey(key)) {
				int count = map.get(key);
				if (count == 1) {
					elementsToFind--;
				}
				map.put(key, --count);
			}

			while (elementsToFind == 0) {
				if (minLength > (tail - start)) {
					minLength = tail - start;
					startIndex = start;
					endIndex = tail;
				}
				if (tail == availableList.size() - 1)
					break;
				String key2 = availableList.get(start);
				start++;
				if (map.containsKey(key2)) {
					int count = map.get(key2);
					if (count == 0) {
						elementsToFind++;
					}
					map.put(key2, ++count);
				}
			}
		}
		result.add(startIndex);
		result.add(endIndex);

		return result;
	}

}
