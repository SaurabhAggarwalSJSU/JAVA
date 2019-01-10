import java.util.*;

public class functions_within_class {

	public static void main(String args[]) {

		//for calling non static method object created	
		functions_within_class nonStaticMethod = new functions_within_class();

		//taking static method into some variable result
		String result = staticMethod_2();
		System.out.println(result);

		//calling directly static method
		System.out.println(staticMethod());

		//Using name of the class directly call static method
		System.out.println(nonStaticMethod.nonStaticMethod());

		//demo class method called
		demo_class demo_classObj = new demo_class();
		System.out.println(demo_classObj.demo_class_method("Within demo Class string"));

		//outside the main class body
		demo_class_outside demo_class_outsideObj = new demo_class_outside();
		demo_class_outsideObj.name = "actorname";
		System.out.println(demo_class_outsideObj);

	}

	//Static class and methods
	public static String staticMethod_2() {
		return "abc";
	}

	public static String staticMethod() {
		return "ststic method";
	}

	public static class demo_class {

		public String demo_class_method(String inputString) {
			return inputString;
		}

	}
	
	//non static class and methods:
	public String nonStaticMethod() {
		return "nonStaticMethod";
	}

//main Class ends here
}

//outside domain class
class demo_class_outside {
	String name;
}
