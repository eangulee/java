package com.eangulee.chapter1;

import sun.print.resources.serviceui;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LowArrayApp();
		HighArrayApp();
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
}
