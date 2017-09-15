package com.rdayala.queue;

// Queue implementation with wrap around items.
// kind of circular queue

public class CircularQueueX {

	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// --------------------------------------------------------------
	public CircularQueueX(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void insert(long j) throws Exception // put item at rear of queue
	{

		if (!isFull()) {
			if (rear == maxSize - 1) // deal with wrap around
				rear = -1;
		
			queArray[++rear] = j; // increment rear and insert
			nItems++; // one more item
		}
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wrap around
			front = 0;
		nItems--; // one less item
		return temp;
	}

	// --------------------------------------------------------------
	public long peekFront() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------
	public int size() // number of items in queue
	{
		return nItems;
	}
	// --------------------------------------------------------------

	public static void main(String[] args) throws Exception {

		// queue holds 5 items
		CircularQueueX theQueue = new CircularQueueX(5);

		theQueue.insert(10); // insert 4 items
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);

		 theQueue.remove(); // remove 3 items
		 theQueue.remove(); // (10, 20, 30)
		 theQueue.remove();

		theQueue.insert(50); // insert 4 more items
		theQueue.insert(60); // (wraps around)
		theQueue.insert(70);
		theQueue.insert(80);

		// remove and display
		while (!theQueue.isEmpty()) {
			// all items
			long n = theQueue.remove(); // (40, 50, 60, 70, 80)
			System.out.print(n);
			System.out.print(" ");

		}

		System.out.println("");
	}

}
