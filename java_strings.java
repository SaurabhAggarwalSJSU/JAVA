import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

//more on:
//https://www.geeksforgeeks.org/tag/java-string-programs/

public class java_Strings {

	public static void main(String args[]) {

	} // void main ends here

	public static class inside_class {

	}

	public static void method_strings() {

		// byte array
		byte[] b_arr = { 71, 101, 101, 107, 115 };

		// byte array to string
		String s_byte = new String(b_arr); // Geeks

		// default characterset for decoding
		Charset cs = Charset.defaultCharset();
		String s_byte_char = new String(b_arr, cs); // Geeks
		// String s_ascii = new String(b_arr, "US-ASCII"); //Geeks

		// create a string from characters array
		char[] character_array = { 'a', 's' };
		String chr_to_stringArray = new String(character_array); // as

		//// eek for Geeks
		// String chr_to_stringArray_positions = new String(character_array, 1, 3); //as

		// chacater array from string
		char[] ch_from_str = chr_to_stringArray.toCharArray();

		StringBuilder s_builder = new StringBuilder("Geeks");
		String s_from_builder = new String(s_builder); // Geeks

		// Methods------------------>>
		"GeeksforGeeks".length(); // returns 13
		"GeeksforGeeks".charAt(3); // returns ‘k
		"GeeksforGeeks".substring(3); // returns “ksforGeeks”
		"GeeksforGeeks".substring(2, 5); // returns “eks”
		String s1 = "Geeks";
		String s2 = "forGeeks";
		String output = s1.concat(s2); // returns “GeeksforGeeks”

		String s = "Learn Share Learn";
		int output_0 = s.indexOf("Share"); // returns 6
		int output_00 = s.lastIndexOf('a'); // returns 14

		Boolean check_equal = "Geeks".equals("geeks"); // false
		Boolean check_equal_ignore = "geeks".equalsIgnoreCase("Geeks");

		/*
		 * int out = s1.compareTo(s2); // where s1 ans s2 are // strings to be compared
		 * 
		 * This returns difference s1-s2. If : out < 0 // s1 comes before s2 out = 0 //
		 * s1 and s2 are equal. out >0 // s1 comes after s2.
		 */

		/*
		 * String word3 = word1.toLowerCase(); // returns “hello" String word2 =
		 * word1.trim();
		 * 
		 * //replace wth all occurences String s1 = “feeksforfeeks“; String s2
		 * =“feeksforfeeks”.replace(‘f’ ,’g’); // returns “geeksgorgeeks”
		 * 
		 * 
		 */

	}

	public static void string_methods() {

		// Convert arrayList to string:
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		String converted = String.join(",", list);

		// using Linq
		String listString = list.stream().map(Object::toString).collect(Collectors.joining(", "));

		// using for each loop and string builder:
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
			sb.append("\t");
		}
		System.out.println(sb.toString());

		// list to array to string
		String list_toarray_to_string = Arrays.toString(list.toArray());

	}

	// Java 8 string Joiners
	public static void String_Joiners() {
		ArrayList<String> al = new ArrayList<>();

		al.add("Ram");
		al.add("Shyam");
		al.add("Alice");
		al.add("Bob");

		StringJoiner sj1 = new StringJoiner(",");

		// setEmptyValue() method
		sj1.setEmptyValue("sj1 is empty");
		System.out.println(sj1);

		// add() method
		sj1.add(al.get(0)).add(al.get(1));
		System.out.println(sj1);

		// length() method
		System.out.println("Length of sj1 : " + sj1.length());

		StringJoiner sj2 = new StringJoiner(":");
		sj2.add(al.get(2)).add(al.get(3));

		// merge() method
		sj1.merge(sj2);

		// toString() method
		System.out.println(sj1.toString());

		System.out.println("Length of new sj1 : " + sj1.length());

	}

	public static void string_methods_Comparison_Equality() {
		// 1. equals() method: It compares values of string for equality
		// 2. == operator: It compares references not values.
		/*
		 * 3. compareTo() method: str1 == str2 : return 0 str1 > str2 : return a
		 * positive value str1 < str2 : return a negative value
		 */

		String s1 = "Ram";
		String s2 = "Ram";
		String s3 = new String("Ram");
		String s4 = new String("Ram");
		String s5 = "Shyam";
		String nulls1 = null;
		String nulls2 = null;

		System.out.println(" Comparing strings with equals:");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s5));
		// System.out.println(nulls1.equals(nulls2)); // NullPointerException

		System.out.println(" Comparing strings with ==:");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println(nulls1 == nulls2);

		System.out.println(" Comparing strings with compareto:");
		System.out.println(s1.compareTo(s3));
		System.out.println(s1.compareTo(s5));
		// System.out.println(nulls1.compareTo(nulls2)); // NullPointerException

		/*
		 * Comparing strings with equals: true true false Comparing strings with ==:
		 * true false false true Comparing strings with compareto: 0 -1
		 */

	}

	public static void string_func() {

		int b = -1234;
		String str1 = Integer.toString(b);
		// String str3 = String.valueOf(c);

		// decimal format
		DecimalFormat df = new DecimalFormat("#,###");
		String Str5 = df.format(b);

		// String str7 = stringbuilder.toString();

		// ParseInt
		int decimalExample = Integer.parseInt("20");

		// SUBSTRINGS:::::

	}

	public static void swap_without_third_using_Strings() {
		// Declare two strings
		String a = "Hello";
		String b = "World";

		// Print String before swapping
		System.out.println("Strings before swap: a = " + a + " and b = " + b);
		// append 2nd string to 1st
		a = a + b;

		// store intial string a in string b
		b = a.substring(0, a.length() - b.length());

		// store initial string b in string a
		a = a.substring(b.length());

		// print String after swapping
		System.out.println("Strings after swap: a = " + a + " and b = " + b);
	}

	public static void method_builder_string() {
		// create a StringBuilder object
		// with a String pass as parameter
		StringBuilder str = new StringBuilder("AAAABBBCCCC");

		StringBuilder str_9 = new StringBuilder();

		str_9.append("GFG");

		// print string
		System.out.println("String = " + str.toString());

		// reverse the string
		StringBuilder reverseStr = str.reverse();

		// print string
		System.out.println("Reverse String = " + reverseStr.toString());

		// Append ', '(44) to the String
		str.appendCodePoint(44);

		// Print the modified String
		System.out.println("Modified StringBuilder = " + str);

		// get capacity
		int capacity = str.capacity();

		// print the result
		System.out.println("StringBuilder = " + str);
		System.out.println("Capacity of StringBuilder = " + capacity);

		/*
		 * String = AAAABBBCCCC Reverse String = CCCCBBBAAAA Modified StringBuilder =
		 * CCCCBBBAAAA, StringBuilder = CCCCBBBAAAA, Capacity of StringBuilder = 27
		 */

		// Methods For StringBuilder:
		// charAt
		// delete
		// deleteCharAt
		// getChars
		// indexOf
		// lastIndexOf
		// insert//This method inserts the string representation of the char argument
		// into this sequence.
		// append
		// replace
		// setCharAt

		// Substrings:
		/*
		 * CharSequence subSequence(int start, int end): This method returns a new
		 * character sequence that is a subsequence of this sequence. String
		 * substring(): This method returns a new String that contains a subsequence of
		 * characters currently contained in this character sequence.
		 */

		String test = "software";
		String seq = "soft";
		boolean bool = test.contains(seq);

		String str_ = "GeeksforGeeks is a computer science portal";

		System.out.println(str_.startsWith("Geek"));
		System.out.println(str_.startsWith("is", 14));

	}

	// Creating your own CompareTo() method:
	public static int Strings_Comparison_method_IndexOf(String str1, String str2) {
		// string comparison without any library method:

		int l1 = str1.length();
		int l2 = str2.length();

		for (int i = 0; i < l1 && i < l2; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch == str2_ch) {
				continue;
			} else {
				return str1_ch - str2_ch;
			}
		}

		// Edge case for strings like
		// String 1="Geeks" and String 2="Geeksforgeeks"
		if (l1 < l2) {
			return l1 - l2;
		} else if (l1 > l2) {
			return l1 - l2;
		}

		// If none of the above conditions is true,
		// it implies both the strings are equal
		else {
			return 0;
		}

		/*
		 * String string1 = new String("Geeksforgeeks"); String string2 = new
		 * String("Practice"); String string3 = new String("Geeks"); String string4 =
		 * new String("Geeks");
		 * 
		 * // Comparing for String 1 < String 2 System.out.println("Comparing " +
		 * string1 + " and " + string2 + " : " + stringCompare(string1, string2));
		 * 
		 * // Comparing for String 3 = String 4 System.out.println("Comparing " +
		 * string3 + " and " + string4 + " : " + stringCompare(string3, string4));
		 * 
		 * // Comparing for String 1 > String 4 System.out.println("Comparing " +
		 * string1 + " and " + string4 + " : " + stringCompare(string1, string4));
		 * 
		 * Comparing Geeksforgeeks and Practice : -9 Comparing Geeks and Geeks : 0
		 * Comparing Geeksforgeeks and Geeks : 8
		 * 
		 * 
		 */

	}

	// Reverse a string in Java:
	public static void Reverse_String_ways() {
		String input = "Geeks for Geeks";

		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(input);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		// print reversed String
		System.out.println(input1);

		// Method2
		// convert String to character array
		// by using toCharArray
		char[] try1 = input.toCharArray();

		for (int i = try1.length - 1; i >= 0; i--)
			System.out.print(try1[i]);

		// Another try:
		/*
		 * char[] abc = new char[50]; List<Character> arr_list = new
		 * ArrayList<Character>(); for(char ch : input.toCharArray()) {
		 * arr_list.add(ch); } Collections.reverse(arr_list); String listString = "";
		 * for (Character s : newlIst) { listString += s; }
		 */
	}

	public static void string_questions() {

		// 1. remove all zeros from string
		String str = "000001230005690";
		int i = 0;
		while (str.charAt(i) == '0')
			i++;

		// Convert str into StringBuffer as Strings
		// are immutable.
		StringBuffer sb = new StringBuffer(str);

		// The StringBuffer replace function removes
		// i characters from given index (0 here)
		sb.replace(0, i, "");
		String new_one = sb.toString();

		// Check if a string contains only alphabets in Java using Lambda expression
		Boolean isIt = ((!str.equals("")) && (str != null) && (str.chars().allMatch(Character::isLetter)));

		// using regex
		Boolean isAlpha = ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));

	}

	// remove an element from list if it satisfies a condition using predicate
	public static void predicate_remove_elem_list() {

		// Create a list with null values
		List<String> l = new ArrayList<>(Arrays.asList("Geeks", null, "forGeeks", null, "A computer portal"));

		// Creating a Predicate condition checking for null
		Predicate<String> isNull = i -> (i == null);
		// Removing using Predicate
		l = removeElements(l, isNull);
	}

	// Generic function to remove elements using Predicate
	public static <T> List<T> removeElements(List<T> l, Predicate<T> p) {
		// Removing nulls using Java Stream
		// using Predicate condition in lambda expression
		l = l.stream().filter(p).collect(Collectors.toList());

		// Return the list

		// type-2
		// Create collection using Predicate
		Collection<T> collection = new ArrayList<>();
		for (T t : l) {
			if (p.test(t)) {
				collection.add(t);
			}
		}
		// IMPORTANT: removing from list all the things which are in list2
		l.removeAll(collection);

		return l;
	}

	// Counting number of lines, words, characters and paragraphs
	public static void count_words_paragraphs_in_file() {
		// File file = new File("C:\\Users\\Mayank\\Desktop\\1.txt");
		// FileInputStream fileStream = new FileInputStream(file);
		// InputStreamReader input = new InputStreamReader(fileStream);
		// BufferedReader reader = new BufferedReader(input);

		String line = null;

		// Initializing counters
		int countWord = 0;
		int sentenceCount = 0;
		int characterCount = 0;
		int paragraphCount = 1;
		int whitespaceCount = 0;

		// Reading line by line from the
		// file until a null is returned

		// while((line = reader.readLine()) != null)
		while (true) {
			if (line.equals("")) {
				paragraphCount++;
			}
			if (!(line.equals(""))) {

				characterCount += line.length();

				// \\s+ is the space delimiter in java
				String[] wordList = line.split("\\s+");

				countWord += wordList.length;
				whitespaceCount += countWord - 1;

				// [!?.:]+ is the sentence delimiter in java
				String[] sentenceList = line.split("[!?.:]+");

				sentenceCount += sentenceList.length;
			}
		}

		// System.out.println("Total word count = " + countWord);
		// System.out.println("Total number of sentences = " + sentenceCount);
		// System.out.println("Total number of characters = " + characterCount);
		// System.out.println("Number of paragraphs = " + paragraphCount);
		// System.out.println("Total number of whitespaces = " + whitespaceCount);

	}

	// main Class ends here
}

class outside_class_two {

}
