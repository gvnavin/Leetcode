//A path in a binary tree is a sequence of nodes where each pair of adjacent 
//nodes in the sequence has an edge connecting them. A node can only appear in the 
//sequence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 701
//4 👎 449


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

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
class Solution124 {
    public int maxPathSum(TreeNode root) {
        Meta meta = recur(root);
        if (meta.maxSumChildAndParent > meta.sumChildMaxAndParent) {
            return meta.maxSumChildAndParent;
        } else {
            return meta.sumChildMaxAndParent;
        }
    }

    class Meta {
        int sumChildMaxAndParent;
        int maxSumChildAndParent;

        public Meta(int sumChildMaxAndParent, int sumChildAndParent) {
            this.sumChildMaxAndParent = sumChildMaxAndParent;
            this.maxSumChildAndParent = sumChildAndParent;
        }
    }

    Meta recur(TreeNode root) {
        if (root == null) {
            return new Meta(0, Integer.MIN_VALUE);
        }
        if (root.left == null && root.right == null) {
            return new Meta(root.val, root.val);
        }

        Meta lm = recur(root.left);
        Meta rm = recur(root.right);

        int[] sum0 = new int[] {
                lm.sumChildMaxAndParent + root.val,
                rm.sumChildMaxAndParent + root.val,
                root.val
        };
        int max0 = Arrays.stream((sum0)).max().getAsInt();

        int[] sum = new int[] {
                lm.maxSumChildAndParent,
                rm.maxSumChildAndParent,
                root.val + lm.sumChildMaxAndParent + rm.sumChildMaxAndParent,
                max0,
        };
        int max = Arrays.stream((sum)).max().getAsInt();


        return new Meta(max0, max);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
