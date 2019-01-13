package com.eangulee.chapter5;

// linkStack.java
// demonstrates a stack implemented as a list
// to run this program: C>java LinkStackApp
////////////////////////////////////////////////////////////////
class StatckLink {
	public long dData; // data item
	public StatckLink next; // next LinkStatck in list
// -------------------------------------------------------------

	public StatckLink(long dd) // constructor
	{
		dData = dd;
	}

// -------------------------------------------------------------
	public void displayLink() // display ourself
	{
		System.out.print(dData + " ");
	}
} // end class Link

////////////////////////////////////////////////////////////////
class StatckLinkList {
	private StatckLink first; // ref to first item on list
// -------------------------------------------------------------

	public StatckLinkList() // constructor
	{
		first = null;
	} // no items on list yet
// -------------------------------------------------------------

	public boolean isEmpty() // true if list is empty
	{
		return (first == null);
	}

	// O(N)
// -------------------------------------------------------------
	public void insertFirst(long dd) // insert at start of list
	{ // make new link
		StatckLink newLink = new StatckLink(dd);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	// O(N)
// -------------------------------------------------------------
	public long deleteFirst() // delete first item
	{ // (assumes list not empty)
		StatckLink temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp.dData; // return deleted link
	}

// -------------------------------------------------------------
	public void displayList() {
		StatckLink current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
// -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////

class LinkStack {
	private StatckLinkList theList;

//--------------------------------------------------------------
	public LinkStack() // constructor
	{
		theList = new StatckLinkList();
	}

//--------------------------------------------------------------
	public void push(long j) // put item on top of stack
	{
		theList.insertFirst(j);
	}

//--------------------------------------------------------------
	public long pop() // take item from top of stack
	{
		return theList.deleteFirst();
	}

//--------------------------------------------------------------
	public boolean isEmpty() // true if stack is empty
	{
		return (theList.isEmpty());
	}

//--------------------------------------------------------------
	public void displayStack() {
		System.out.print("Stack (top-->bottom): ");
		theList.displayList();
	}
//--------------------------------------------------------------
} // end class LinkStack
////////////////////////////////////////////////////////////////
