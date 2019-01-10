package com.eangulee.chapter3;


public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BubbleSortApp();
//		SelectSortApp();
		InsertSortApp();
	}

	public static void BubbleSortApp() {
		int maxSize = 100; // array size
		ArrayBub arr; // reference to array
		arr = new ArrayBub(maxSize); // create the array

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

		arr.display(); // display items

		arr.bubbleSort(); // bubble sort them

		arr.display(); // display them again
	}

	public static void SelectSortApp() {
		int maxSize = 100; // array size
		SelectSort arr; // reference to array
		arr = new SelectSort(maxSize); // create the array

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

		arr.display(); // display items

		arr.selectionSort(); // selection-sort them

		arr.display(); // display them again
	}
	
	 public static void InsertSortApp()
     {
     int maxSize = 100;            // array size
     InsertSort arr;                 // reference to array
     arr = new InsertSort(maxSize);  // create the array

     arr.insert(77);               // insert 10 items
     arr.insert(99);
     arr.insert(44);
     arr.insert(55);
     arr.insert(22);
     arr.insert(88);
     arr.insert(11);
     arr.insert(00);
     arr.insert(66);
     arr.insert(33);

     arr.display();                // display items

     arr.insertionSort();          // insertion-sort them

     arr.display();                // display them again
     }  // end main()
}
