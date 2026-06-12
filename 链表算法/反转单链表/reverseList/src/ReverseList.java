class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    public ListNode reverseList(ListNode head) { // 虚拟头节点 + 头插法
        ListNode newHead = new ListNode(); // 虚拟头节点
        ListNode curNext = new ListNode(); // 用来标记下一个节点

        ListNode cur = head;
        while (cur != null) {
            curNext = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = curNext;
        }

        // 当遇到空节点，返回newHead后面的部分
        return newHead.next;
    }
}

class ReverseList2 {
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