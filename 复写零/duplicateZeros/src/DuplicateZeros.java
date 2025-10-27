public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int cur = 0;
        int dest = -1;
        int n = arr.length;

        // 1.找到最后一个复写的数字
        while (cur < n) {
            if (arr[cur] != 0)
                dest++;
            else
                dest += 2;

            // 判断dest是否到达最终位置
            if (dest >= n-1)
                break;

            cur++;
        }
        // 处理边界情况
        if (dest == n) {
            arr[n-1] = 0;
            cur--;
            dest -= 2;
        }

        // 2.从后往前复写
        while (cur >= 0) {
            if (arr[cur] != 0)
                arr[dest--] = arr[cur--];
            else {
                arr[dest--] = 0;
                arr[dest--] = 0;
                cur--;
            }
        }
    }
}
