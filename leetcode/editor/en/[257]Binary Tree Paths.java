//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics String Tree Depth-First Search Binary Tree 👍 3066 👎 151


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
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
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
//        ArrayList<String> ret = new ArrayList<>();
//        ArrayList<String> vals = new ArrayList<>();
//        recur(root, vals, ret);
//        return ret;
        return recurV2(root);
    }

    private void recur(TreeNode root, List<String> vals, ArrayList<String> ret) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            vals.add(String.valueOf(root.val));
            ret.add(String.join("->", vals));
            return;
        }

        ArrayList<String> lvals = new ArrayList<>(vals);
        ArrayList<String> rvals = new ArrayList<>(vals);

        lvals.add(String.valueOf(root.val));
        rvals.add(String.valueOf(root.val));

        recur(root.left, lvals, ret);
        recur(root.right, rvals, ret);
    }

    private List<String> recurV2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        if (root.left == null && root.right == null) {
            return List.of(String.valueOf(root.val));
        }

        List<String> ll = recurV2(root.left);
        List<String> rl = recurV2(root.right);

        List<String> ret = new ArrayList<>();
        ret.addAll(ll);
        ret.addAll(rl);

        for (int i = 0; i < ret.size(); i++) {
            String str = ret.get(i);
            String appendStr = root.val + "->" + str;
            ret.set(i, appendStr);
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
