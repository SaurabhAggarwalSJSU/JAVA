import java.util.*;

public class arrays_beg {

	public static void main(String args[]) {

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

		// Array List for array of objects
		// If you are unsure of the size of the array or if it can change you can do
		// this to have a static array.

		ArrayList<People_Class> arrayList_01 = new ArrayList<People_Class>();
		arrayList_01.add(new People_Class("a", 1, "2"));
		arrayList_01.add(new People_Class("b", 1, "3"));

		// Making an Array of Objects
		People_Class arrayObjects[] = new People_Class[3];
		arrayObjects[0] = new People_Class("name1", 2, "3");
		arrayObjects[1] = new People_Class("name2", 2, "3");
		arrayObjects[2] = new People_Class("name3", 2, "3");
		System.out.println("Array of Objects at 0th is " + arrayObjects[0]);
		
		

	} // void main ends here

//main Class ends here
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

	// wheneevr SOP of object is done, rather than some random number name is
	// returned instead
	@Override
	public String toString() {
		return name;
	}

}
