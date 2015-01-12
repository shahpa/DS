package com.khanna111.heap;

public abstract class AbstractHeapArray implements HeapI{

    /* We have a max of 64 elements or max height of 6 */
    protected int[] heapAsAnArray; // = new int[64];

    protected int getLeftChildIndex(int parentIndex) {
	/* 2*parentIndex + 1; */
	return 2 * parentIndex + 1;

    }

    protected int getRightChildIndex(int parentIndex) {
	/* 2*parentIndex + 2 */
	return 2 * parentIndex + 2;

    }

    protected int getParentIndex(int childIndex) {
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

    protected abstract void siftDown(int[] heapArray, int nonLeafIndex, int lastLeafIndex);
    
    @Override
    public void heapify(int[] array) {
	createHeap(array);

    }

    
    @Override
    public void insert(int i) {
	// Not implemented. We deal with a pre-existing
	// array.

    }

    @Override
    public int size() {
	return heapAsAnArray.length;
    }

 
    
    @Override
    public void change(int k, int i) {
	// TODO Auto-generated method stub
	
    }
}
