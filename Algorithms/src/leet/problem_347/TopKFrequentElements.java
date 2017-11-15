package leet.problem_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/description/

public class TopKFrequentElements {

	public static void main(String[] args) {
		 int[] nums = { 1, 1, 1, 2, 2, 3 };
		//int[] nums = { 1, 2 };
		int k = 2;
		System.out.println(new TopKFrequentElements().topKFrequent(nums, k));
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		int max = 0;
		Iterator iter = map.entrySet().iterator();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}

		ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max + 1];
		for (int i = 1; i <= max; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			int number = entry.getKey();
			arr[count].add(number);
		}

		List<Integer> result = new ArrayList<Integer>();
		
		for (int j = max; j >= 1; j--) {
			if (arr[j].size() > 0) {
				for (int a : arr[j]) {
					result.add(a);
				}
			}

			if (result.size() == k)
				break;
		}

		return result;
	}
}
