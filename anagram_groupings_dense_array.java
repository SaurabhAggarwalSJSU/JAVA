import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

//custom value enum:

public class anagram_groupings_dense_array {

	public static void main(String args[]) {

		List<String> list_anagrams = new ArrayList<String>();
		list_anagrams.add("abc");
		list_anagrams.add("bat");
		list_anagrams.add("cat");
		list_anagrams.add("ate");
		list_anagrams.add("eat");
		list_anagrams.add("cab");

		grouping(list_anagrams);

	} // void main ends here

	public static void grouping(List<String> list_anagrams) {

		// create hashmap
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		// loop through input list of strings:
		for (int i = 0; i < list_anagrams.size(); i++) {

			// each index will be a string like i=0 "abc"
			update_map(list_anagrams.get(i), map);
		}
	}

	public static void update_map(String inputString, HashMap<String, List<String>> map) {

		// step1: create dense array
		Integer benchmark_ascii = Integer.valueOf('a');
		Integer dense_array[] = new Integer[50];

		// loop on character by character on this anagram string:
		for (int i = 0; i < inputString.length(); i++) {

			// create index for dense array:
			int index = Integer.valueOf(inputString.charAt(i)) - benchmark_ascii;

			// if dense array has value at that index increement that again:
			if (dense_array[index] > 0) {
				dense_array[index] += 1;
			} else {
				dense_array[index] = 1;
			}
			// ends loop:
		}

		// 1 string ---> 1 dense array ----> 1 symbol

		// now create symbol of string from this dense array:
		String symbol = null;
		for (int i = 0; i < dense_array.length - 1; i++) {
			if (dense_array[i] > 0) {
				String charSymbol = String.valueOf(i) + ":" + String.valueOf(dense_array[i]) + '|';
				symbol += charSymbol;
			}
		}

		// update the map to group items:
		if (map.containsKey(symbol)) {
			map.get(symbol).add(inputString);
		} else {
			List<String> newList = new ArrayList<String>();
			newList.add(inputString);
			map.put(symbol, newList);
		}

		// Print the map values:
		map.forEach((k, v) -> System.out.println(v));

	}

//main Class ends here
}
