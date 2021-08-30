//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length won't exceed 10^4. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 8387 👎 380


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
    class Wrapper {
        ListNode n;
        int i;
        int j;

        public Wrapper(ListNode n, int i) {
            this.n = n;
            this.i = i;
            this.j = 0;
        }

        public Wrapper(ListNode n, int i, int j) {
            this.n = n;
            this.i = i;
            this.j = j;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        Set<Wrapper> st = new TreeSet<>((o1, o2) -> {
            if (o1.n.val != o2.n.val) {
                return o1.n.val - o2.n.val;
            } else if (o1.i != o2.i) {
                return o1.i - o2.i;
            } else if (o1.j != o2.j) {
                return o1.j - o2.j;
            }
            return o1.n.val - o2.n.val;
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                st.add(new Wrapper(lists[i], i));
            }
        }
        ListNode head = null;
        ListNode liIt = null;
        Iterator<Wrapper> stIt = st.iterator();
        while(stIt.hasNext()) {
            Wrapper wn = stIt.next();
            ListNode node = wn.n;
            ListNode newNode = new ListNode(node.val);
            if (head == null) {
                head = newNode;
            } else {
                liIt.next = newNode;
            }
            liIt = newNode;
            ListNode next = node.next;

            if (wn != null) {
                st.remove(wn);
            }
            if (next != null) {
                st.add(new Wrapper(next, wn.i, wn.j+1));
            }

            stIt = st.iterator();
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
