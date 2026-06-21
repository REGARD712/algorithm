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

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists[0] == null) {
            return null;
        }
        if (lists.length < 2) {
            return lists[0];
        }

        // 暴力解法
        ListNode ret = new ListNode();
        for (int i = 1; i < lists.length; i++) {
            if (i == 1) {
                ret = lists[0];
            }
            ret = mergeTwoLists(ret, lists[i]);
        }
        return ret;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 合并两个有序链表: l1和l2
        ListNode head = new ListNode(), curNext = new ListNode(), tail = head;
        ListNode ptr1 = l1, ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                curNext = ptr1.next;
                tail.next = ptr1;
                ptr1 = curNext;
            } else {
                curNext = ptr2.next;
                tail.next = ptr2;
                ptr2 = curNext;
            }
            tail = tail.next;
        }
        if (ptr1 != null) {
            tail.next = ptr1;
        }
        if (ptr2 != null) {
            tail.next = ptr2;
        }

        return head.next;
    }
}