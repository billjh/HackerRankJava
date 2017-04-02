import java.util.ArrayList;

class Tree {

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ", root.data);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.printf("%d ", root.data);
        inOrder(root.right);
    }

    static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static void top_view(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> topView = new ArrayList<>();
        topView.add(root.data);
        Node cur = root;
        while (cur.left != null) {
            topView.add(0, cur.left.data);
            cur = cur.left;
        }
        cur = root;
        while (cur.right != null) {
            topView.add(cur.right.data);
            cur = cur.right;
        }
        for (Integer v: topView) {
            System.out.printf("%d ", v);
        }
    }

    static void LevelOrder(Node root) {
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove(0);
            if (cur == null) {
                continue;
            }
            System.out.printf("%d ", cur.data);
            queue.add(cur.left);
            queue.add(cur.right);
        }
    }

}
