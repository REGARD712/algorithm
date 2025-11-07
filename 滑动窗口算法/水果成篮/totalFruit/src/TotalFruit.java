import java.util.HashMap;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int n = fruits.length, left = 0, right = 0, len = 0, in = 0, out = 0;
        int kinds = 0;
        int[] hash = new int[n+1];

        while (right < n) {
            in = fruits[right];
            if (hash[in] == 0) kinds++;  // 用于统计水果的种类
            hash[in]++;                  // 进窗口

            while (kinds > 2) {
                // 若hash中水果的种类大于2，就出窗口
                out = fruits[left];
                hash[out]--;
                // 判断hash中水果的数量是否为空，若为空就将该种水果删去
                if (hash[out] == 0)  kinds--;
                left++;
            }
            // 若map中水果的种类不大于2，就更新结果然后继续进窗口
            len = Math.max(len,right - left + 1);
            right++;
        }

        // 返回最终结果
        return len;
    }
}
