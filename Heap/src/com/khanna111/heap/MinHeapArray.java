package com.khanna111.heap;

import com.khanna111.util.PrintHeapUtil;

/**
 * Implementation of a MinHeap.
 * 
 * @author khanna
 *
 */
public class MinHeapArray extends AbstractHeapArray {

  
    @Override
    protected final void siftDown(int[] heapArray, int nonLeafIndex, int lastLeafIndex) {
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

    /**
     * Returns the min.
     * 
     */
    @Override
    public int findTop() {
	return heapAsAnArray[0];
    }

    
    @Override
    public int delTop() {
	int min = heapAsAnArray[0];
	int last = heapAsAnArray[size() -1];
	heapAsAnArray[0] = last;
	heapAsAnArray[size() -1] = Integer.MAX_VALUE;
	siftDown(heapAsAnArray, 0, size() -1);
	return min;
	
    }

    
    
    public static void main(String[] args) {

 	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8 };
 	MinHeapArray hArr = new MinHeapArray();
 	hArr.createHeap(array);
 	PrintHeapUtil.printHeapAsAnArray(hArr.heapAsAnArray);
 	
 	int min = hArr.delTop();
 	System.out.println("Min:" + min + "\t: The heapArray is: " );
 	PrintHeapUtil.printHeapAsAnArray(hArr.heapAsAnArray);
 	

     }

}
