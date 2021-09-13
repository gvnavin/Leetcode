//Given the head of a linked list, rotate the list to the right by k places. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 500]. 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics Linked List Two Pointers 👍 3065 👎 1191


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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }

        ListNode end = head;
        k--;

        while(k > 0) {
            if (end.next != null) {
                end = end.next;
            } else {
                end = head;
            }
            k--;
        }

        ListNode previous = null;
        ListNode center = head;

        while(end.next != null) {
            end = end.next;
            previous = center;
            center = center.next;
        }

        if (previous != null) {
            previous.next = null;
            end.next = head;
            head = center;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l0.next = l1;
        l1.next = l2;
        new Solution().rotateRight(l0, 4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
