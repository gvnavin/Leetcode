//Given a binary tree 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no 
//next right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should 
//populate each next pointer to point to its next right node, just like in Figure B. 
//The serialized output is in level order as connected by the next pointers, with 
//'#' signifying the end of each level.
// 
//
// Example 2: 
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
// The number of nodes in the tree is in the range [0, 6000]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 28
//33 👎 210


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution117 {
    public Node connect(Node root) {
        recurLeftAndRight(root);
        recurGrandSibling(root);
        recurNext(root);
        return root;
    }

    void recurLeftAndRight(Node root) {

        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        recurLeftAndRight(root.right);
        recurLeftAndRight(root.left);
    }

    void recurGrandSibling(Node root) {

        if (root == null) {
            return;
        }

        if (root.right != null && root.next != null && root.next.left != null) {
            root.right.next = root.next.left;
        }

        recurGrandSibling(root.right);
        recurGrandSibling(root.left);
    }


    void recurNext(Node root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && root.left.next == null) {
            connectGrandSibling(root, root.left);
        }

        if (root.right != null && root.right.next == null) {
            connectGrandSibling(root, root.right);
        }

        recurNext(root.right);
        recurNext(root.left);

    }

    private void connectGrandSibling(Node root, Node connect) {
        if (root.next == null || connect == null) {
            return;
        }

        Node temp = root.next;
        while (temp != null) {
            if (temp.left != null) {
                connect.next = temp.left;
                return;
            } else if (temp.right != null) {
                connect.next = temp.right;
                return;
            }
            temp = temp.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
