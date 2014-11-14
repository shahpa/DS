package com.khanna111.heap;

/**
 * 
 * @author khanna
 *
 */
public class HeapArray implements HeapI {

    /* We have a max of 64 elements or max height of 6 */
    private int[] heapAsAnArray; //= new int[64];
    
    private int getLeftChildIndex(int parentIndex) {
	/* 2*parentIndex + 1; */
//	return 2*parentIndex + 1;
	return parentIndex << 1 + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
	/* 2*parentIndex + 2 */
//	return 2*parentIndex + 2;
	return parentIndex << 1 + 2;
	
    }
    
    private int getParentIndex (int childIndex) {
	/* floor ((childIndex - 1 ) /2 ) */
	return (childIndex -1 ) / 2;
    }
    
    /**
     * Using Floyd's algorithm
     * 
     * @param array - broken heap represented as an array
     */
    @Override
    public void createHeap(int[] array) {
	heapAsAnArray = array;
	int count = heapAsAnArray.length;
	
	// get the last non-leaf element
	int lastNonLeafIndex = (count / 2)  -1;
	
	// index of the first child of root
	while (lastNonLeafIndex >=0) {
	    siftDown(heapAsAnArray, lastNonLeafIndex, count -1);
	    lastNonLeafIndex--;
	}
	
	
    }

    private void siftDown(int[] heapArray, int lastNonLeafIndex, int lastLeaf) {
	
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

    
    
}
