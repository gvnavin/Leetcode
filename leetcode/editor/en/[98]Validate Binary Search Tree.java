//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 7271
// 👎 755


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }

    boolean traverse(TreeNode root) {

        TreeNode prev = getPrevious(root);
        TreeNode next = getNext(root);

//        System.out.println("prev = " + prev.val);
//        System.out.println("root = " + root.val);
//        System.out.println("next = " + next.val);

        if (!check(root, prev, next)) {
            return false;
        }

        if (root.left != null) {
            boolean left = traverse(root.left);
            if (!left) {
                return false;
            }
        }

        if (root.right != null) {
            boolean right = traverse(root.right);
            if (!right) {
                return false;
            }
        }

        return true;
    }

    private boolean check(TreeNode root, TreeNode prev, TreeNode next) {
        return (prev == null || prev.val < root.val) &&
                (next == null || root.val < next.val);
    }

    private TreeNode getPrevious(TreeNode root) {

        if (root.left == null) {
            return null;
        }
        root = root.left;

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private TreeNode getNext(TreeNode root) {

        if (root.right == null) {
            return null;
        }
        root = root.right;

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
