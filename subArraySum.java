import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

//custom value enum:

public class subArraySum {

	public static void main(String args[]) {

		int a[] = { 1, 4, 45, 6, 0, 19 };
		int sum = 51;

		int p1 = 0;
		int p2 = 0;
		int currSum = a[p2];

		while (p2 < a.length - 1) {
			while (p2 <= a.length - 2 && currSum + a[p2 + 1] < sum) {
				currSum += a[++p2];
			}

			currSum += a[++p2];
			while (currSum - a[p1] > sum && p1 < p2) {
				currSum -= a[p1];
				p1++;
			}
			// printing the 3 ranges from there. Now you can keep finding smallest etc.
			System.out.println(p1 + " " + p2);

		} // void main ends here

//main Class ends here
	}
}
