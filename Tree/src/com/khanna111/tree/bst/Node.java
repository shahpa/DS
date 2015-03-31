package com.khanna111.tree.bst;

public class Node<Key extends Comparable<Key>, Value> {

    private Key key;
    private Value value;
    private Node<Key, Value> left, right;
    
    
    
    public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right) {
	super();
	this.key = key;
	this.value = value;
	this.left = left;
	this.right = right;
    }
    
    public Key getKey() {
        return key;
    }
    
    public Value getValue() {
	return value;
    }
    
    public void setValue(Value value) {
	this.value = value;
    }
    
    public Node<Key, Value> getLeft() {
        return left;
    }
    public Node<Key, Value> getRight() {
        return right;
    }

    public void setLeft(Node<Key, Value> left) {
        this.left = left;
    }

    public void setRight(Node<Key, Value> right) {
        this.right = right;
    }
    
}
