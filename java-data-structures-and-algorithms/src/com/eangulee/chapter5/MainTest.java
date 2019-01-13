package com.eangulee.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTest {

	public static void main(String[] args) throws IOException {
//		LinkListApp();
//		LinkListApp2();
//		FirstLastApp();
//		LinkStackApp();
		LinkQueueApp();
	}

	public static void LinkListApp() {
		LinkList theList = new LinkList(); // make new list

		theList.insertFirst(22, 2.99); // insert four items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);

		theList.displayList(); // display list

		while (!theList.isEmpty()) // until it's empty,
		{
			Link aLink = theList.deleteFirst(); // delete link
			System.out.print("Deleted "); // display it
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayList(); // display list
	} // end main()

	public static void LinkListApp2() {
		LinkList theList = new LinkList(); // make list

		theList.insertFirst(22, 2.99); // insert 4 items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);

		theList.displayList(); // display list

		Link f = theList.find2(44); // find item
		if (f != null)
			System.out.println("Found link with key " + f.iData);
		else
			System.out.println("Can't find link");

		Link d = theList.delete(66); // delete item
		if (d != null)
			System.out.println("Deleted link with key " + d.iData);
		else
			System.out.println("Can't delete link");

		theList.displayList(); // display list
	}

	public static void FirstLastApp() { // make a new list
		FirstLastList theList = new FirstLastList();

		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);

		theList.displayList(); // display the list

		theList.deleteFirst(); // delete first two items
		theList.deleteFirst();

		theList.displayList(); // display again
	} // end main()

	public static void LinkStackApp() {
		LinkStack theStack = new LinkStack(); // make stack

		theStack.push(20); // push items
		theStack.push(40);

		theStack.displayStack(); // display stack

		theStack.push(60); // push items
		theStack.push(80);

		theStack.displayStack(); // display stack

		theStack.pop(); // pop items
		theStack.pop();

		theStack.displayStack(); // display stack
	} // end main()

	public static void LinkQueueApp() {
		LinkQueue theQueue = new LinkQueue();
		theQueue.insert(20); // insert items
		theQueue.insert(40);

		theQueue.displayQueue(); // display queue

		theQueue.insert(60); // insert items
		theQueue.insert(80);

		theQueue.displayQueue(); // display queue

		theQueue.remove(); // remove items
		theQueue.remove();

		theQueue.displayQueue(); // display queue
	} // end main()
}
