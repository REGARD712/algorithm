class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = temp;

        return newHead;
    }
}
