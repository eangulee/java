package com.eangulee.chapter5;

// linkQueue.java
// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQueueApp
////////////////////////////////////////////////////////////////
class QueueLink {
	public long dData; // data item
	public QueueLink next; // next queue link in list
// -------------------------------------------------------------

	public QueueLink(long d) // constructor
	{
		dData = d;
	}

// -------------------------------------------------------------
	public void displayLink() // display this link
	{
		System.out.print(dData + " ");
	}
// -------------------------------------------------------------
} // end class Link
////////////////////////////////////////////////////////////////

class QueueLinkFirstLastList {
	private QueueLink first; // ref to first item
	private QueueLink last; // ref to last item
// -------------------------------------------------------------

	public QueueLinkFirstLastList() // constructor
	{
		first = null; // no items on list yet
		last = null;
	}

// -------------------------------------------------------------
	public boolean isEmpty() // true if no links
	{
		return first == null;
	}

	// O(1)
// -------------------------------------------------------------
	public void insertLast(long dd) // insert at end of list
	{
		QueueLink newLink = new QueueLink(dd); // make new link
		if (isEmpty()) // if empty list,
			first = newLink; // first --> newLink
		else
			last.next = newLink; // old last --> newLink
		last = newLink; // newLink <-- last
	}

	// O(1)
// -------------------------------------------------------------
	public long deleteFirst() // delete first link
	{ // (assumes non-empty list)
		long temp = first.dData;
		if (first.next == null) // if only one item
			last = null; // null <-- last
		first = first.next; // first --> old next
		return temp;
	}

// -------------------------------------------------------------
	public void displayList() {
		QueueLink current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
// -------------------------------------------------------------
} // end class FirstLastList
////////////////////////////////////////////////////////////////

class LinkQueue {
	private QueueLinkFirstLastList theList;

//--------------------------------------------------------------
	public LinkQueue() // constructor
	{
		theList = new QueueLinkFirstLastList();
	} // make a 2-ended list
//--------------------------------------------------------------

	public boolean isEmpty() // true if queue is empty
	{
		return theList.isEmpty();
	}

//--------------------------------------------------------------
	public void insert(long j) // insert, rear of queue
	{
		theList.insertLast(j);
	}

//--------------------------------------------------------------
	public long remove() // remove, front of queue
	{
		return theList.deleteFirst();
	}

//--------------------------------------------------------------
	public void displayQueue() {
		System.out.print("Queue (front-->rear): ");
		theList.displayList();
	}
//--------------------------------------------------------------
} // end class LinkQueue
////////////////////////////////////////////////////////////////
