package com.eangulee.chapter3;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
	private long[] a; // ref to array a
	private int nElems; // number of data items
//--------------------------------------------------------------

	public ArrayBub(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

//--------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

//--------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// O = N-1 + N-2 + ... + 1 = N*(N-1)/2 = O(N^2)  
	// O(1) > O(logN) > O(N) > O(N*logN) > O(N^2) > O(N!)
	public void bubbleSort() {
		int out, in;
		//只有比我大的就交换到右边，最后大的往右，小的在左边，所以称为冒泡排序
		for (out = nElems - 1; out > 1; out--) // outer loop (backward)
			for (in = 0; in < out; in++) // inner loop (forward)
				if (a[in] > a[in + 1]) // out of order?
					swap(in, in + 1); // swap them
	} // end bubbleSort()
//--------------------------------------------------------------

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
//--------------------------------------------------------------
} // end class ArrayBub