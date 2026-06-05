import java.util.Random;

public class InventoryManagement {
    public int[] inventoryManagement(int[] stock, int cnt) {
        quickSelectSort(stock, 0, stock.length-1, cnt);

        int[] ret = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            ret[i] = stock[i];
        }
        return ret;
    }

    public void quickSelectSort(int[] stock, int l, int r, int cnt) {
        if (l >= r) {
            return;
        }

        // 生成随机值作为基准元素
        int key = stock[new Random().nextInt(r-l+1) + l];

        // 将数组分为三部分
        int left = l-1, i = l, right = r+1;
        while (i < right) {
            if (stock[i] < key) {
                swap(stock, i++, ++left);
            } else if (stock[i] > key) {
                swap(stock, i, --right);
            } else {
                i++;
            }
        }
        // 分类讨论
        int a = left-l+1, b = right-left-1;
        if (a > cnt) {
            // 在[l,left]中
            quickSelectSort(stock, l, left, cnt);
        } else if (a + b >= cnt) {
            // 直接返回
            return;
        } else {
            // 在[right,r]中
            quickSelectSort(stock, right, r, cnt-a-b);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
