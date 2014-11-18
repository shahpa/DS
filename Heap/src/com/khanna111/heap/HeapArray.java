package com.khanna111.heap;

import com.khanna111.util.PrintHeapUtil;

/**
 * 
 * @author khanna
 *
 */
public class HeapArray implements HeapI {

    /* We have a max of 64 elements or max height of 6 */
    private int[] heapAsAnArray; // = new int[64];

    private int getLeftChildIndex(int parentIndex) {
	/* 2*parentIndex + 1; */
	return 2 * parentIndex + 1;

    }

    private int getRightChildIndex(int parentIndex) {
	/* 2*parentIndex + 2 */
	return 2 * parentIndex + 2;

    }

    private int getParentIndex(int childIndex) {
	/* floor ((childIndex - 1 ) /2 ) */
	return (childIndex - 1) / 2;
    }

    /**
     * Using Floyd's algorithm
     * 
     * @param array
     *            - broken heap represented as an array
     */
    @Override
    public void createHeap(int[] array) {
	heapAsAnArray = array;
	int count = heapAsAnArray.length;

	// get the last non-leaf element
	int lastNonLeafIndex = (count / 2) - 1;

	// index of the first child of root
	while (lastNonLeafIndex >= 0) {
	    siftDown(heapAsAnArray, lastNonLeafIndex, count - 1);
	    lastNonLeafIndex--;
	}

    }

    private void siftDown(int[] heapArray, int nonLeafIndex, int lastLeafIndex) {
	int rootIndex = nonLeafIndex;
	// intially there is no need to swap till we check the children for a
	// lower value
	int swapIndex = rootIndex;

	// if there is at least one child of the root then loop
	while ((getLeftChildIndex(rootIndex)) <= lastLeafIndex) {

	    // if the left child has a lower value
	    if (heapArray[rootIndex] > heapArray[getLeftChildIndex(rootIndex)]) {
		swapIndex = getLeftChildIndex(rootIndex);
	    }

	    // if there is a right child and that is less than the the left or
	    // the root [that is what the swapIndex points to at this time]
	    if (getRightChildIndex(rootIndex) <= lastLeafIndex && heapArray[swapIndex] > heapArray[getRightChildIndex(rootIndex)]  ) {
		swapIndex = getRightChildIndex(rootIndex);
	    }

	    // if there is no swapping required and that we already are a heap,
	    // we return
	    // Note: we start at the next to last level. If that is a heap then
	    // when we come
	    // from a level above then if we have this condition to be true then
	    // we know that
	    // the children are already setup as a proper heap.
	    if (swapIndex == rootIndex) {
		return;
	    }

	    // do the swapping and housekeeping tp continue the loop
	    int root = heapArray[rootIndex];
	    heapArray[rootIndex] = heapArray[swapIndex];
	    heapArray[swapIndex] = root;
	    rootIndex = swapIndex;
	}
    }

    @Override
    public void heapify() {
	// TODO Auto-generated method stub

    }

    @Override
    public int findMin() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void insert(int i) {
	// TODO Auto-generated method stub

    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return 0;
    }

    public static void main(String[] args) {

	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8 };
	HeapArray hArr = new HeapArray();
	hArr.createHeap(array);
	PrintHeapUtil.printHeapAsAnArray(hArr.heapAsAnArray);

    }
}
