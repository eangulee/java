package com.eangulee.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {
	public static void main(String[] args) throws IOException {
		TriangleApp();
	} // end main()

	private static void TriangleApp() throws IOException {
		System.out.print("Enter a number: ");
		int theNumber = getInt();
		int theAnswer = Triangle.triangle(theNumber);
		System.out.println("Triangle=" + theAnswer);
	}
	
	//-------------------------------------------------------------
		public static String getString() throws IOException {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			return s;
		}

	//-------------------------------------------------------------
		public static int getInt() throws IOException {
			String s = getString();
			return Integer.parseInt(s);
		}
	//--------------------------------------------------------------
}
