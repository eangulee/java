package com.eangulee.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StackApp();
//		ReverseStackApp();
		BracketsCheckApp();
	}

	public static void StackApp() {
		Stack theStack = new Stack(10); // make new stack
		theStack.push(20); // push items onto stack
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);

		while (!theStack.isEmpty()) // until it's empty,
		{ // delete item from stack
			long value = theStack.pop();
			System.out.print(value); // display it
			System.out.print(" ");
		} // end while
		System.out.println("");
	} // end

	// 使用队列对字符串进行反转
	public static void ReverseStackApp() throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter a string: ");
			System.out.flush();
			input = getString(); // read a string from kbd
			if (input.equals("")) // quit if [Enter]
				break;
			// make a Reverser
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev(); // use it
			System.out.println("Reversed: " + output);
		} // end while
	} // end main()
//--------------------------------------------------------------

	//判定分隔符是否匹配
	public static void BracketsCheckApp() throws IOException {
		String input;
		while (true) {
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString(); // read a string from kbd
			if (input.equals("")) // quit if [Enter]
				break;
			// make a BracketChecker
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check(); // check brackets
		} // end while
	} // end main()
//--------------------------------------------------------------

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
