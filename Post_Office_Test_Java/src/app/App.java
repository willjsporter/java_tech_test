package app;

import java.util.Arrays;
import java.util.Scanner;

import app.testFiles.*;

public class App {

	public static arrayDistance distanceTest;
	public static longestPalindrome palindromeTest;

    public static void main(String[] args) throws Exception {
		int t = 1;
		Scanner in = new Scanner(System.in);
		while(t == 1) {
			clearConsole();
			System.out.println("Please enter 1 to run tests or 2 to exit....");
			String s = in.nextLine(); 
			switch(s){
				case "1":
				runTests();
				break;
				case "2":
				System.out.println("Exiting...");
				t = 2;
				break;
				default:
				System.out.println("Invalid input");
				break;
			}
		}
		in.close();
		return;
	}
	
	private static void runTests() {
		System.out.println("Running Tests...");
		System.out.println(" ");
		System.out.println(" ");

		//Distance between closest numbers test
		System.out.println("|--- Array Closest Numbers Difference Test ---|");
		int[] distTestData = {3, 9, 50, 15, 99, 7, 65};
		System.out.println("arrayDistance Test Data = " + Arrays.toString(distTestData));
		distanceTest = new arrayDistance(distTestData);
		if (distanceTest.distClosestNumbers() == 1) {
			System.out.println("Distance Test Pass");
		} else {
			System.out.println("Distance Test Fail");
		}
		System.out.println(" ");
		System.out.println(" ");

		//Palindrome test
		System.out.println("|--- Palindrome Test ---|");
		String dataTests = "find the longest palindrome #fddf# items Step on no pets yay root tenet repaper";
		palindromeTest = new longestPalindrome(dataTests);
		System.out.println(dataTests);
		if (palindromeTest.returnLongestPalindrome() == "Step on no pets" || palindromeTest.returnLongestPalindrome() == "step on no pets") {
			System.out.println("Palindrome test pass");
		} else if (palindromeTest.returnLongestPalindrome() == "repaper") {
			System.out.println("Not quite right have you checked multiple words?");
		} else {
			System.out.println("Palindrome test fail");
		}
		System.out.println(" ");
		System.out.println(" ");

		//Is a Prime Number
		System.out.println("|--- Is a Prime Number Test ---|");
		if (isPrime.isNumberPrime(0) && isPrime.isNumberPrime(999) == false && isPrime.isNumberPrime(233) == true){
			System.out.println("Is prime test passed");
		} else {
			System.out.println("Is prime test failed");
		}
		System.out.println(" ");
		System.out.println(" ");
	}

	public final static void clearConsole()
	{
    	try
    	{
        	final String os = System.getProperty("os.name");

        	if (os.contains("Windows"))
        	{
            	Runtime.getRuntime().exec("cls");
        	}
        	else
        	{
            	Runtime.getRuntime().exec("clear");
        	}
    	}
    	catch (final Exception e)
    	{
        	//  Handle any exceptions.
    	}
	}
}