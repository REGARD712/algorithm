public class ReversePairs {
    int[] tempNums; // 合并时nums数组的辅助数组

    public int reversePairs(int[] nums) {
        tempNums = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int ret = 0; // 用来记录翻转对的个数
        int mid = (left + right) / 2;
        // 将数组分为两个部分: [left,mid],[mid+1,right]

        // 1.统计翻转对个数(降序)

        // 递归
        ret += mergeSort(nums, left, mid);
        ret += mergeSort(nums, mid+1, right);

        int ptr1 = left, ptr2 = mid+1, k = 0;
        while (ptr1 <= mid) {
            while (ptr2 <= right && nums[ptr1]/2.0 <= nums[ptr2]) ptr2++;
            if (ptr2 > right) break;
            ret += right - ptr2 + 1;
            ptr1++;
        }

        // 2.合并数组使其有序(降序)
        ptr1 = left; ptr2 = mid + 1;
        while (ptr1 <= mid && ptr2 <= right) {
            if (nums[ptr1] <= nums[ptr2]) {
                tempNums[k++] = nums[ptr2++];
            } else {
                tempNums[k++] = nums[ptr1++];
            }
        }
        // 处理剩下的排序
        while (ptr1 <= mid) {
            tempNums[k++] = nums[ptr1++];
        }
        while (ptr2 <= right) {
            tempNums[k++] = nums[ptr2++];
        }

        // 将数据从辅助数组迁移到原数组中
        for (int i = left; i <= right; i++) {
            nums[i] = tempNums[i-left];
        }

        return ret;
    }
}
