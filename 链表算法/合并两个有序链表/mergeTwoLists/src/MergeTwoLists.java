class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0); // 虚拟头节点

        ListNode ptr1 = list1, ptr2 = list2; // 遍历两个链表的指针节点
        ListNode curNext = new ListNode(); // 记录当前节点的下一个节点
        ListNode tail = newHead; // 记录新链表的尾节点

        // 遍历两个链表、合并
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

        return newHead.next;
    }
}
