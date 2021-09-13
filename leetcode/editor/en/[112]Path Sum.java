//Given the root of a binary tree and an integer targetSum, return true if the 
//tree has a root-to-leaf path such that adding up all the values along the path 
//equals targetSum. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: false
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Binary Tree 👍 3907 👎 679


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
class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recur(root, targetSum);
    }

    boolean recur(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }


        boolean l = recur(root.left, targetSum - root.val);
        boolean r = recur(root.right, targetSum - root.val);

        return l || r;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
