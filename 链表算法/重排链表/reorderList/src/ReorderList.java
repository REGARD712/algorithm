class ListNode {
    int val;
    ListNode next;

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

public class ReorderList {
    public void reorderList(ListNode head) {
        // 1.找到链表的中间节点
        ListNode fast = head, slow = head; // 快慢双指针
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时链表被分成两部分: [head,slow][slow.next,tail]

        // 2.将后半部分链表[slow.next,tail]逆序处理
        ListNode newHead = new ListNode(), cur = slow.next, curNext = new ListNode();
        // 先将两个链表断开
        slow.next = null;
        // 利用虚拟头节点和头插法实现逆序
        while (cur != null) {
            curNext = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = curNext;
        }
        // newHead.next即为逆序后的链表头节点

        // 3.合并两个链表: [head,slow] 和 [newHead.next,tail]
        ListNode ptr1 = head, ptr2 = newHead.next;
        ListNode ret = new ListNode(), tail = ret;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                tail.next = ptr1;
                tail = tail.next;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                tail.next = ptr2;
                tail = tail.next;
                ptr2 = ptr2.next;
            }
        }

        head = ret.next;
    }
}
