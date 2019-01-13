package com.eangulee.chapter6;

// triangle.java
// evaluates triangular numbers
// to run this program: C>java TriangleApp
import java.io.*;

////////////////////////////////////////////////////////////////
class Triangle {

//-------------------------------------------------------------
	public static int triangle(int n) {
		if (n == 1)
			return 1;
		else
			return (n + triangle(n - 1));
	}

} // end class TriangleApp
////////////////////////////////////////////////////////////////
