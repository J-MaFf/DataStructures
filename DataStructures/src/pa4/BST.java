package pa4;

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
		BSTNode tmp = root;
		while (tmp != null) {
			if (tmp.value == key)
				return tmp;
			else if (tmp.value > key)
				tmp = tmp.left;
			else
				tmp = tmp.right;
		}
		return null;
	}

	public BSTNode insert(int val) { // complete this method
	}

	public boolean remove(int val) { // complete this method
	}

	private void removeLeaf(BSTNode leaf) { // complete this method
	}

	private void removeNodeWithOneChild(BSTNode node) { // complete this method
	}

	public int getPredecessor(int key) { // complete this method
	}

	public int getSuccessor(int key) { // complete this method
	}

	public int nearestNeighbour(int key) throws Exception { // complete this method
	}

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
