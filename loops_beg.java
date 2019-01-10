import java.util.*;

public class loops_beg {
	
	//Enumerations
	static enum seasons {Winter, Summer, fall, Spring, autumm};

	public static void main(String args[]) {

		//Two inputs for loop
		int arr[] = new int[50];
		int arr2[] = { 1, 2, 3, 4 };
		for (int i = 0, j = 0; i < arr2.length; i++, j--) {
			System.out.print(j);
		}
		
		//get value of enums using ordinal
		System.out.print("\n");
		System.out.println(seasons.Summer.ordinal());
		
		System.out.print("\n");
		
		//loop through on enums:
		for(seasons current_season : seasons.values()) {
			System.out.println(current_season);
		}
		

	} // void main ends here

//main Class ends here
}

class People_Class_02 {
	String name;
	int age;
	String address;

	public People_Class_02(String name, int age, String address) {
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
