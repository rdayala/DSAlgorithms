package com.rdayala.arrays;

import java.util.NoSuchElementException;

public class MyDynamicArray<T> {
	private static final int DEFAULT_ARRAY_SIZE = 10;

	private int currentPosition = 0;
	private int arraySize;
	private T[] dynamicArray;

	public MyDynamicArray() {
		this(DEFAULT_ARRAY_SIZE);
	}

	@SuppressWarnings("unchecked")
	public MyDynamicArray(int arraySize) {
		this.arraySize = arraySize;
		dynamicArray = (T[]) new Object[arraySize];
	}

	public void addElement(T element) {
		adjustSize();
		dynamicArray[currentPosition] = element;
		currentPosition++;
	}

	public void addElementAtNode(int index, T element) {
		if (index < currentPosition) {
			dynamicArray[index] = element;
		} else {
			addElement(element);
			
//			throw new ArrayIndexOutOfBoundsException("index " + index + " is greater than the size of array "
//					+ (currentPosition - 1) + " \nElement added to end of array..");
		}
	}

	private void adjustSize() {
		if (currentPosition == arraySize) {
			increaseSize();
		} 
//		else if (position == (arraySize / 4 - 1)) {
//			decreaseSize();
//		}
	}

	@SuppressWarnings("unchecked")
	private void increaseSize() {
		T[] tempArray = (T[]) new Object[2 * arraySize];
		for (int i = 0; i < currentPosition; i++) {
			tempArray[i] = dynamicArray[i];
		}
		dynamicArray = tempArray;
		arraySize = 2 * arraySize;
	}

//	@SuppressWarnings("unchecked")
//	private void decreaseSize() {
//		T[] tempArray = (T[]) new Object[(arraySize / 4)];
//		for (int i = 0; i < position; i++) {
//			tempArray[i] = dynamicArray[i];
//		}
//		dynamicArray = tempArray;
//		arraySize = arraySize / 4;
//	}

	public int searchElement(T element) {
		for (int i = 0; i < currentPosition; i++) {
			if (dynamicArray[i].equals(element)) {
				return i;
			}
		}
		throw new NoSuchElementException("Element not found : " + element.toString());
	}

	public T getElementAtIndex(int index) {
		if (index < currentPosition) {
			return dynamicArray[index];
		} else {
			throw new ArrayIndexOutOfBoundsException("index " + index + " is greater than the size of array " + currentPosition);
		}
	}

	public void removeElement(T element) {
		int index = searchElement(element);
		if (index > 0) {
			removeElementAtIndex(index);
		}
	}

	public void removeElementAtIndex(int index) {
		if (index < currentPosition) {
			for (int i = index; i < currentPosition - 1; i++) {
				dynamicArray[index] = dynamicArray[index + 1];
			}
			dynamicArray[currentPosition - 1] = null;
			currentPosition--;
			adjustSize();
		} else {
			throw new ArrayIndexOutOfBoundsException("index " + index + " is greater than the size of array " + currentPosition);
		}
	}

	public int size() {
		return currentPosition;
	}

}
