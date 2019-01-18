import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

//create:
enum Colors_Enum {
	red, blue, gree, grey, black
};

//custom value enumeration:
enum Traffic_Signal {

	// calling string type constructor of enum
	Red("Stop"), Green("Go"), Yellow("Wait");

	// declaring private variable for getting values
	private String action;

	// getter method
	public String getAction() {
		return this.action;
	}

	// enum constructor - cannot be public or protected
	private Traffic_Signal(String action) {
		this.action = action;
	}

}

//custom value enum:

public class java_beg {

	public static void main(String args[]) {

		enum_practise();

		final_methods();

		loops_methos();
		
		Binary_search_java();

	} // void main ends here

	public static String[] enum_to_array() {
		return Stream.of(Colors_Enum.values()).map(Colors_Enum::name).toArray(String[]::new);
	}

	public static void enum_practise() {

		// access:
		Colors_Enum col_obj = Colors_Enum.red;
		System.out.println("name is :: " + col_obj.name()); // red
		System.out.println(col_obj); // red

		// loop:
		for (Colors_Enum item : Colors_Enum.values()) {
			// print:
			System.out.println(item.toString());
			// red
			// green
			// blue
		}

		// enum array
		Colors_Enum[] enum_array = Colors_Enum.values();

		// convert to array:
		String arr[] = enum_to_array();
		for (String item : arr) {
			System.out.println(item);
			// red
			// green
			// blue
		}

		// customized enums:

		// get enum values first:
		Traffic_Signal[] enum_values = Traffic_Signal.values();
		for (Traffic_Signal signal : enum_values) {
			System.out.println("name : " + signal.name() + " action: " + signal.getAction());
		}

		// operations:
		System.out.println(Arrays.toString(Colors_Enum.values())); // [red, green, bleu...]
		System.out.println(Colors_Enum.valueOf("red")); // red

	}

	public static void final_methods() {

		StringBuffer sbf = new StringBuffer("Geeksforgeeks");
		System.out.println("String buffer = " + sbf);

		// Here it appends the CodePoint as
		// string to the string buffer
		sbf.appendCodePoint(54); // Geeksforgeeks6

		// access static variable defined outside the class
		double sal = outside_class_final.salary;

		// final value constant_value = 100 //error
		int cc = outside_class_final.constant_value;

		outside_class_final t1 = new outside_class_final();
		System.out.println(t1.i);

		outside_class_final t2 = new outside_class_final(20);
		System.out.println(t2.i);

	}

	public static void loops_methos() {
		int x = 1;

		// Exit when x becomes greater than 4
		while (x <= 4) {
			System.out.println("Value of x:" + x);

			// Increment the value of x for
			// next iteration
			x++;
		}

		String array[] = { "Ron", "Harry", "Hermoine" };

		// for each loop
		// not appropriate when you want to modify the array:
//only iterates forward over the array in single steps

		int index = 0;
		for (String x_1 : array) {
			index++;
			System.out.println(x_1);
		}

		// for loop for same function
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		int x_2 = 21;
		do {
			// The line will be printed even
			// if the condition is false
			System.out.println("Value of x:" + x_2);
			x_2++;
		} while (x_2 < 20); // output is Value of x: 21

		/*
		 * for ( ; ; ) is similar to while(true)
		 */

		// CONTINUE:
		for (int i = 0; i < 10; i++) {
			// If the number is even
			// skip and continue
			if (i % 2 == 0)
				continue;

			// If number is odd, print it
			// System.out.print(i + " ");
		}

		// Switch case
		String str = "two";
		switch (str) {
		case "one":
			System.out.println("one");
			break;
		case "two":
			System.out.println("two");
			break;
		case "three":
			System.out.println("three");
			break;
		default:
			System.out.println("no match");
		}

		double d = 100.04;

		// explicit type casting
		long l = (long) d;

		// explicit type casting
		int ii = (int) l;

		// using label and continue /Break
		// instead of GOTO::

		// label for outer loop
		outer: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 1)
					break outer;
				// continue outer;
				System.out.println(" value of j = " + j);
			}
		}

		// compile-time error : can't find symbol 'NULL'
		// Object obj = NULL;

		// runs successfully
		Object obj1 = null;

		/*
		 * Unlike common misconception, null is not Object or neither a type. It’s just
		 * a special value, which can be assigned to any reference type and you can type
		 * cast null to any type
		 */
		// null can be assigned to String
		String str_01 = null;

		// you can assign null to Integer also
		Integer itr = null;

		// null can also be assigned to Double
		Double dbl = null;

		// null can be type cast to String
		String myStr = (String) null;

		// it can also be type casted to Integer
		Integer myItr = (Integer) null;

		// yes it's possible, no error
		Double myDbl = (Double) null;
		
		//Swapping values of 1 class 2 objects
		inside_class_car c1 = new inside_class_car(1); 
		inside_class_car c2 = new inside_class_car(2); 
        swap(c1, c2); 

	}

	public static void Binary_search_java() {

		// If input list is not sorted, the results are undefined.
		// If there are duplicates, there is no guarantee which one will be found.
		// This method runs in log(n) time for a “random access” list like ArrayList

		// Binary Serach on Arrays
		Integer arr[] = { 1, 2, 3, 4, 5, 6 };
		Arrays.sort(arr);

		int key = 2;
		int res = Arrays.binarySearch(arr, key);
		if (res >= 0)
			System.out.println(key + " found at index = " + res);
		else
			System.out.println(key + " Not found");

		// Your own binary search:

		// Binary Search on ArrayList
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		int res_al = Collections.binarySearch(al, key);

		// Sorting
		Collections.sort(al);

		// Order By Descending
		// Sorts arr[] in descending order
		Arrays.sort(arr, Collections.reverseOrder());

		int[] arr2 = { 13, 7, 6, 45, 21, 9, 2, 100 };

		// Sort subarray from index 1 to 4, i.e.,
		// only sort subarray {7, 6, 45, 21} and
		// keep other elements as it is.
		Arrays.sort(arr2, 1, 5); // index 1 to 4

		System.out.printf("Modified arr[] : %s", Arrays.toString(arr2));
	}
	
	public static void method_inheritence() {

		// interface one
		// interface two
		// interface three extends one,two
		// class child implements three
		// interface definations inside this
		// https://www.geeksforgeeks.org/inheritance-in-java/
	}
	
	public static void swap(inside_class_car c1, inside_class_car c2)
	{
		int temp = c1.no; 
        c1.no = c2.no; 
        c2.no = temp; 
	}
	
	public static class inside_class {

	}
	
	public static class inside_class_car{
		
		int no;
		inside_class_car(int no){
			this.no = no;
		}
	}

//main Class ends here
}

class outside_class_final {

	// can be accessed anyhere using class name staright
	public static double salary;

	// A final variable in Java can be assigned a value only once, we can assign a
	// value either in declaration or later.
	public static final int constant_value = 30;

	// constructor chaining to define final variables:
	final public int i;

	outside_class_final(int val) {
		this.i = val;
	}

	outside_class_final() {
		// Calling Test(int val)
		this(10);
	}
}
