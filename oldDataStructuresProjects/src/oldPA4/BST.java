package oldPA4;

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

	public BSTNode search(int key) {
		// Assign a temporary variable tmp to the root
		BSTNode tmp = root;
		// while tmp is not null, repeat the following:
		while (tmp != null) {
			// if value of tmp equals key then return tmp
			if (tmp.value == key)
				return tmp;
			// else if value of tmp < key, move tmp to tmp’s right child
			else if (tmp.value > key)
				tmp = tmp.left;
			// else move tmp to tmp’s left child
			else
				tmp = tmp.right;
		}
		return null;
	}

	public BSTNode insert(int val) { // complete this method
		// if size is 0, then allocate memory for the root (via a constructor call to the BSTNode class), increment size, and return the
		// root.
		if (size == 0) {
			root = new BSTNode(val);
			size++;
			return root;
		} // end if

		// Assign a temporary variable tmp to the root
		BSTNode tmp = root;
		// assign temporary var parent to null
		BSTNode parent = null;
		// while tmp is not null, repeat the following:
		while (tmp != null) {
			// if value of tmp equals val then return null (indicating no node was created)
			if (tmp.value == val) {
				return null; // no node created
			}
			// else if value of tmp < val, set parent to tmp and move tmp to tmp’s right child
			else if (tmp.value < val) {
				parent = tmp;
				tmp = tmp.right;
			}
			// else set parent to tmp and move tmp to tmp’s left child
			else {
				parent = tmp;
				tmp = tmp.left;
			} // end if / else if / else
		} // end while
			// Create a new BSTNode, named newNode with value val.
		BSTNode newNode = new BSTNode(val);
		// Assign newNode′s parent field to the local variable parent.
		newNode.parent = parent;
		// If parent’s value is larger than val, then newNode is the left child of parent,
		if (parent.value > val) {
			parent.left = newNode;
		}
		// else newNode is the right child of parent.
		else {
			parent.right = newNode;
		}
		// Increment size and return newNode.
		size++;
		return newNode;
	} // end method insert

	public boolean remove(int val) { // complete this method
		// Find the node to be deleted, say nodeToBeDeleted, by calling search with val
		BSTNode nodeToBeDeleted = search(val);
		// if nodeToBeDeleted is null, there’s nothing to be deleted; so, return false
		if (nodeToBeDeleted == null) {
			return false;
		}

		// if nodeToBeDeleted has a left child and a right child, then do the following:
		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) {
			// find the node having the maximum value in nodeToBeDeleted’s left subtree
			BSTNode max = findMax(nodeToBeDeleted.left);
			// set nodeToBeDeleted’s value to the maximum node’s value
			nodeToBeDeleted.value = max.value;
			// set nodeToBeDeleted to the maximum node
			nodeToBeDeleted = max;
		} // end if
			// if nodeToBeDeleted is a leaf, call removeLeaf with nodeToBeDeleted as argument
		if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
			removeLeaf(nodeToBeDeleted);
		} // else call removeNodeWithOneChild with nodeToBeDeleted as argument
		else {
			removeNodeWithOneChild(nodeToBeDeleted);
		} // end if / else
			// decrement size and return true
		size--;
		return true;

	}

	private void removeLeaf(BSTNode leaf) { // complete this method
		// if leaf is the same as root, then
		if (leaf == root) { 
			// set root to null
			root = null;
		} // else, do the following:
		else {
			// Assign a temporary variable parent to leaf ’s parent
			BSTNode tempParent = leaf.parent;
			// if leaf is a left child, then set parent’s left to null
			if (tempParent.left == leaf) {
				leaf.parent.left = null;
			} else {
				// else set parent’s right to null
				leaf.parent.right = null;
			} // end if / else
				// set leaf ’s parent to null
			leaf.parent = null;
		} // end if / else

	} // end removeLeaf

	private void removeNodeWithOneChild(BSTNode node) { // complete this method
		// declare a temporary variable child (of type BSTNode)
		BSTNode child;
		// if node has a left child
		if (node.left != null) {
			// set child to node’s left and set node’s left to null
			child = node.left;
			node.left = null;
		} // else, do the following
		else {
			// set child to node’s right and set node’s right to null
			child = node.right;
			node.right = null;
		} // end if / else
			// if node is the same as root, then
		if (node == root) {
			// set root to child and set child’s parent to null
			root = child;
			child.parent = null;
		} // else, do the following
		else {
			// if node is a left child then
			if (node.parent.left == node) { // maybe
				// set node’s parent’s left to child,
				node.parent.left = child;
			} else { // else set node’s parent’s right to child
				node.parent.right = child;
			} // end if / else
			child.parent = node.parent;
			node.parent = null;
		} // end if / else
	} // end method removeNodeWithOneChild

	public int getPredecessor(int key) { // complete this method
		// Assign a temporary variable tmp to the root of BST
		BSTNode tmp = root;
		// Assign an integer variable pred to −∞ (use Integer.MINVALUE in Java
		int pred = Integer.MIN_VALUE;
		// while tmp is not null, repeat the following
		while (tmp != null) {
			// if value of tmp equals key then tmp is the predecessor; so, return key
			if (tmp.value == key) {
				return key;
			} // else if value of tmp < key, then tmp is a candidate for being the predecessor; so, do the following:
			else if (tmp.value < key) {
				// store tmp’s value as a predecessor candidate by setting pred to tmp’s value
				pred = tmp.value;
				// now you want to get a better predecessor (i.e., something which is larger than tmp but still smaller than key); so, set tmp to
				// the right node of tmp
				tmp = tmp.right;
			} // else set tmp to the left node of tmp
			else {
				tmp = tmp.left;
			} // end if / else if / else
		} // end while
		return pred;
	} // end method getPredecessor

	public int getSuccessor(int key) { // complete this method
		// Assign a temporary variable tmp to the root of BST
		BSTNode tmp = root;
		// Assign an integer variable succ to +∞ (use Integer.MAX_VALUE in Java
		int succ = Integer.MAX_VALUE;
		while (tmp != null) {
			// if value of tmp equals key then tmp is the successor; so, return key
			if (tmp.value == key) {
				return key;
			} // else if value of tmp > key, then tmp is a candidate for being the successor; so, do the following:
			else if (tmp.value > key) { // The variable succ will be modified when key is smaller than tmp’s value
				// store tmp’s value as a successor candidate by setting succ to tmp’s value
				succ = tmp.value;
				// now you want to get a better successor (i.e., something which is smaller than tmp but still larger than key); so, set tmp to
				// the left node of tmp
				tmp = tmp.left;
			} // else set tmp to the right node of tmp
			else {
				tmp = tmp.right;
			} // end if / else if / else
		} // end while
		return succ;
	}// end getSuccessor

	public int nearestNeighbour(int key) throws Exception { // complete this method
		// Find the predecessor and the successor of key
		int pred = getPredecessor(key);
		int succ = getSuccessor(key);
		// If predecessor is −∞, then return successor as the nearest neighbor
		if (pred == Integer.MIN_VALUE) {
			return succ;
		} // Else If successor is ∞, then return predecessor as the nearest neighbor
		else if (succ == Integer.MAX_VALUE) {
			return pred;
		} // Else return predecessor or successor whichever is closer to key
		else {
			int predDifference = key - pred;
			int succDifference = succ - key;
			if (predDifference < succDifference) {
				return pred;
			} else {
				return succ;
			} // end if / else
		} // end if / else if / else
	} // end nearestNeighbour

	private static BSTNode findMin(BSTNode node) {
		if (null == node)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static BSTNode findMax(BSTNode node) {
		if (null == node)
			return null;
		while (node.right != null)
			node = node.right;
		return node;
	}

	private static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private void print(BSTNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	public void print() {
		print(root);
	}

	public int getSize() {
		return size;
	}
}
