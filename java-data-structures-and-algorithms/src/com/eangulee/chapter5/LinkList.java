package com.eangulee.chapter5;

// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////


class LinkList {
	private Link first; // ref to first link on list

// -------------------------------------------------------------
	public LinkList() // constructor
	{
		first = null; // no links on list yet
	}

// -------------------------------------------------------------
	public boolean isEmpty() // true if list is empty
	{
		return (first == null);
	}

	//O(1)
// -------------------------------------------------------------
	// insert at start of list
	public void insertFirst(int id, double dd) { // make new link
		Link newLink = new Link(id, dd);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	//O(N)
	public Link find(int key) // find link with given key
	{ // (assumes non-empty list)
		Link current = first; // start at 'first'
		while (current.iData != key) // while no match,
		{
			if (current.next == null) // if end of list,
				return null; // didn't find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current; // found it
	}

	public Link find2(int key) // find link with given key
	{ // (assumes non-empty list)
		Link current = first; // start at 'first'
		while (current != null) {
			if (current.iData == key)
				return current;
			current = current.next; // go to next link
		}
		return current; // found it
	}

//-------------------------------------------------------------O(N)
	public Link delete(int key) // delete link with given key
	{ // (assumes non-empty list)
		Link current = first; // search for link
		Link previous = first;
		while (current.iData != key) {
			if (current.next == null)
				return null; // didn't find it
			else {
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if (current == first) // if first link,
			first = first.next; // change first
		else // otherwise,
			previous.next = current.next; // bypass it
		return current;
	}

	//O(1)
// -------------------------------------------------------------
	public Link deleteFirst() // delete first item
	{ // (assumes list not empty)
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp; // return deleted link
	}

// -------------------------------------------------------------
	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
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
