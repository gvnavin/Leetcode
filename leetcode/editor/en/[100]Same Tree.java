//Given the roots of two binary trees p and q, write a function to check if 
//they are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
//
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 40
//11 👎 102


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
class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recur(p, q);
    }

    boolean recur(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean fir = recur(p.left, q.left);
        if (fir) {
            return recur(p.right, q.right);
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
