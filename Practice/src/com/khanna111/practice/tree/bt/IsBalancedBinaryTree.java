package com.khanna111.practice.tree.bt;

import com.khanna111.tree.bst.BinarySearchTree;
import com.khanna111.tree.bst.Node;

/**
 * A balanced binary tree is a binary tree where:
 * 
 * the heights of two subtrees of every node is never more than one.
 * 
 * Height of a node is the number of edges to the farthest leaf from that node.
 * 
 * Therefore the above definition can be restated as:
 * 
 * |height-from-left-of-node - height-from-right-of-node| < 2
 * 
 * 
 * @author khanna
 *
 */
public class IsBalancedBinaryTree {

    /**
     * if return is "-1" then the tree is height unbalanced else balanced.
     * 
     * @param node
     * @return
     */
    private int isBalanced(Node<Integer, String> node) {

	if (node == null) {
	    // we traverse to the end and count up.
	    return 0;
	}
	Node<Integer, String> left = node.getLeft();
	Node<Integer, String> right = node.getRight();

	int lh = isBalanced(left);
	if (lh == -1) {
	    // return since we know the answer
	    return -1;
	}

	int rh = isBalanced(right);
	if (lh == -1) {
	    // return since we know the answer
	    return -1;
	}

	int h = Math.abs(lh - rh);
	if (h > 1) {
	    return -1;
	} else {
	    return Math.max(lh,rh) + 1;
	}

    }
    
    public static void main(String[] args) {
	IsBalancedBinaryTree b = new IsBalancedBinaryTree();
	
	// we will use BST instead of a regular binary tree
	BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
	tree.put(50, "");
	tree.put(20, "");
	tree.put(70, "");
	tree.put(10, "");
	tree.put(30, "");
	tree.put(60, "");
	tree.put(80, "");
	tree.put(6, "");
//	tree.put(11, "");
//	tree.put(25, "");
//	tree.put(35, "");
//	tree.put(55, "");
//	tree.put(65, "");
//	tree.put(3, "");
//	tree.put(22, "");
//	tree.put(33, "");
//	tree.put(36, "");
//	tree.put(5, "");
//	tree.put(21, "");
//	tree.put(23, "");
//	tree.put(4, "");
//	tree.put(24, "");
//	tree.put(85, "");
//	tree.put(79, "");
	
	tree.print();
	
	
	int isBalanced = b.isBalanced(tree.getRoot());
	System.out.println("Tree is balanced : " + (isBalanced == -1 ? false : true));
	
	tree.put(3, "");
//	tree.put(22, "");
//	tree.put(33, "");
//	tree.put(36, "");
	tree.put(5, "");
//	tree.put(21, "");
//	tree.put(23, "");
//	tree.put(4, "");
//	tree.put(24, "");
//	tree.put(85, "");
//	tree.put(79, "");
	
	tree.print();
	
	isBalanced = b.isBalanced(tree.getRoot());
	System.out.println("Tree is balanced : " + (isBalanced == -1 ? false : true));

	
    }

}
