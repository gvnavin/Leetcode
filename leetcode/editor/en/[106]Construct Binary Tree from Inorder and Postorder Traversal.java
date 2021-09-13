//Given two integer arrays inorder and postorder where inorder is the inorder 
//traversal of a binary tree and postorder is the postorder traversal of the same 
//tree, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 3223 ?
//? 56


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> pl = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        List<Integer> il = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return recur(pl, il);
    }

    TreeNode recur(List<Integer> pl, List<Integer> il) {

        if (pl.isEmpty() || il.isEmpty()) {
            return null;
        }
//        System.out.println("pl = " + pl + ", il = " + il);

        Integer rv = null;
        int ind = -1;
        for (int i = pl.size()-1; i >=0; i--) {
            int tv = pl.get(i);
            int tind = il.indexOf(tv);
            if (tind != -1) {
                rv = tv;
                ind = tind;
                break;
            }
        }

        if (ind == -1) {
            return null;
        }

        pl.remove(rv);

        List<Integer> lio = il.subList(0, ind);
        List<Integer> rio = il.subList(ind+1, il.size());

//        List<Integer> lpl = new ArrayList<>();
//        List<Integer> rpl = new ArrayList<>();
//        for (Integer plv : pl) {
//            if (lio.contains(plv)) {
//                lpl.add(plv);
//            } else {
//                rpl.add(plv);
//            }
//        }

        TreeNode ln = recur(pl, lio);
        TreeNode rn = recur(pl, rio);

        return new TreeNode(rv, ln, rn);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
