class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head; // 快指针，一次走两步
        ListNode slow = head; // 慢指针，一次走一步

        // 两个指针从头节点开始循环走，当相遇时就返回true
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
