package com.eangulee.chapter6;

// mergeSort.java
// demonstrates recursive merge sort
// to run this program: C>java MergeSortApp
////////////////////////////////////////////////////////////////
class DArray {
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// -----------------------------------------------------------

	public DArray(int max) // constructor
	{
		theArray = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
		System.out.println("");
	}

	// -----------------------------------------------------------
	public void mergeSort() // called by main()
	{ // provides workspace
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}
	//数组进行了(log2)N次分割，然后平均做了N/2次交换O=O((log2)N*N/2)=O(logN*N/2)=O(NlogN)
	//冒泡排序、选择排序和插入排序的时间复杂度O=O(N^2)
	// -----------------------------------------------------------
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) // if range is 1,
			return; // no use sorting
		else { // find midpoint
			int mid = (lowerBound + upperBound) / 2;
			// 将数组进行二分切割成新的数组，递归调用，直到只有1个元素为止1-->1/2-->1/4-->1/8-->1/16-->....
			// sort low half
			recMergeSort(workSpace, lowerBound, mid);
			// sort high half
			recMergeSort(workSpace, mid + 1, upperBound);
			// merge them
			// 因为分割到只有1个元素，最先调用merge的索引位是lowPtr=mid,highPtr=mid+1,upperBound=mid+1,其中mid=0
			// 将分割的数组进行合并，合并的时候比较大小，...-->1/16-->1/8-->1/4-->1/2-->1
			System.out.println("lowPtr=" + lowerBound + ",highPtr=" + (mid + 1) + ",upperBound=" + upperBound);
			merge(workSpace, lowerBound, mid + 1, upperBound);
		} // end else
	} // end recMergeSort()
		// -----------------------------------------------------------

	/**
	 * 
	 * @version 创建时间：2019年1月14日 下午2:01:18
	 * @description 说明：
	 *
	 * @param workSpace  临时数组
	 * @param lowPtr     低位数组起始位
	 * @param highPtr    高位数组起始位
	 * @param upperBound 数组最高位
	 */
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items

		// 低位数组和高位数组依次比较，合并到一个新数组
		while (lowPtr <= mid && highPtr <= upperBound)
			if (theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];

		// 如果高位数组已经合并完成，低位数组的剩余项直接追加到新数组后面
		while (lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];

		// 如果低位数组已经合并完成，高位数组的剩余项直接追加到新数组后面
		while (highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];

		for (j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];
	} // end merge()
		// -----------------------------------------------------------
} // end class DArray
////////////////////////////////////////////////////////////////

class MergeSortApp {
	public static void mainTest() {
		int maxSize = 100; // array size
		DArray arr; // reference to array
		arr = new DArray(maxSize); // create the array

		arr.insert(64); // insert items
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(99);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);
		arr.insert(199);
		arr.insert(30);
		arr.insert(208);
		arr.insert(136);

		arr.display(); // display items

		arr.mergeSort(); // merge sort the array

		arr.display(); // display items again
	} // end main()
} // end class MergeSortApp
////////////////////////////////////////////////////////////////
