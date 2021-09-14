//Given the root of a binary search tree, and an integer k, return the kᵗʰ (1-
//indexed) smallest element in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 4694
// 👎 98


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
class Solution230 {

    int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return recur(root);
    }

    int recur(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int lv = -1;
        if (k > 0) {
            lv = recur(root.left);
        }
        if (lv != -1) {
            return lv;
        }

        k--;
        if (k == 0) {
            return root.val;
        }

        int rv = -1;
        if (k > 0) {
            rv = recur(root.right);
        }
        if (rv != -1) {
            return rv;
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
