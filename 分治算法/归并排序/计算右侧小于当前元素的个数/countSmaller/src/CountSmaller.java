import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    int[] index; // 用于记录nums数组中每个元素对应的初始下标
    int[] tempNums, tempIndex; // nums和index的合并辅助数组
    int[] ret;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tempNums = new int[n]; tempIndex = new int[n];
        index = new int[n]; ret = new int[n];

        // 初始化 index 数组
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        mergeSort(nums, 0, n-1);

        // 返回结果
        List<Integer> finalRet = new ArrayList<>();
        for (int i = 0; i < ret.length; i++) {
            finalRet.add(ret[i]);
        }
        return finalRet;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        // 将数组分为两个部分: [left,mid],[mid+1,right]

        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        // 按照降序合并
        int ptr1 = left, ptr2 = mid+1, k = 0;
        while (ptr1 <= mid && ptr2 <= right) {
            if (nums[ptr1] <= nums[ptr2]) {
                tempNums[k] = nums[ptr2];
                tempIndex[k++] = index[ptr2++];
            } else {
                ret[index[ptr1]] += right - ptr2 + 1; // 重点
                tempNums[k] = nums[ptr1];
                tempIndex[k++] = index[ptr1++];
            }
        }
        // 处理剩下的排序
        while (ptr1 <= mid) {
            tempNums[k] = nums[ptr1];
            tempIndex[k++] = index[ptr1++];
        }
        while (ptr2 <= right) {
            tempNums[k] = nums[ptr2];
            tempIndex[k++] = index[ptr2++];
        }

        // 数据迁移回原数组
        for (int i = left; i <= right; i++) {
            nums[i] = tempNums[i-left];
            index[i] = tempIndex[i-left];
        }
    }
}
