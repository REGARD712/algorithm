public class ReversePairs {
    int[] arr;

    public int reversePairs(int[] record) {
        arr = new int[record.length];
        return mergeSort(record, 0, record.length-1);
    }

    private int mergeSort(int[] record, int left, int right) {
        if (left >= right) return 0;

        int ret = 0;

        // 找中间下标mid
        int mid = (left + right) / 2;
        // 将数组分为两部分：[left, mid] 和 [mid+1, right]
        ret += mergeSort(record, left, mid);
        ret += mergeSort(record, mid+1, right);

        // 合并的时候进行排序并统计逆序对个数
        int ptr1 = left, ptr2 = mid + 1, k = 0;
        while (ptr1 <= mid && ptr2 <= right) {
            if (record[ptr1] <= record[ptr2]) {
                arr[k++] = record[ptr1++];
            } else {
                ret += mid - ptr1 + 1; // 记录逆序对的个数
                arr[k++] = record[ptr2++];
            }
        }
        while (ptr1 <= mid) arr[k++] = record[ptr1++];
        while (ptr2 <= right) arr[k++] = record[ptr2++];

        // 把数据拷贝回原数组
        for (int i = left; i <= right; i++) {
            record[i] = arr[i-left];
        }
        return ret;
    }
}
