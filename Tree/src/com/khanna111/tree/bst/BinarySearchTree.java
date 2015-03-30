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
	return false;
    }

    public Value get(Key key) {
	return null;
    }

    public void put(Key key, Value value) {
	if (key == null) {
	    delete(key);
	}
	else {
	    root = put (root, key, value);
	}
    }
    
    

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {

	int c = key.compareTo(node.getKey());
	if (c < 0) {
	    node = node.getLeft();
	}
	else if (c > 0) {
	    node = node.getRight();
	}
	else {
	    node.setValue(value);
	}
	return null;
    }

    /******************************
     * Delete
     ******************************/

    public void deleteMin() {
	
    }
    
    public void deleteMax() {
	
    }
    
    public void delete(Key key){
	
    }
    
    /********************************
     * min, max, pred, succ
     ********************************/
     
    public Key getMin() {
	return null;
    }
    
    public Key getMax() {
	return null;
    }
    
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
     *  Range count and range search.
     ************************************/
     public Iterable<Key> keys() {
         return null;
     }

     public Iterable<Key> keys(Key lo, Key hi) {
         return null;
     } 
     
     /***********************************
      *  inorder.
      ************************************/
}
