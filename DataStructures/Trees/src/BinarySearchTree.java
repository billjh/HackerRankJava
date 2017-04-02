class BinarySearchTree {

    static Node Insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }

    static Node lca(Node root, int v1, int v2) {
        Node cur = root;
        while (cur != null) {
            if (v1 < cur.data && v2 < cur.data) {
                cur = cur.left;
                continue;
            }
            if (v1 > cur.data && v2 > cur.data) {
                cur = cur.right;
                continue;
            }
            break;
        }
        return cur;
    }

    static boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.data <= max(root.left)) {
            return false;
        }
        if (root.right != null && root.data >= min(root.right)) {
            return false;
        }
        return checkBST(root.left) && checkBST(root.right);
    }

    // TODO: use cache to improve performance
    private static int max(Node root) {
        int result = root.data;
        if (root.left != null) {
            result = Math.max(result, max(root.left));
        }
        if (root.right != null) {
            result = Math.max(result, max(root.right));
        }
        return result;
    }

    // TODO: use cache to improve performance
    private static int min(Node root) {
        int result = root.data;
        if (root.left != null) {
            result = Math.min(result, min(root.left));
        }
        if (root.right != null) {
            result = Math.min(result, min(root.right));
        }
        return result;
    }

}
