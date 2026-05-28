import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelectSort(nums, 0, nums.length-1, k);
    }

    private int quickSelectSort(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        // 生成随机值作为基准值key
        int key = nums[new Random().nextInt(end-start+1) + start];

        // 将数组分为三块：[start,left]、[left+1,right-1]、[right,end]
        int left = start-1, i = start, right = end+1;
        int b = 0, c = 0; // 用于统计中间和右边区间的元素个数
        while (i < right) {
            if (nums[i] < key) {
                swap(nums, i++, ++left);
            } else if (nums[i] > key) {
                c++;
                swap(nums, i, --right);
            } else {
                b++; i++;
            }
        }

        // 分类讨论寻找目标元素
        if (c >= k) {
            // 目标元素一定在第三个区间中
            return quickSelectSort(nums, right, end, k);
        } else if (b+c >= k) {
            // 目标元素在第二个区间中，直接返回key
            return key;
        } else {
            // 目标元素在第一个区间中
            return quickSelectSort(nums, start, left, k-b-c);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
