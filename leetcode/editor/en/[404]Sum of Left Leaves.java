//Given the root of a binary tree, return the sum of all left leaves. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 1
//5 respectively.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 22
//54 👎 199


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
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return recur(root);
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftValue = root.left.val;
        } else {
            leftValue = recur(root.left);
        }
        int rightValue = recur(root.right);

        return leftValue + rightValue;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
