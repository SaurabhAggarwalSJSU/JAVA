import java.util.*;
import java.util.Arrays;

public class arrays_beg {

	public static void main(String args[]) {

		array_basics();
		arrayList_with_arrays();

	} // void main ends here

	public static void array_basics() {
		int arr[] = new int[50];
		arr[0] = 1;
		arr[1] = 2;
		System.out.println(arr[0]);

		int arr_02[] = { 1, 2, 3 };
		System.out.println(arr_02[0]);

		String arr_03[] = { "a", "b", "c" };
		System.out.println(arr_03[0]);

		// array to string
		Arrays.toString(arr);
		System.out.println(arr[1]);

		// Loop-2
		for (int i = 0; i < arr_03.length; i++) {
			System.out.println("print in loop " + arr_03[i]);
		}

		for (String i : arr_03) {
			System.out.println("print in loop 2 " + i);
		}

		// 2D array
		int matrix[][] = new int[10][10];
		int matrix_02[][] = { { 100, 200 }, { 300, 400 } };

		System.out.println(matrix[1][1]);

		// Loop-3
		for (int pos_array[] : matrix_02) {
			for (int i : pos_array) {
				System.out.println("Loop-3 " + i);
			}
		}

		// Loop -4
		for (int i = 0; i < matrix_02.length; i++) {
			for (int j = 0; j < matrix_02.length; j++) {
				System.out.println("Loop-4 " + matrix_02[i][j]);
			}
		}

		// Functions:
		// System.out.println(Arrays .equals(numbers1, numbers2)); //false
		// Arrays.sort(rollNos);
		// System.out.println(Arrays.toString(rollNos));//[5, 7, 9, 12]
	}

	public static void arrayList_with_arrays() {

		// array members are accessed using [],
		// while ArrayList has a set of methods to access elements and modify them.

		// Need to specify the size for array
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		// We cannot add more elements to array arr[]

		/* ............ArrayList.............. */
		// Need not to specify size
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		arrL.add(1);
		arrL.add(2);
		arrL.add(3);
		arrL.add(4);
		// We can add more elements to arrL

		// When we do arraylist.add(1); : it converts the primitive int data type into
		// an Integer object
		// not allowed (Uncommenting below line causes
		// compiler error)
		// ArrayList<char> arrL = new ArrayList<char>();
		ArrayList<Integer> arrL1 = new ArrayList<>();
		ArrayList<String> arrL2 = new ArrayList<>();
		ArrayList<Object> arrL3 = new ArrayList<>();

		// Array List for array of objects
		// If you are unsure of the size of the array or if it can change you can do
		// this to have a static array.

		ArrayList<People_Class_02> arrayList_01 = new ArrayList<People_Class_02>();
		arrayList_01.add(new People_Class_02("a", 1, "2"));
		arrayList_01.add(new People_Class_02("b", 1, "3"));

		// Making an Array of Objects
		People_Class_02 arrayObjects[] = new People_Class_02[3];
		arrayObjects[0] = new People_Class_02("name1", 2, "3");
		arrayObjects[1] = new People_Class_02("name2", 2, "3");
		arrayObjects[2] = new People_Class_02("name3", 2, "3");
		System.out.println("Array of Objects at 0th is " + arrayObjects[0]);
	}

	public static int[] array_basics_01(int[] arr) {

		int intArr[] = { 10, 20, 15, 22, 35 };
		int intArr1[] = { 10, 15, 22 };

		byte byteArray[];
		char charArray[];
		Person_Class arr_obj[];
		Object arr_obj_array[];
		Collections arr_coll[];

		int[][] intArray = new int[10][20]; // a 2D array or matrix
		int[][][] intArray_3 = new int[10][20][10]; // a 3D array

		int cloneArray[][] = intArray.clone();

		// will print false as deep copy is created
		System.out.println(intArray == cloneArray); // false
		System.out.println(intArray[0] == cloneArray[0]); // true

		// change index of array in java using maps
		Map<String, String> fruitMap = new HashMap<>();
		fruitMap.put("orange", "orange");
		// Fruit[orange] = orange not possible

		// ARRAYS CLASS:
		Arrays.asList(intArr);
		Arrays.sort(intArr);
		Arrays.binarySearch(intArr, 1);
		// int a = Arrays.compare(intArr, intArr199);
		Arrays.copyOf(intArr, 10);
		Arrays.copyOfRange(intArr, 1, 3);
		// Arrays.deepEquals(intArr, intArr1);
		// Arrays.equals(intArr, intArr1)
		Arrays.sort(intArr); // in ascending order.
		// for descending order reverse the array sorted or print using back for loop
		// Arrays.sort(intArr, 1, 3);
		Arrays.toString(intArr);// [10, 20, 15, 22, 35]

		// final int arr[] = {1, 2, 3, 4, 5}; // Note: arr is final
		// he array arr is declared as final, but the elements of array are changed
		// without any problem.
		// arr[i] = arr[i]*10; ok

		// So a final array means that the array variable which is actually a reference
		// to an object, cannot be changed to refer to anything else, but the members of
		// array can be modified.

		return new int[] { 1, 2, 3 };
	}

	public static void array_operations() {

	}

	// main Class ends here
}

class Person_Class {
	String name;
	int age;
	String address;

	public Person_Class(String name, int age, String address) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	// whenever SOP of object is done, rather than some random number name is
	// returned instead
	@Override
	public String toString() {
		return name;
	}

}
