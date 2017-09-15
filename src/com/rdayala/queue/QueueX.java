package com.rdayala.queue;

// Simple Queue implementation using Array without error handling :
// when the Queue is full and u trying to insert items or
// when the Queue is empty and u trying to remove items

public class QueueX {

	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// --------------------------------------------------------------
	public QueueX(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		queArray[++rear] = j; // increment rear and insert
		nItems++; // one more item
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp = queArray[front++]; // get value and incr front
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

	public static void main(String[] args) {
		
		// queue holds 5 items
		QueueX theQueue = new QueueX(5);
		
		theQueue.insert(10); // insert 4 items
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		
		System.out.println("Queue Peek element : " + theQueue.peekFront());
		
		// remove and display
		while (!theQueue.isEmpty())
		{ 
			// all items
			long n = theQueue.remove(); // (10, 20, 30, 40)
			System.out.print(n);
			System.out.print(" ");
		}
		
		System.out.println("");

	}

}
