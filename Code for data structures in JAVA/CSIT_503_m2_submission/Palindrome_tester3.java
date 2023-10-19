package CSIT_503_m2_submission;

//Rafael Hidalgo

import java.util.*;

public class Palindrome_tester3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palistring;

		String lowAlphaPaliString;

		String revLowAlphaPaliString;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a potential palindrome:");

		palistring = scan.nextLine();

		lowAlphaPaliString = OnlyLowerAlphaString(palistring);

		revLowAlphaPaliString = Revstring(lowAlphaPaliString);

		IsPalindrome(lowAlphaPaliString, revLowAlphaPaliString);

	}

	
	//this method is to convert User string to lowercase letters for easier comparison.
	public static String OnlyLowerAlphaString(String str) {
		str = str.toLowerCase();

		String str2 = "";


		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)))
				str2 = str2 + (str.charAt(i));
		}

		return str2;

	}

	//this method reverses the string via stack
	public static String Revstring(String str) {

		char[] revString = new char[str.length()];
//         
		Stack<Character> stackchar = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			
			stackchar.push(str.charAt(i));
		}

		int i = 0;
		while (stackchar.size() != 0) { 
			
			revString[i++] = stackchar.pop();
		}
		
		
		return new String(revString);

	}

	//this method compares the regular and reversed string to see is the inputted string is a palindrome
	private static void IsPalindrome(String strNorm, String strRev) {
		if (strNorm.equals(strRev))
			System.out.println("That string IS a palindrome.");
		else
			System.out.println("That string is NOT a palindrome.");

	}
}
