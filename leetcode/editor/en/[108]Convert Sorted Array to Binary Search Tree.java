//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// A height-balanced binary tree is a binary tree in which the depth of the two 
//subtrees of every node never differs by more than one. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree ?
//? 4820 👎 309


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
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
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> inp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return recur(inp);
    }

    TreeNode recur(List<Integer> inp) {

        if (inp.isEmpty())  {
            return null;
        }

        int size = inp.size();
        int mid = size /2;

        int val = inp.get(mid);
        List<Integer> left = inp.subList(0, mid);
        List<Integer> right = inp.subList(mid + 1, size);

        TreeNode l = recur(left);
        TreeNode r = recur(right);
        return new TreeNode(val, l, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
