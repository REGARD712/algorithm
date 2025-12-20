class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) return head;

        // 先让后面的节点反转，获取反转后的头节点
        ListNode newHead = reverseList(head.next);

        // 让当前节点与后一个节点反向
        head.next.next = head;
        head.next = null;

        // 返回新头节点
        return newHead;
    }
}
