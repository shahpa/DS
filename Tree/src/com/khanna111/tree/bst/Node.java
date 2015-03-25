package com.khanna111.tree.bst;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> left, right;
    
    
    
    public Node(T data, Node<T> left, Node<T> right) {
	super();
	this.data = data;
	this.left = left;
	this.right = right;
    }
    
    public T getData() {
        return data;
    }
    public Node<T> getLeft() {
        return left;
    }
    public Node<T> getRight() {
        return right;
    }
    
       
    
    
}
