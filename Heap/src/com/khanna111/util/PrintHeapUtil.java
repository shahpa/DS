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
	String prefix = "";
	printHeapAsAnArray(heapArray, rootIndex, prefix, false);
	// while ()

    }

    private static void printHeapAsAnArray(int[] heapArray, int rootIndex, String prefix, boolean isRight) {

	if (rootIndex > heapArray.length -1){
	    return;
	}
	
	System.out.println(prefix + "__"  + heapArray[rootIndex]);
	
	String prefix1 = null;
	
	if (isRight) {
	    // if the parent was the right node then we need to remove the last "|" since 
	    // there are no more children to the parent.
	    prefix = prefix.substring(0, prefix.length() -1) + " "; 
	}
	
	prefix1 = prefix + "  |" ;
	    
	
	printHeapAsAnArray(heapArray, getLeftChildIndex(rootIndex), prefix1, false);
	printHeapAsAnArray(heapArray, getRightChildIndex(rootIndex), prefix1, true);

    }

    public static void main(String[] args) {

	int[] array = { 4, 5, 6, 1, 3, 7, 9, 2, 8, 12, 13, 14, 15, 17, 20, 23 };
	printHeapAsAnArray(array);
    }

}
