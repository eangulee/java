package com.eangulee.chapter3;

// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////
public class InsertSort
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public InsertSort(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort()//O(N^2)
      {
      int out, in;

      for(out=1; out<nElems; out++)   // outer loop
         {
    	  long temp = a[out];//mark element
    	  in = out;
    	  while(in > 0&& a[in-1] > temp) {//左边维护一个局部有序的队列，然后标记一个没有排序的元素，在局部有序队列中比标记的大往右移，最左端不能超过0索引位
    		  a[in] = a[in-1];
    		  in --;    		  
    	  }
    	  a[in] = temp;    	  
         }  // end for(out)
      }  // end insertionSort()
   }  // end class ArraySel
