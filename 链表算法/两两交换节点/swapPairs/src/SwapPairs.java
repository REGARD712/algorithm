class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SwapPairs {
    // 迭代法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // 引入虚拟头节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        // 使用四个指针辅助操作
        ListNode prev = newHead, cur = head, next = cur.next, nnext = next.next;
        while (cur != null && next != null) {
            prev.next = next; next.next = cur; cur.next = nnext;
            // 调整指针
            prev = cur; cur = nnext;
            if (cur != null) next = cur.next;
            if (next != null) nnext = next.next;
        }

        return newHead.next;
    }

    // 递归法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = temp;

        return newHead;
    }
}
