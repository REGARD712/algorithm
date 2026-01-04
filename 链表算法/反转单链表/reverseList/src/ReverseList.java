class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = new ListNode(cur.val);
            next.next = newHead.next;
            newHead.next = next;
            cur = cur.next;
        }

        return newHead.next;
    }
}
