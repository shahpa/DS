package com.khanna111.util;

import java.util.List;

/**
 * Helper methods.
 * 
 * @author khanna
 *
 */
public class PrintUtil {

    
    public static <T>  void printList(List<T> list) {
	System.out.println("Printing List");
	for (T o : list) {
	    System.out.println("    " + o.toString());
	}
    }
    
    public static <T>  void printIterable(Iterable<T> i) {
	System.out.println("Printing Iterable");
	for (T o : i) {
	    System.out.println("    " + o.toString());
	}
    }
    
    public static <T>  void printArray(T[] array) {
	System.out.println("Printing Array");
	for (T o : array) {
	    System.out.println("    " + o.toString());
	}
    }
    
    /**
     * Prints an primitive <code>int</code> array.
     * 
     * Note that this cannot be made generic since 
     * it would be erased into Object and that primitive <code>ints'</code>
     * do not extend Object. For instance if we invoke {@link Object#toString()}
     * on a primitive <code>int</code>: this cannot be allowed to happen.
     * 
     * @param array
     */
    public static void printIntArray(int[] array) {
	System.out.println("Printing Array");
	for (int o : array) {
	    System.out.println("    " + o);
	}
    }
}

