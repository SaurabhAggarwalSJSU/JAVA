import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Stacks_beg {
	public static void main(String args[]) {
		Stack stackObj = new Stack();
		stackObj.push(1);
		stackObj.push(10);
		stackObj.pop(1);
	} // end of main

	// create stack class with push and pop functionalities
	public static class Stack {

		// initialze variables

		// size of the stack
		static final int max = 100;

		// pointer to top of the stack
		int top;

		// array to store the stack
		int a[] = new int[max];

		// constructor, whenever instance or object of this class created each time top
		// goes to -1
		public Stack() {
			top = -1;
		}

		// PUSH OPERATION
		public boolean push(int x) {
			if (top >= (max - 1)) {
				System.out.println("Overflow");
				return false;
			} else {
				a[++top] = x;
				System.out.println(x + " pushed into stack");
				return true;
			}
		}

		public int pop(int x) {
			if (top < 0) {
				System.out.println("empty stack what to remove ?");
				return -1;
			}
			// removed element returned:
			int popedvalue = a[top--];
			System.out.println("Current Array is: " + Arrays.toString(a));
			return a[popedvalue];

		}

	}

} // end of class
