package pa4;

/**
 * Program: BST.java Author: Joey Maffiola Class: COMPSCI 223 Date: Mar 21, 2023
 */
public class BST {

	protected BSTNode root;
	protected int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BST(int A[]) {
		root = null;
		size = 0;
		for (int a : A)
			insert(a);
	}

	/**
	 * "search" method: searches for a given key in the binary search tree
	 * 
	 * @param key the key
	 * @return the node containing the key, or null if the key is not found
	 */
	public BSTNode search(int key) { // Define the method, taking an integer key argument and returning a BSTNode
		BSTNode tmp = root; // Initialize a new node "tmp" to the root node of the tree
		while (tmp != null) { // Start a loop that runs while tmp is not null (i.e., there are still nodes to be searched)
			if (tmp.value == key) // Check if the value of tmp is equal to the key
				return tmp; // If so, return the node tmp
			else if (tmp.value > key) // If the value of tmp is greater than the key
				tmp = tmp.left; // Traverse the left subtree by setting tmp to tmp's left child
			else
				tmp = tmp.right; // Traverse the right subtree by setting tmp to tmp's right child
		}
		return null; // If the key is not found in the tree, return null
	}

	/*
	 * "insert" method: Inserts a value into the binary search tree if it is not already present
	 * 
	 * @param val the value to be inserted
	 * 
	 * @return the node containing the inserted value, or null if the value is already present
	 */
	public BSTNode insert(int val) { // complete this method
		// Declare BST node to iterate through the tree
		BSTNode currentNode = root; // Initialize tmp to the root node of the tree
		BSTNode parent = null; // Initialize parent to null
		while (currentNode != null) {
			if (currentNode.value == val) {// value is already present in the tree
				return null;
			} else if (val > currentNode.value) { // Traverse right subtree
				parent = currentNode;
				currentNode = currentNode.right;
			} else { // Traverse left subtree
				parent = currentNode;
				currentNode = currentNode.left;
			}
		} // End while loop
			// Gettting here means that the value is not present in the tree
		BSTNode newNode = new BSTNode(val); // Create a new node with the value
		newNode.parent = parent; // Set the parent of the new node to the parent node

		if (parent == null) { // If the parent is null, then the new node is the root
			root = newNode;
		} else if (val > parent.value) { // If the value is greater than the parent's value, then the new node is the right child
			parent.right = newNode;
		} else { // If the value is less than the parent's value, then the new node is the left child
			parent.left = newNode;
		}
		size++; // Increment the size of the tree
		return newNode;
	}

	/**
	 * "remove" method: Removes a value from the binary search tree if it is present
	 * 
	 * @param val the value to be removed
	 * @return true if the value is removed, false if the value is not present
	 */
	public boolean remove(int val) { // complete this method
		BSTNode nodeToBeDeleted = search(val); // Search for the node to be deleted
		if (nodeToBeDeleted == null) // If the node is not found, return false
			return false;

		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) { // the node has two children
			BSTNode maxNode = findMax(nodeToBeDeleted.left); // Find the maximum value node in the left subtree
			nodeToBeDeleted.value = maxNode.value; // Set the value of the node to be deleted to the value of the maximum value node
			nodeToBeDeleted = maxNode; // Set the node to be deleted to the maximum value node
		}

		if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) { // node is a leaf
			removeLeaf(nodeToBeDeleted);
		} else { // node has one child
			removeNodeWithOneChild(nodeToBeDeleted);
		}
		size--;
		return true;
	}

	/**
	 * "removeLeaf" method: This method removes a leaf node from the tree
	 * 
	 * @param leaf the leaf node to be removed
	 */
	private void removeLeaf(BSTNode leaf) { // complete this method
		if (leaf == root) { // leaf is the root
			root = null;
		} else { // leaf is not the root
			BSTNode parent = leaf.parent;
			if (leaf == parent.left) { // leaf is a left child
				parent.left = null;
			} else { // leaf is a right child
				parent.right = null;
			}
			leaf.parent = null; // remove the parent reference
		}
	}

	/**
	 * "removeNodeWithOneChild" method: This method removes a node with one child from the tree
	 * 
	 * @param node the node to be removed
	 */
	private void removeNodeWithOneChild(BSTNode node) { // complete this method
		BSTNode child;
		if (node.left != null) { // node has a left child, so set child to the left child
			child = node.left;
			node.left = null;
		} else { // node has a right child, so set child to the right child
			child = node.right;
			node.right = null;
		}

		if (node == root) { // node is the root, so set the root to the child
			root = child;
			child.parent = null;
		} else { // node is not the root
			// Get parent of node
			BSTNode parent = node.parent;
			// Check if node is a left or right child
			if (node == parent.left) {
				parent.left = child;
			} else {
				parent.right = child;
			}
			child.parent = parent;
			node.parent = null;
		}
	}

	/**
	 * "getPredecessor" method: This method returns the predecessor of a given key. The definition of predecessor is as follows: the
	 * predecessor of a node is the node with the largest value that is smaller than the value of the given node. If the given node
	 * does not have a predecessor, then the method returns -1.
	 * 
	 * @param key the key whose predecessor is to be found
	 * @return the predecessor of the given key
	 */
	public int getPredecessor(int key) { // complete this method
		BSTNode currentNode = root;
		int pred = Integer.MIN_VALUE;

		while (currentNode != null) {
			if (currentNode.value == key) { // value exists in the tree
				return key;
			} else if (currentNode.value < key) { // currentNode is a candidate for being the predecessor;
				pred = currentNode.value;
				// now try to find a better predecessor (i.e., something which is larger than currentNode but still smaller than key)
				currentNode = currentNode.right;
			} else {
				currentNode = currentNode.left;
			}

		}
		return pred;
	}

	/**
	 * "getSuccessor" method: This method returns the successor of a given key. The definition of successor is as follows:
	 * the successor of a node is the node with the smallest value that is larger than the value of the given node. If the given node
	 * does not have a successor, then the method returns -1.
	 * 
	 * @param key the key whose successor is to be found
	 * @return the successor of the given key
	 */
	public int getSuccessor(int key) { // complete this method
		BSTNode currentNode = root;
		int succ = Integer.MAX_VALUE;

		while (currentNode != null) {
			if (currentNode.value == key) {
				return key;
			} else if (currentNode.value > key) { // could be successor
				succ = currentNode.value;
				// Try to find a better successor
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		return succ;
	}

	/**
	 * "nearestNeighbour" method: This method returns the nearest neighbor of a given key. The definition of nearest neighbor is as
	 * follows:
	 * the nearest neighbor of a node is the node with the value that is closest to the value of the given node
	 * (it is either the predecessor or the successor, whichever is closer). If the given node does not have a nearest neighbor, then
	 * the method returns -1.
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public int nearestNeighbour(int key) throws Exception { // complete this method
		// Get pred and succ
		int pred = getPredecessor(key);
		int succ = getSuccessor(key);

		if (pred == Integer.MIN_VALUE) {
			return succ;
		} else if (succ == Integer.MAX_VALUE) {
			return pred;
		} else {
			// return predecessor or successor whichever is closer to key
			if (succ - key <= key - pred) { // Successor is nearest neighbor
				return succ;
			} else { // predecessor is nearest neighbor
				return pred;
			}
		}
	}

	/**
	 * "findMin" method: This method returns the node with the minimum value in the tree
	 * 
	 * @param node the root of the tree
	 * @return the node with the minimum value in the tree
	 */
	private static BSTNode findMin(BSTNode node) {
		if (null == node)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

	/**
	 * "findMax" method: This method returns the node with the maximum value in the tree
	 * 
	 * @param node the root of the tree
	 * @return the node with the maximum value in the tree
	 */
	private static BSTNode findMax(BSTNode node) {
		if (null == node)
			return null;
		while (node.right != null)
			node = node.right;
		return node;
	}

	/**
	 * "getHeight" method: This method returns the height of the tree
	 * 
	 * @param node the root of the tree
	 * @return the height of the tree
	 */
	private static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	/**
	 * "print" method: This method prints the tree
	 * 
	 * @param node the root of the tree
	 */
	private void print(BSTNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	/**
	 * "getHeight" method: This method returns the height of the tree
	 * 
	 * @return the height of the tree
	 */
	public int getHeight() {
		return getHeight(root);
	}

	/**
	 * "print" method: This method prints the tree
	 */
	public void print() {
		print(root);
	}

	/**
	 * "getSize" method: This method returns the size of the tree
	 * 
	 * @return the size of the tree
	 */
	public int getSize() {
		return size;
	}
}
