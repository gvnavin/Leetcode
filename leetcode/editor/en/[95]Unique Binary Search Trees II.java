//Given an integer n, return all the structurally unique BST's (binary search 
//trees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics Dynamic Programming Backtracking Tree Binary Search Tree 
//Binary Tree 👍 3879 👎 247


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        List<Integer> values = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());

        List<TreeNode> ret = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            int v = values.get(i);
            List<Integer> leftList = values.subList(0, i);
            List<Integer> rightList = values.subList(i+1, n);

            extracted(ret, v, leftList, rightList);
        }
        return ret;
    }

    List<TreeNode> recurTree(List<Integer> values) {

        if (values.size() == 1) {
            return List.of(new TreeNode(values.get(0)));
        }

        List<TreeNode> ret = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            int v = values.get(i);
            List<Integer> leftList = values.subList(0, i);
            List<Integer> rightList = values.subList(i + 1, values.size());
            extracted(ret, v, leftList, rightList);
        }
        return ret;
    }

    private void extracted(List<TreeNode> ret, int v, List<Integer> leftList, List<Integer> rightList) {
        List<TreeNode> left = recurTree(leftList);
        List<TreeNode> right = recurTree(rightList);

        if (!left.isEmpty() && !right.isEmpty()) {
            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode newNode = new TreeNode(v);
                    newNode.left = ln;
                    newNode.right = rn;
                    ret.add(newNode);
                }
            }
        } else if (left.isEmpty() && right.isEmpty()) {
            TreeNode newNode = new TreeNode(v);
            ret.add(newNode);
        } else if (left.isEmpty()) {
            for (TreeNode rn : right) {
                TreeNode newNode = new TreeNode(v);
                newNode.right = rn;
                ret.add(newNode);
            }
        } else if (right.isEmpty()) {
            for (TreeNode ln : left) {
                TreeNode newNode = new TreeNode(v);
                newNode.left = ln;
                ret.add(newNode);
            }
        }
    }

    public static void main(String[] args) {
        new Solution95().generateTrees(3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
