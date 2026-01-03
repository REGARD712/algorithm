class ListNode {
    public int val;
    public ListNode next;
}

public class RemoveElements {
    // 迭代法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode pre = head;
        ListNode cur = pre.next;

        // 主体
        while (cur != null) {
            if (cur.val != val) pre = cur;
            else pre.next = cur.next;
            cur = cur.next;
        }

        if (head.val == val) return head.next;
        else return head;
    }
}
