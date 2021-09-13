//Given the root of a binary tree, return the bottom-up level order traversal 
//of its nodes' values. (i.e., from left to right, level by level from leaf to root)
//. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[15,7],[9,20],[3]]
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
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Breadth-First Search Binary Tree 👍 2513 👎 260


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
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
class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        recur(root, 0, hm);

//        System.out.println("hm = " + hm);
        for (List<Integer> list : hm.values()) {
            ret.add(0, list);
        }

//        System.out.println("ret = " + ret);
        return ret;
    }

    void recur(TreeNode root, int lvl, HashMap<Integer, List<Integer>> hm) {
        if (root == null) {
            return;
        }
        recur(root.left, lvl+1, hm);
        recur(root.right, lvl+1, hm);
        List<Integer> list = hm.getOrDefault(lvl, new ArrayList<>());
        list.add(root.val);
        hm.put(lvl, list);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
