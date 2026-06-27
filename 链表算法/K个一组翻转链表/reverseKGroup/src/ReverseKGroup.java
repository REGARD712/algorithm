class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head; // 用于遍历链表统计节点个数
        int n = 0;
        // 1.遍历链表
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // 求出有多少组需要逆序
        n /= k;

        // 2.将长度为k的链表翻转，重复n次该操作
        ListNode newHead = new ListNode(0), tail = newHead;
        cur = head; ListNode curNext = cur.next;
        for (int i = 0; i < n; i++) {
            // 记录当前组的首节点
            ListNode temp = cur;
            for (int j = 0; j < k; j++) {
                // 头插法实现逆序
                curNext = cur.next;
                cur.next = tail.next;
                tail.next = cur;
                cur = curNext;
            }
            // 由temp找到下一组的插入位置
            tail = temp;
        }

        // 此时所有需要逆序的组都已处理完毕，将剩余节点接入tail的后面
        tail.next = cur;

        // 返回结果
        return newHead.next;
    }
}

class ReverseKGroup2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nodeCount = head; // 用于遍历链表统计节点个数
        int count = 0;
        // 1.遍历链表
        while (nodeCount != null) {
            count++;
            nodeCount = nodeCount.next;
        }
        // 求出有多少组需要逆序
        int n = count / k;

        // 2.将长度为k的链表翻转，重复n次该操作
        ListNode newHead = new ListNode(0), tail = newHead;
        ListNode cur = head, curNext = cur.next, temp = new ListNode(0);
        for (int i = 0; i < n; i++) {
            // 记录当前组的首节点
            temp = cur;
            for (int j = 0; j < k; j++) {
                // 头插法实现逆序
                curNext = cur.next;
                cur.next = tail.next;
                tail.next = cur;
                cur = curNext;
            }
            // 由temp找到下一组的插入位置
            tail = temp;
        }

        // 此时所有需要逆序的组都已处理完毕，将剩余节点接入tail的后面
        tail.next = cur;

        // 返回结果
        return newHead.next;
    }
}