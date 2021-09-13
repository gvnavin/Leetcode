//Given the root of a binary tree and an integer targetSum, return all root-to-
//leaf paths where the sum of the node values in the path equals targetSum. Each 
//path should be returned as a list of the node values, not node references. 
//
// A root-to-leaf path is a path starting from the root and ending at any leaf 
//node. A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//Explanation: There are two paths whose sum equals targetSum:
//5 + 4 + 11 + 2 = 22
//5 + 8 + 4 + 5 = 22
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
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
// Related Topics Backtracking Tree Depth-First Search Binary Tree 👍 3618 👎 95
//


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> il = new ArrayList<>();
        recur(root, targetSum, il, ret);
        return ret;
    }

    void recur(TreeNode root, int targetSum, List<Integer> il, List<List<Integer>> ret) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null && targetSum - root.val == 0) {
            List<Integer> rl = new ArrayList<>(il);
            rl.add(root.val);
            ret.add(rl);
            return;
        }

        List<Integer> ll = new ArrayList<>(il);
        List<Integer> rl = new ArrayList<>(il);

        ll.add(root.val);
        rl.add(root.val);

        recur(root.left, targetSum - root.val, ll, ret);
        recur(root.right, targetSum - root.val, rl, ret);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
