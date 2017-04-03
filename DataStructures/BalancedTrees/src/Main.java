public class Main {

    public static void main(String[] args) {
        AVLTree.insert(null, 0);
    }
}

class Node {
    int val;
    int ht;
    Node left;
    Node right;
}

class AVLTree {

    static Node insert(Node root, int val) {
        if (root == null) {
            Node n = new Node();
            n.val = val;
            return n;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
            if (height(root.left) - height(root.right) == 2) {
                if (val < root.left.val) {
                    root = rightRotate(root);
                } else {
                    root = doubleRightRotate(root);
                }
            }
        } else {
            root.right = insert(root.right, val);
            if (height(root.right) - height(root.left) == 2) {
                if (val < root.right.val) {
                    root = doubleLeftRotate(root);
                } else {
                    root = leftRotate(root);
                }
            }
        }

        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    private static Node doubleLeftRotate(Node root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    private static Node doubleRightRotate(Node root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    private static Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.ht = Math.max(root.ht, height(newRoot.right)) + 1;

        return newRoot;
    }

    private static Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        newRoot.ht = Math.max(height(newRoot.left), root.ht) + 1;

        return newRoot;
    }

    private static int height(Node root) {
        return (root == null) ? -1 : root.ht;
    }

}