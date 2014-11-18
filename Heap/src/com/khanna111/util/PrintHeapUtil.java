package com.khanna111.util;

/**
 * 
 * @author khanna
 *
 */
public class PrintHeapUtil {

    private static int getLeftChildIndex(int parentIndex) {
	/* 2*parentIndex + 1; */
	return 2 * parentIndex + 1;

    }

    private static int getRightChildIndex(int parentIndex) {
	/* 2*parentIndex + 2 */
	return 2 * parentIndex + 2;

    }

    public static void printHeapAsAnArray(int[] heapArray) {
	assert heapArray.length > 0;
	int rootIndex = 0;
	// System.out.println(rootIndex);
	String prefix = "|__";
	printHeapAsAnArray(heapArray, rootIndex, prefix, false);
	// while ()

    }

    private static void printHeapAsAnArray(int[] heapArray, int rootIndex, String prefix, boolean isLeft) {

	System.out.println(prefix + heapArray[rootIndex]);

	if (getLeftChildIndex(rootIndex) >= heapArray.length - 1) {
	    return;
	}

	prefix = "|  " + prefix;

	printHeapAsAnArray(heapArray, getLeftChildIndex(rootIndex), prefix, true);
	printHeapAsAnArray(heapArray, getRightChildIndex(rootIndex), prefix, false);

    }

    public static void main(String[] args) {

	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8 };
	printHeapAsAnArray(array);
    }

}
