
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    public static TreeNode createBinarySearchTree(List<Integer> list) {
        TreeNode head = null;

        if (list.isEmpty()) {
            return head;
        }

        for (Integer nodeValue : list) {
            if (head == null) {
                head = new TreeNode(nodeValue);
            } else {
                insertIntoBinarySearchTree(head, nodeValue);
            }
        }
        return head;
    }

    private static void insertIntoBinarySearchTree(TreeNode root, Integer nodeValue) {
        if (root == null) {
            return;
        }
        if (nodeValue < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(nodeValue);
            } else {
                insertIntoBinarySearchTree(root.left, nodeValue);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(nodeValue);
            } else {
                insertIntoBinarySearchTree(root.right, nodeValue);
            }
        }
    }

    public static void display(TreeNode root) {
        System.out.println("--printing tree--");
        final int height = 5, width = 64;

        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++) {
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');
        }

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }

    private static void displayR(StringBuilder sb, int c, int r, int d, int w, TreeNode n,
                                 String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

            String s = String.valueOf(n.val);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length()) {
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);
            }

            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TreeNode)) return false;
        final TreeNode other = (TreeNode) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.val != other.val) return false;
        final Object this$left = this.left;
        final Object other$left = other.left;
        if (this$left == null ? other$left != null : !this$left.equals(other$left)) return false;
        final Object this$right = this.right;
        final Object other$right = other.right;
        if (this$right == null ? other$right != null : !this$right.equals(other$right)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TreeNode;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.val;
        final Object $left = this.left;
        result = result * PRIME + ($left == null ? 43 : $left.hashCode());
        final Object $right = this.right;
        result = result * PRIME + ($right == null ? 43 : $right.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
