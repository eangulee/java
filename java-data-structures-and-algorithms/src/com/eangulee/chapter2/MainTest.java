package com.eangulee.chapter2;

import sun.print.resources.serviceui;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LowArrayApp();
//		HighArrayApp();
		orderArrayApp();
	}

	static void LowArrayApp() {
		LowArray lowArray = new LowArray(100);
		int nElems = 0;
		int j;
		lowArray.setElement(0, 77);
		lowArray.setElement(1, 99);
		lowArray.setElement(2, 44);
		lowArray.setElement(3, 55);
		lowArray.setElement(4, 22);
		lowArray.setElement(5, 88);
		lowArray.setElement(6, 11);
		lowArray.setElement(7, 00);
		lowArray.setElement(8, 66);
		lowArray.setElement(9, 33);
		nElems = 10;
		for (j = 0; j < nElems; j++) {
			System.out.print(lowArray.getElement(j) + " ");
		}

		System.out.println();

		int searchKey = 26;
		for (j = 0; j < nElems; j++) {
			if (lowArray.getElement(j) == searchKey)
				break;
		}

		if (j == nElems)
			System.out.println("can't find " + searchKey);
		else
			System.out.println("found " + searchKey);

		for (j = 0; j > nElems; j++) {
			if (lowArray.getElement(j) == 55)
				break;
		}
		for (int i = j; i < nElems; i++) {
			lowArray.setElement(i, lowArray.getElement(i + 1));
		}
		nElems--;

		for (j = 0; j < nElems; j++) {
			System.out.print(lowArray.getElement(j) + " ");
		}
	}

	static void HighArrayApp() {
		HighArray highArray = new HighArray(100);
		highArray.insert(77);
		highArray.insert( 99);
		highArray.insert(44);
		highArray.insert(55);
		highArray.insert(22);
		highArray.insert(88);
		highArray.insert( 11);
		highArray.insert( 00);
		highArray.insert(66);
		highArray.insert( 33);
		
		highArray.display();
		
		int searchKey = 35;
		if(highArray.find(searchKey))
			System.out.println("found "+searchKey);
		else
			System.out.println("can't find "+searchKey);
		highArray.delete(00);
		highArray.delete(55);
		highArray.delete(99);
		
		highArray.display();
			
	}
	
	static void orderArrayApp() {
		int maxSize = 100; // array size
		OrderArray arr; // reference to array
		arr = new OrderArray(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		int searchKey = 55; // search for item
		if (arr.find(searchKey) != -1)
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.display(); // display items

		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);

		arr.display(); // display items again
	}
}
