//Given the root of a binary tree, return the zigzag level order traversal of 
//its nodes' values. (i.e., from left to right, then right to left for the next 
//level and alternate between). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Breadth-First Search Binary Tree 👍 4229 👎 140


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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        int dir = 1;
        while (!q.isEmpty()) {
            ArrayList<Integer> levelValues = new ArrayList<>();
            ArrayList<TreeNode> popedTreeNodes = new ArrayList<>();
            if (dir == 1) {
                for (int i = 0; i < q.size(); i++) {
                    TreeNode treeNode = q.get(i);
                    levelValues.add(treeNode.val);
                    popedTreeNodes.add(treeNode);
                }
                q.clear();
                for (TreeNode locTreeNode : popedTreeNodes) {
                    if (locTreeNode.left != null) {
                        q.add(locTreeNode.left);
                    }
                    if (locTreeNode.right != null) {
                        q.add(locTreeNode.right);
                    }
                }
            } else {
                for (int i = q.size()-1; i >= 0 ; i--) {
                    TreeNode treeNode = q.get(i);
                    levelValues.add(treeNode.val);
                    popedTreeNodes.add(treeNode);
                }
                q.clear();
                for (int i = popedTreeNodes.size()-1; i >= 0 ; i--) {
                    TreeNode locTreeNode = popedTreeNodes.get(i);
                    if (locTreeNode.left != null) {
                        q.add(locTreeNode.left);
                    }
                    if (locTreeNode.right != null) {
                        q.add(locTreeNode.right);
                    }
                }
            }
            dir = ~dir;
            ret.add(levelValues);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
