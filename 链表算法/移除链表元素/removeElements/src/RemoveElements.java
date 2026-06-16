class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // 双指针法
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast.val == val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        if (head.val == val) {
            return head.next;
        }

        return head;
    }
}
