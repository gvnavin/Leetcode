//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in 
//height by no more than 1. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: true
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 4287 👎 251


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
class Solution110 {
    public boolean isBalanced(TreeNode root) {
        int v = recur(root);
        System.out.println("v = " + v);
        if (v == -1) {
            return false;
        } else {
            return true;
        }
    }

    int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = recur(root.left);
        if (l == -1) {
            return -1;
        }
        int r = recur(root.right);
        if (r == -1) {
            return -1;
        }

        if (Math.abs(l-r) <= 1) {
            return Math.max(l, r) + 1;
        } else {
            return -1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
