package com.khanna111.test.practice.tree.bt;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.khanna111.practice.tree.bt.IsBalancedBinaryTree;
import com.khanna111.tree.bst.BinarySearchTree;

public class TestIsBalancedBinaryTree {

    @BeforeClass
    public void setUp() {
	// code that will be invoked when this test is instantiated
    }

    @Test(groups = { "practice" })
    public void isValid1() {

	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
	tree.put(50, "");
	tree.put(20, "");
	tree.put(70, "");
	tree.put(10, "");
	tree.put(30, "");
	tree.put(60, "");
	tree.put(80, "");
	tree.put(6, "");

	tree.print();

	IsBalancedBinaryTree b = new IsBalancedBinaryTree();
	assertNotEquals(b.isBalanced(tree.getRoot()), -1);

    }

    @Test(groups = { "practice" })
    public void isInValid1() {

	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
	tree.put(50, "");
	tree.put(20, "");
	tree.put(70, "");
	tree.put(10, "");
	tree.put(30, "");
	tree.put(60, "");
	tree.put(80, "");
	tree.put(6, "");
	tree.put(3, "");
	tree.put(5, "");

	tree.print();

	IsBalancedBinaryTree b = new IsBalancedBinaryTree();

	assertEquals(b.isBalanced(tree.getRoot()), -1);

    }
}
