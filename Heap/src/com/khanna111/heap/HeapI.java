package com.khanna111.heap;

public interface HeapI {

    public void createHeap(int[] array);

    public void heapify(int[] array);

    /**
     * Returns the minimum or maximum but does not remove it.
     *
     * @return
     */
    public int findTop();

    /**
     * Returns the minimum or maximum and removes it as well.
     * 
     * @return
     */
    public int delTop();

    /**
     * Inserts at the end.
     * 
     * @param i
     */
    public void insert(int i);
    
    /**
     * Replaces element at index k.
     * 
     * @param k
     * @param i
     */
    public void change(int k, int i);

    public int size();

}
