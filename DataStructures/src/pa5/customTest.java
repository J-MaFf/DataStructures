package pa5;

public class customTest {

    public static void main(String[] args) {
        BinaryTreeNode node_22 = new BinaryTreeNode(22);
        BinaryTreeNode node_8 = new BinaryTreeNode(8);
        BinaryTreeNode node_16 = new BinaryTreeNode(16);
        BinaryTreeNode node_14 = new BinaryTreeNode(14);
        BinaryTreeNode node_20 = new BinaryTreeNode(20);
        BinaryTreeNode node_24 = new BinaryTreeNode(24);
        BinaryTreeNode node_8_2 = new BinaryTreeNode(8);
        BinaryTreeNode node_0 = new BinaryTreeNode(0);
        BinaryTreeNode node_6 = new BinaryTreeNode(6);
        BinaryTreeNode node_11 = new BinaryTreeNode(11);
        BinaryTreeNode node_20_2 = new BinaryTreeNode(20);
        BinaryTreeNode node_5 = new BinaryTreeNode(5);
        BinaryTreeNode node_70 = new BinaryTreeNode(70);

        node_22.left = node_8;
        node_22.right = node_16;
        node_8.left = node_14;
        node_8.right = node_20;
        node_16.left = node_24;
        node_16.right = node_8_2;
        node_14.left = node_0;
        node_14.right = node_6;
        node_20.right = node_11;
        node_8_2.right = node_20_2;
        node_6.left = node_5;
        node_6.right = node_70;

        TreeTraversals.preOrder(node_22);
        System.out.println("");
        TreeTraversals.inOrder(node_22);
        System.out.println("");
        TreeTraversals.postOrder(node_22);
        System.out.println("");
    }
}
