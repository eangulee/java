package com.eangulee.chapter2;

public class LowArray {
	private long[] a;

	public LowArray(int size) {
		a = new long[size];
	}
	
	public void setElement(int index,long value) {
		a[index] = value;
	}
	
	public long getElement(int index) {
		return a[index];
	}
	
}
