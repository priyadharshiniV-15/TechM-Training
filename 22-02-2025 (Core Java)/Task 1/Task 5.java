package TASK1;

import java.util.Scanner;

//You are requiredtocreate a string andcaptialize every alternative character. for
//eg :ifthe inputis anurag then outputshould beAnUrAg
public class Task5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String s = sc.nextLine();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0)
				result.append(Character.toUpperCase(s.charAt(i)));

			else
				result.append(s.charAt(i));
    }
    sc.close();
	}

}
