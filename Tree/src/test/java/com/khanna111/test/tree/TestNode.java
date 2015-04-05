package com.khanna111.test.tree;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.khanna111.tree.bst.Node;

public class TestNode {
    @BeforeClass
    public void setUp() {
	// code that will be invoked when this test is instantiated
    }

    @Test(groups = { "tree" })
    public void singleNode() {
	Node<Integer, String> node = new Node<>(50, "fifty", null, null);
	assertEquals(node.getLeft(), null);
	assertEquals(node.getRight(), null);
	assertEquals((int) node.getKey(), 50);
	assertEquals(node.getValue(), "fifty");

    }

    @Test(groups = { "tree" })
    public void multiNode() {
	Node<Integer, String> left = new Node<>(20, "twenty", null, null);
	Node<Integer, String> right = new Node<>(70, "seventy", null, null);
	
	Node<Integer, String> node = new Node<>(50, "fifty", left, right);
	assertEquals(node.getLeft(), left);
	assertEquals(node.getRight(), right);
	
	
    }

}
