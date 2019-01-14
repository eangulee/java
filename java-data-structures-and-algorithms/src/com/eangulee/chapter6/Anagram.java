package com.eangulee.chapter6;

// anagram.java
// creates anagrams
// to run this program: C>java AnagramApp
import java.io.*;

////////////////////////////////////////////////////////////////
class AnagramApp {
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	// -----------------------------------------------------------
	public static void mainTest() throws IOException {
		while (true) {
			System.out.print("Enter a word: "); // get word
			String input = getString();
			if (input.equals("q")) 
				break;
			size = input.length(); // find its size
			count = 0;
			for (int j = 0; j < size; j++) // put it in array
				arrChar[j] = input.charAt(j);
			doAnagram(size); // anagram it
			System.out.println();
		}
	} // end main()
		// -----------------------------------------------------------

	public static void doAnagram(int newSize) {
		int limit;
		if (newSize == 1) { // if too small,
			return; // go no further
		}
		for (int j = 0; j < newSize; j++) // for each position,
		{
			doAnagram(newSize - 1); // anagram remaining
			if (newSize == 2) // if innermost,
				displayWord(); // display it
			rotate(newSize); // rotate word
		}
	}

	// -----------------------------------------------------------
	// rotate left all chars from position to end
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position]; // save first letter
		for (j = position + 1; j < size; j++) // shift others left
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp; // put first on right
	}

	// -----------------------------------------------------------
	public static void displayWord() {
		if (count < 99)
			System.out.print(" ");
		if (count < 9)
			System.out.print(" ");
		System.out.print(++count + ". ");
		for (int j = 0; j < size; j++)
			System.out.print(arrChar[j]);
		System.out.print("   ");
		System.out.flush();
		if (count % 6 == 0)
			System.out.println("");
	}

	// -----------------------------------------------------------
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -----------------------------------------------------------
} // end class AnagramApp
////////////////////////////////////////////////////////////////
