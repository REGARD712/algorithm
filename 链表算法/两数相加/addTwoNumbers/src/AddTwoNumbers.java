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

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 引入虚拟头节点
        ListNode newHead = new ListNode(0);
        // 指向虚拟头节点的指针
        ListNode tail = newHead;

        // 双指针
        ListNode ptr1 = l1, ptr2 = l2;
        // 记录相加之和的变量
        int temp = 0;

        // 遍历两链表进行相加操作
        while (ptr1 != null || ptr2 != null || temp != 0) {
            // 分开相加，存到temp中，注意不要覆盖原值
            if (ptr1 != null) {
                temp += ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                temp += ptr2.val;
                ptr2 = ptr2.next;
            }
            // 将和的个位数字放入新节点，将新节点接入虚拟头节点后
            tail.next = new ListNode(temp%10);
            tail = tail.next;
            // 将temp的个位数字舍去
            temp /= 10;
        }

        // 返回结果
        return newHead.next;
    }
}
