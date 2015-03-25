package com.khanna111.heap;

import com.khanna111.util.PrintHeapUtil;

public class HeapSort {

    
    /**
     * Returns the same array. There is no extra space requirements to
     * store the sorted array.
     * 
     * The returned array is in ascending order.
     *
     * @param array
     * @return
     */
    public int[] heapSortAsc(int[] array) {
//	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8 };
 	MaxHeapArray hArr = new MaxHeapArray();
 	hArr.heapify(array);
 	
 	// time to sort
 	// the root is the maximum element.
 	int length = array.length;
 	while (length > 1) {
 	    swap (hArr.heapAsAnArray, 0, length -1);
 	    
 	    hArr.siftDown(hArr.heapAsAnArray, 0, --length-1);
 	}
 	
 	
 	return array;
    }
    
    /**
     * XOR based swap.
     * 
     * @param array
     * @param i1
     * @param i2
     */
    private void swap(int[] array, int i1, int i2) {
	int top = array[i1];
	int last = array[i2];
	top = top ^ last;
	last = top ^ last;
	top = top ^ last;
	array[i1] = top;
	array[i2] = last;
    }
    
    /**
     * Returns the same array. There is no extra space requirements to
     * store the sorted array.
     * 
     * The returned array is in descending order.
     *
     * @param array
     * @return
     */
    public int[] heapSortDesc(int[] array) {
 	MinHeapArray hArr = new MinHeapArray();
 	hArr.heapify(array);
 	
 	// time to sort
 	// the root is the maximum element.
 	int length = array.length;
 	while (length > 1) {
 	    swap (hArr.heapAsAnArray, 0, length -1);
 	    
 	    hArr.siftDown(hArr.heapAsAnArray, 0, --length-1);
 	}
 	
 	
 	
 	return array;
    }
    
    public static void main(String[] args) {
	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8, -1 };
	HeapSort hS = new HeapSort();
	
	PrintHeapUtil.printIntArray(array);
	
	System.out.println ("\n\nPrinting in Ascending Order");
	int ret[] = hS.heapSortAsc(array);
	PrintHeapUtil.printIntArray(ret);
	PrintHeapUtil.printHeapAsAnArray(ret);
	 
	System.out.println ("\n\n");
	
	System.out.println ("Printing in Descending Order");
	ret = hS.heapSortDesc(array);
	PrintHeapUtil.printIntArray(ret);
	PrintHeapUtil.printHeapAsAnArray(ret);
	 
	
	
    }
    
}
