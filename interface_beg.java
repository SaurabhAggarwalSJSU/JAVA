import java.util.*;
import java.io.*;

public class interface_beg {
	
	public static void main(String args[]) {
		imp_inClass obj = new imp_inClass();
		obj.display();

	} // void main ends here

//main Class ends here
}

interface in_01 {
	public static final int a= 10;
	void display();
}

class imp_inClass implements in_01{
	public void display() {
		System.out.println("Interface implement");
	}
}
