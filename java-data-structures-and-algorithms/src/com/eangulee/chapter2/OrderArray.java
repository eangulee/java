package com.eangulee.chapter2;

import sun.print.resources.serviceui;

public class OrderArray {
	private long[] a;
	private int nElems;

	public OrderArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int getSize() {
		return nElems;
	}
	
	//O(log2N => log10N*3.332 = >logN)
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIndex = 0;
		while (true) {
			curIndex = (lowerBound + upperBound) / 2;//二分
			if (a[curIndex] == searchKey)
				return curIndex;
			else if(lowerBound>upperBound)//地位已经超过高位了，找不到
				return -1;
			else {
				if (a[curIndex] < searchKey)
					lowerBound = curIndex + 1;//中间值小于搜索值
				else
					upperBound = curIndex - 1;//中间值大于搜索值
			}
		}
	}

	public void insert(long value) // put element into array
	{
		int j;
		for (j = 0; j < nElems; j++) // find where it goes
			if (a[j] > value) // (linear search)
				break;
		for (int k = nElems; k > j; k--) // move bigger ones up
			a[k] = a[k - 1];
		a[j] = value; // insert it
		nElems++; // increment size
	} // end insert()

	public boolean delete(long value) {
		int j = find(value);
		if (j == -1)
			return false;
		else {
			for (int i = j; i < nElems; i++) {
				a[i] = a[i + 1];
			}
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
}
