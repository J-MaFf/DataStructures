package oldPA5;


public class TreeTraversals {

	public static void preOrder(BinaryTreeNode node) { // complete this method
		// print the value in the node, followed by a space (use a space and not a newline to get the desired format).
		System.out.print(node.value + " ");
		// if the node has a left child, then recursively carry out a pre-order traversal starting from node’s left child
		if (node.left != null) {
			preOrder(node.left);
		}
		// if the node has a right child, then recursively carry out a pre-order traversal starting from node’s right child
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	public static void inOrder(BinaryTreeNode node) { // complete this method
		if (node.left != null) {
			inOrder(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	public static void postOrder(BinaryTreeNode node) { // complete this method
		// Recursivley go left
		if (node.left != null) {
			postOrder(node.left);
		}
		// recursivley go right
		if (node.right != null) {
			postOrder(node.right);
		}
		// print node
		System.out.print(node.value + " ");
	}
}
