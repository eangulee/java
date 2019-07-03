package com.eangulee;

import java.util.Stack;
import java.util.Scanner;

///括号成对校验
public class VerifyBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {			
			Scanner scanner = new Scanner(System.in);
			System.out.println("please input a string:");
//			String str = "(KDJL[kfdlafd{fdafads}fdafafa)]";
			String str = scanner.nextLine();
			if(str.isEmpty()) 
				System.out.println("please do not enter empty!");			
			else
				System.out.println(str + " is " + VerifyBracket(str));
		}
	}

	static boolean VerifyBracket(String str) {
		if(str.isEmpty()) return false;
		char[] chars = str.toCharArray();
		Stack stack = new Stack();

		for (char c : chars) {
			if (c == '(' || c == '{' || c == '[')
				stack.add(c);
			else {
				switch (c) {
				case ')':
					if ((char) stack.peek() == '(')
						stack.pop();
					break;
				case '}':
					if ((char) stack.peek() == '{')
						stack.pop();
					break;
				case ']':
					if ((char) stack.peek() == '[')
						stack.pop();
					break;
				}
			}
		}

		return stack.size() == 0;
	}

}
