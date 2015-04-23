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
    public int isBalanced(Node<Integer, String> node) {

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
	    return Math.max(lh, rh) + 1;
	}

    }

}
