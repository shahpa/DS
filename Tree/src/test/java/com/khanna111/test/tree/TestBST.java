package com.khanna111.test.tree;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.khanna111.tree.bst.BinarySearchTree;

public class TestBST {
    @BeforeClass
    public void setUp() {
	// code that will be invoked when this test is instantiated
    }

    @Test(groups = { "tree" })
    public void isEmpty() {
	BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
	assertEquals(bst.isEmpty(), true);
	bst.put(50, "fifty");
	assertEquals(bst.isEmpty(), false);
	assertEquals(bst.get(50), "fifty");
    }

    @Test(groups = { "tree" })
    public void get1() {
	BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
	bst.put(50, "fifty");
	assertEquals(bst.isEmpty(), false);
	assertEquals(bst.get(50), "fifty");

    }

    @Test(groups = { "tree" })
    public void minAndMax() {
	BinarySearchTree<Integer, String> tree = getHugeBST();

	assertEquals((int) tree.getMin(), 3);
	assertEquals((int) tree.getMax(), 85);

    }

    @Test(groups = { "tree" })
    public void predAndSucc() {
	BinarySearchTree<Integer, String> tree = getHugeBST();

	assertEquals((int) tree.getPred(50), 36);
	assertEquals((int) tree.getSucc(50), 55);
	
	assertEquals((int) tree.getPred(20), 11);
	assertEquals((int) tree.getSucc(20), 21);
	
	assertEquals((Integer) tree.getPred(3), null);
	assertEquals((int) tree.getSucc(3), 4);

	assertEquals((int) tree.getPred(30), 25);
	assertEquals((int) tree.getSucc(30), 33);

	
	assertEquals((int) tree.getPred(70), 65);
	assertEquals((int) tree.getSucc(70), 79);
    }

    
    private BinarySearchTree<Integer, String> getHugeBST() {
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
	tree.put(24, "");
	tree.put(85, "");
	tree.put(79, "");

	return tree;
    }
}
