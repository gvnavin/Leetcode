//Given the head of a singly linked list where elements are sorted in ascending 
//order, convert it to a height balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree 
//in which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// 
// Example 1: 
//
// 
//Input: head = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the 
//shown height balanced BST.
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [0]
//Output: [0]
// 
//
// Example 4: 
//
// 
//Input: head = [1,3]
//Output: [3,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in head is in the range [0, 2 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics Linked List Divide and Conquer Tree Binary Search Tree Binary 
//Tree 👍 3742 👎 104


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> inp = new ArrayList<>();
        while(head != null) {
            inp.add(head.val);
            head = head.next;
        }
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
