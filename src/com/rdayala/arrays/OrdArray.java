package com.rdayala.arrays;

public class OrdArray {

	private long[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------
	public OrdArray(int max) // constructor
	{
		a = new long[max]; // create array
		nElems = 0;
	}

	// -----------------------------------------------------------
	public int size() {
		return nElems;
	}

	// -----------------------------------------------------------
	// since, it's an ordered array, we can use BinarySearch here to find
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		
		while (lowerBound <= upperBound) {
			int middle = (lowerBound + upperBound) / 2;
			if (a[middle] == searchKey)
				return middle; // found it		
			else // divide range
			{
				if (searchKey < a[middle] )
					upperBound = middle - 1; // it�s in lower half
				else
					lowerBound = middle + 1; // it�s in upper half
			} // end else divide range
		} // end while
		
		return -1;
	} // end find()
		// -----------------------------------------------------------

	public void insert(long value) // put element into array
	{
		int j;
		for (j = 0; j < nElems; j++) // find where it goes
			if (a[j] > value) // (linear search)
				break;
		for (int k = nElems; k > j; k--) // move bigger ones up
			a[k] = a[k - 1];
		a[j] = value; // insert it
		nElems++; // increment size
	} // end insert()
		// -----------------------------------------------------------

	public boolean delete(long value) {
		int j = find(value);
		if (j == -1) // can�t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move bigger ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	// -----------------------------------------------------------

	public static void main(String[] args) {

		int maxSize = 100; // array size
		OrdArray arr; // reference to array

		arr = new OrdArray(maxSize); // create the array
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
		
		arr.display();
		
		int searchKey = 55; // search for item
		if (arr.find(searchKey) != -1)
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can�t find " + searchKey);
		
		arr.display(); // display items
		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);
		arr.display(); // display items again
	}

}
