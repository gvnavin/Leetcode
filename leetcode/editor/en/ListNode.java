
import java.util.List;

public class ListNode {
    public final int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode create(List<Integer> list) {
        ListNode listNode = null;
        for (Integer integer : list) {
            listNode = appendToLast(integer, listNode);
        }
        return listNode;
    }

    private static ListNode appendToLast(Integer integer, ListNode listNode) {
        if (listNode == null) {
            listNode = new ListNode(integer);
            return listNode;
        }

        ListNode head = listNode;

        while (listNode.getNext() != null) {
            listNode = listNode.getNext();
        }

        listNode.setNext(new ListNode(integer));
        return head;
    }

    public int getVal() {
        return this.val;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}