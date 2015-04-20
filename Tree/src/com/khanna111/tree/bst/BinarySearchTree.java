package com.khanna111.tree.bst;

/**
 * 
 * @author khanna
 *
 * @param <Key>
 *            Generic Parameter
 * @param <Value>
 *            Generic Parameter
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
	Node<Key, Value> node = get(root, key);
	return node == null ? null : node.getValue();
    }

    public void put(Key key, Value value) {
	if (key == null) {
	    throw new IllegalArgumentException("Null keys are not supported");
	}
	if (value == null) {
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
	assert key != null;
	if (isEmpty()) {
	    return;
	}
	root = deleteNodeIter(key);
    }

    /**
     * This is a delete using iteration.
     * 
     * @param key
     * @return the root node.
     */
    private Node<Key, Value> deleteNodeIter(Key key) {

	// will use iteration instead of recursion.
	Node<Key, Value> playNode = root;
	Node<Key, Value> parent = root;
	boolean isLeft = false;

	while (true) {
	    if (playNode == null) {
		// reached the end or empty
		// the key does not exist
		return root;
	    }

	    int c = key.compareTo(playNode.getKey());
	    if (c < 0) {
		// go left
		parent = playNode;
		playNode = playNode.getLeft();
		isLeft = true;

	    } else if (c > 0) {
		parent = playNode;
		playNode = playNode.getRight();
		isLeft = false;
	    } else {
		// we have the node and the parent from the the last iteration
		// of this loop
		// Now break out of it.
		break;

	    }
	}

	Node<Key, Value> predParent = null;

	Node<Key, Value> pred = playNode.getLeft();
	// now get pred and its parent
	while (true) {
	    if (pred.getRight() != null) {
		predParent = pred;
		pred = pred.getRight();

	    } else {
		break;
	    }
	}

	if (playNode != parent) {
	    // we are not deleting the root
	    // swap first
	    if (isLeft) {
		parent.setLeft(pred);

	    } else {
		parent.setRight(pred);
	    }
	} else {
	    root = pred;
	}
	// the parent of the pred would have to set the right child since the
	// pred would always be the right child (or the root. The left child of
	// the pred is
	// the value to set as the right child of the parent since the pred - if
	// it has a child - would only have the left one.
	if (predParent != null) {
	    predParent.setRight(pred.getLeft());
	    pred.setLeft(playNode.getLeft());
	    pred.setRight(playNode.getRight());
	}

	return root;
    }


    /********************************
     * min, max
     ********************************/

    public Key getMin() {
	if (isEmpty()) {
	    return null;
	} else
	    return min(root).getKey();

    }

    private Node<Key, Value> min(Node<Key, Value> node) {
	assert node != null;
	Node<Key, Value> left = node.getLeft();
	if (left != null) {
	    return min(left);
	} else {
	    return node;
	}
    }

    public Key getMax() {
	if (isEmpty()) {
	    return null;
	} else
	    return max(root).getKey();
    }

    private Node<Key, Value> max(Node<Key, Value> node) {
	assert node != null;
	Node<Key, Value> right = node.getRight();
	if (right != null) {
	    return max(right);
	} else {
	    return node;
	}
    }

    /********************************
     * pred, succ
     ********************************/

    public Key getPred(Key key) {

	Node<Key, Value> node = get(root, key);
	Node<Key, Value> pred = getPred(node);
	return pred != null ? pred.getKey() : null;

    }

    private Node<Key, Value> getPred(Node<Key, Value> node) {
	if (node == null) {
	    return null;
	}
	Node<Key, Value> left = node.getLeft();
	return left != null ? max(left) : null;

    }

    public Key getSucc(Key key) {

	Node<Key, Value> node = get(root, key);
	Node<Key, Value> succ = getSucc(node);
	return succ != null ? succ.getKey() : null;
    }

    public Node<Key, Value> getSucc(Node<Key, Value> node) {

	if (node == null) {
	    return null;
	}

	Node<Key, Value> right = node.getRight();
	return right != null ? min(right) : null;
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
