package pa5;

public class TreeTraversals {

    /**
     * print the value in the node, followed by a space (use a space and not a newline to get the desired format).
     * if the node has a left child, then recursively carry out a pre-order traversal starting from node’s left
     * child if the node has a right child, then recursively carry out a pre-order traversal starting from node’s right child
     * @param node the root of the binary tree
     */
    public static void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * If the node has a left child, then recursively carry out an in-order traversal starting from node’s left child
     * print the value in the node, followed by a space . if the node has a right child, then recursively carry out an
     * in-order traversal starting from node’s right child     *
     *
     * If the binary tree is a binary search tree, then the output
     * of in-order traversal is a sorted array.
     * @param node the root of the binary tree
     */
    public static void inOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    /**
     * Post-order traversal of a binary tree is a recursive process.
     * We recursively traverse the left subtree, untill can't go any further.
     * Then we recursively traverse the right subtree, untill can't go any further.
     * Then we print the value of the current node.
     *
     * @param node the root of the binary tree
     */
    public static void postOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
}
