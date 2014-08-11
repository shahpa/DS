package com.khanna111.util;

import java.util.List;

public class PrintUtil {

    
    public static <T>  void printList(List<T> list) {
	System.out.println("Printing List");
	for (T o : list) {
	    System.out.println("    " + o.toString());
	}
    }
}
