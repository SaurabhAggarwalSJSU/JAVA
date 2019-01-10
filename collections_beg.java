import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class collections_beg {

	public static void main(String args[]) {

		// ArrayList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);

		// Array List 2.0
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);

		// Printing them
		arrayList.stream().collect(Collectors.toList()).forEach(System.out::println);

		// Printing arrayList
		System.out.println(Arrays.toString(arrayList.toArray()));

		// Printing arrayList using for loop
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		// Iterator using while loop
		Iterator<Integer> list_iterator = list.iterator();
		while (list_iterator.hasNext()) {
			Integer next_value = list_iterator.next();
			System.out.println(next_value);
		}

		// ArrayList String
		List<String> arraylist_str01 = new ArrayList<String>();
		List<String> arraylist_str02 = new ArrayList<String>();
		arraylist_str02.add(0, "abc");

		arraylist_str01.add("xx");
		arraylist_str01.add("zz");
		arraylist_str01.add("yy");
		arraylist_str01.remove("xx");

		// SIZE() and Contains() not Length X
		System.out.println(arraylist_str02.size());//
		System.out.println(arraylist_str02.contains("abc"));// true

		// indexOf() function - returns index of element if element is found. Negative
		// number otherwise.
		System.out.println(arraylist_str01.indexOf("Dravid"));// -1

		// Get() returns the value not the index
		System.out.println(arraylist_str01.get(0));// abc

		// while loop Interation Same:
		// Iterator<String>arrayList_Iterator = arraylist_str02.iterator();

		// SORT:
		Collections.sort(arraylist_str01);
		System.out.println(arraylist_str01);// [yy, zz]

		// Customized Comparabable interface for the list of objects can also be done
		// Normal sorting wont work in this case.
		// class DescendingSorter implements Comparator<Cricketer> {
		// @Override
		// public int compare(Cricketer cricketer1, Cricketer cricketer2) {

		// Converting ArrayList to array
		String arr = Arrays.toString(arrayList.toArray());
		System.out.println(arr);

		// Converting ArrayList to array using Object array
		Object numbers1ObjArray[] = arrayList.toArray();
		System.out.println(Arrays.toString(numbers1ObjArray));

		// Converting Array to ArrayList using >>Arrays.asList("")<<
		String values[] = { "one", "two", "three" };
		List<String> values_List = Arrays.asList(values);
		System.out.println(values_List);

		// Hash Set
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("Sachin");
		hashSet.add("Lastname");
		System.out.println(hashSet);

		hashSet.add("Sachin");// returns false since element is not added
		System.out.println(hashSet);

		// LinkedHash Set
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("z");
		linkedHashSet.add("a");
		System.out.println(linkedHashSet);

		// Tree Set
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("c");
		treeSet.add("a");
		System.out.println(treeSet);
		// List is sorted in alphabetical order [a, c]

		// MAP INTERFACE:

		// 1) HASHMAP:
		// HashMap implements Map interface , there by supporting key value pairs.

		HashMap<String, ActorsClass> hashMap_01 = new HashMap<String, ActorsClass>();
		hashMap_01.put("key_02", new ActorsClass("value_a_01", 390));
		hashMap_01.put("key_01", new ActorsClass("value_b_02", 190));
		
		//no sorted output, likewise printed
		System.out.println(hashMap_01);
		
		System.out.println(hashMap_01.get("key_01"));

		// If existing key is reused, it would replace existing value with the new value
		// passed in
		// it will not thrown a compiler error but will replace actually

		//2) TreeMAP
		//TreeMap is similar to HashMap except that it stores keys in sorted order. 
		
		TreeMap<String, ActorsClass> treeMap_01 = new TreeMap<String, ActorsClass>();
		treeMap_01.put("key_z", new ActorsClass("01_a", 10));
		treeMap_01.put("key_a", new ActorsClass("02_z", 90));
		
		//You will get a  Sorted KEY output here using it
		System.out.println(treeMap_01);
		System.out.println(treeMap_01.get("z"));
		
	} // void main ends here

//main Class ends here
}

class ActorsClass {
	String name;
	int age;

	public ActorsClass(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getKey() {
		return name;
	}

	public int getValue() {
		return age;
	}

	@Override
	public String toString() {
		return name;
	}

}
