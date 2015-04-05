package com.khanna111.tree.bst;

/**
 * 
 * @author khanna
 *
 * @param <Key>
 *            Generic Parameter
 * @param <Value>
 *            Genric Parameter
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public boolean contains(Key key) {
	return get(key) == null ? false : true;
    }
    
    public boolean isEmpty() {
	return root == null ? true : false; 
    }

    /******************************
     * Get and Put
     ******************************/

    public Value get(Key key) {
	return get(root, key) == null ? null : get(root, key).getValue();
    }

    public void put(Key key, Value value) {
	if (key == null) {
	    delete(key);
	} else {
	    root = put(root, key, value);
	}
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {

	if (node == null) {
	    // reached the end or empty
	    return new Node<>(key, value, null, null);
	}

	int c = key.compareTo(node.getKey());
	if (c < 0) {
	    // go left and specify or re-specify the left tree
	    node.setLeft(put(node.getLeft(), key, value));

	} else if (c > 0) {
	    node.setRight(put(node.getRight(), key, value));
	} else {
	    node.setValue(value);
	}
	return node;

    }

    private Node<Key, Value> get(Node<Key, Value> node, Key key) {

	if (node == null) {
	    // reached the end or empty
	    return null;
	}

	int c = key.compareTo(node.getKey());
	if (c < 0) {
	    // go left
	    return get(node.getLeft(), key);

	} else if (c > 0) {
	    return get(node.getRight(), key);
	} else {
	    return node;
	}

    }

    /******************************
     * Delete
     ******************************/

    public void deleteMin() {

    }

    public void deleteMax() {

    }

    public void delete(Key key) {

    }

    /********************************
     * min, max
     ********************************/

    public Key getMin() {
	if (isEmpty()) {
	    return null;
	}
	else return min(root).getKey();
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
	assert node != null;
	Node<Key, Value> left = node.getLeft();
	if (left != null) {
	    return min(left);
	}
	else{
	    return left;
	}
    }
    
    public Key getMax() {
	if (isEmpty()) {
	    return null;
	}
	else return max(root).getKey();
    }
    
    private Node<Key, Value> max(Node<Key, Value> node) {
	assert node != null;
	Node<Key, Value> right = node.getRight();
	if (right != null) {
	    return min(right);
	}
	else{
	    return right;
	}
    }
    /********************************
     * pred, succ
     ********************************/

    public Key getPred(Key key) {
	return null;
    }

    public Key getSucc(Key key) {
	return null;
    }

    /********************************
     * rank, selection
     ********************************/

    public int rank(Key key) {
	return -1;
    }

    public Key select(int i) {
	return null;
    }

    /***********************************
     * Range count and range search.
     ************************************/
    public Iterable<Key> keys() {
	return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
	return null;
    }

    /***********************************
     * inorder.
     ************************************/

    public void print() {
	PrintBSTUtil.printAll(root, "");
    }
}
