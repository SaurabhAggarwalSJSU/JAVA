import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class collections_LINQ {
	
	public static void main(String args[]) {
		
		//ArrayList
		ArrayList<Integer> arrayList_Integer = new ArrayList<Integer>();
		arrayList_Integer.add(1);
		
		ArrayList<String> arraylist_string = new ArrayList<String>();
		arraylist_string.add("abc");
		arrayList_Integer.forEach(n -> System.out.println(n));
		
		ArrayList<ActorClass> actor_arrayList = new ArrayList<ActorClass>();
		actor_arrayList.add(new ActorClass("a", 20));
		actor_arrayList.add(new ActorClass("b", 90));
		
		//WHERE
		List<ActorClass> abc = actor_arrayList.stream().filter(x->x.age > 20).collect(Collectors.toList());
		
		//SELECT
		List<String> names = actor_arrayList.stream().map(x->x.name).distinct().collect(Collectors.toList());
		
		//PRINT the names in the list of objects
		actor_arrayList.stream().map(x->x.name).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		//GET MININMUM AGE
	    int min_age = actor_arrayList.stream().min(Comparator.comparing(ActorClass::getAge)).get().getAge();
		System.out.println(min_age);
		
		//FIRST:
		int first_age = actor_arrayList.stream().filter(x->x.age > 0).findFirst().get().getAge();
		System.out.println(first_age);
		
		//Count:
		int count_age = (int)actor_arrayList.stream().filter(x->x.age > 0).count();
		System.out.println(count_age);
		
		//TO DICTIONARY:
		Map<String, Integer> map = actor_arrayList.stream().filter(x->x.age > 0).collect(Collectors.toMap(ActorClass::getKey, ActorClass::getValue));
		
		//PRINT A MAP:
		map.forEach((k, v) -> System.out.println(k + " => " + v));
		
		//GROUPBY:
		actor_arrayList.stream().filter(x->x.age > 0).collect(Collectors.groupingBy(ActorClass::getAge)).forEach((k, v) -> System.out.println(k + " => " + v.toString()));
		
		//GROUPBY: Type
		Map<Integer, List<ActorClass>> grouping= actor_arrayList.stream().filter(x->x.age > 0).collect(Collectors.groupingBy(ActorClass::getAge));
		grouping.forEach((k, v) -> System.out.println(k + " => " + v.toString()));
		
	} // void main ends here

//main Class ends here
}

class ActorClass {
	String name;
	int age;

	public ActorClass(String name, int age) {
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
