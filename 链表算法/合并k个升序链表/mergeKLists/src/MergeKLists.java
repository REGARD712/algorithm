import java.util.PriorityQueue;

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
        // 创建小根堆（自定义比较规则：根据节点的val属性比较较小的值）
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);

        // 将lists中的所有头节点放入堆中
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }

        // 合并链表
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (!heap.isEmpty()) {
            // 从堆中取出堆顶元素
            ListNode top = heap.poll();
            // 接入newHead后面
            tail.next = top;
            tail = tail.next;
            // 将当前堆顶元素的下一个节点放入堆中
            if (top.next != null) {
                heap.offer(top.next);
            }
        }

        return newHead.next;
    }
}

// 分治归并法
class MergeKLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 归并法
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }

        // 将数组分为两部分
        int mid = (left + right) / 2;
        // [left, mid][mid + 1, right]

        // 递归处理两部分
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid+1, right);

        // 合并两个有序链表并返回
        return mergeTwoLists(leftList, rightList);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 合并链表
        ListNode head = new ListNode(0), tail = head;
        ListNode ptr1 = l1, ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                tail.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                tail.next = ptr2;
                ptr2 = ptr2.next;
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

//public class MergeKLists {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0 || lists[0] == null) {
//            return null;
//        }
//        if (lists.length < 2) {
//            return lists[0];
//        }
//
//        // 暴力解法
//        ListNode ret = new ListNode();
//        for (int i = 1; i < lists.length; i++) {
//            if (i == 1) {
//                ret = lists[0];
//            }
//            ret = mergeTwoLists(ret, lists[i]);
//        }
//        return ret;
//    }
//
//    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        // 合并两个有序链表: l1和l2
//        ListNode head = new ListNode(), curNext = new ListNode(), tail = head;
//        ListNode ptr1 = l1, ptr2 = l2;
//        while (ptr1 != null && ptr2 != null) {
//            if (ptr1.val <= ptr2.val) {
//                curNext = ptr1.next;
//                tail.next = ptr1;
//                ptr1 = curNext;
//            } else {
//                curNext = ptr2.next;
//                tail.next = ptr2;
//                ptr2 = curNext;
//            }
//            tail = tail.next;
//        }
//        if (ptr1 != null) {
//            tail.next = ptr1;
//        }
//        if (ptr2 != null) {
//            tail.next = ptr2;
//        }
//
//        return head.next;
//    }
//}