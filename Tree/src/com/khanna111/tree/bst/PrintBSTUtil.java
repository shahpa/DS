package com.khanna111.tree.bst;

public class PrintBSTUtil {

    public static <Key extends Comparable<Key>, Value> void printAll(Node<Key, Value> node, String prefix) {
	System.out.println(prefix + "_" + node.getKey());
	print(node, prefix);
	

    }
    
    private static <Key extends Comparable<Key>, Value> void print(Node<Key, Value> node, String prefix) {
	Node<Key, Value> left = node.getLeft();
	Node<Key, Value> right = node.getRight();

	String argPrefix = prefix;

	prefix = prefix + " |";
	if (left != null) {
	    System.out.println(prefix + "_" + left.getKey());
	    if (right == null) {
		print(left, argPrefix + "  ");
	    } 
	    else {
		print(left, prefix);
	    }
	}
	if (left == null && right != null) {
	    System.out.println(prefix + "_" + "X");
	}

	if (right != null) {
	    System.out.println(prefix + "_" + right.getKey());
	    print(right, argPrefix + "  ");
	}

    }

    public static void main(String[] args) {
	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
	tree.put(50, "");
	tree.put(20, "");
	tree.put(70, "");
	tree.put(10, "");
	tree.put(30, "");
	tree.put(60, "");
	tree.put(80, "");
	tree.put(6, "");
	tree.put(11, "");
	tree.put(25, "");
	tree.put(35, "");
	tree.put(55, "");
	tree.put(65, "");
	tree.put(3, "");
	tree.put(22, "");
	tree.put(33, "");
	tree.put(36, "");
	tree.put(5, "");
	tree.put(21, "");
	tree.put(23, "");
	tree.put(4, "");

	tree.print();

    }
}
