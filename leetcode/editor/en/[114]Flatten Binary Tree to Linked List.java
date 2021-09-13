//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child 
//pointer points to the next node in the list and the left child pointer is always 
//null. 
// The "linked list" should be in the same order as a pre-order traversal of 
//the binary tree. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related 
//Topics Linked List Stack Tree Depth-First Search Binary Tree 👍 5394 👎 428


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
class Solution114 {
    public void flatten(TreeNode root) {
        recur(root);
    }

    private TreeNode recur(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }

        TreeNode l = recur(root.left);
        TreeNode r = recur(root.right);

        root.left = null;
        root.right = null;

        if (l != null) {
            root.right = l;
            appendAtTheEndOfRight(root, r);
        } else {
            appendAtTheEndOfRight(root, r);
        }

        return root;
    }

    private void appendAtTheEndOfRight(TreeNode node, TreeNode r) {
        while(node.right != null) {
            node = node.right;
        }
        node.right = r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
