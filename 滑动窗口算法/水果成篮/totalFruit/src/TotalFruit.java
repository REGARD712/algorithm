import java.util.HashMap;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int n = fruits.length, left = 0, right = 0, len = 0, in = 0, out = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while (right < n) {
            in = fruits[right];
            map.put(in,map.getOrDefault(in,0) + 1);  // 进窗口

            while (map.size() > 2) {
                // 若map中水果的种类大于2，就出窗口
                out = fruits[left];
                map.put(out,map.get(out) - 1);
                // 判断map中的Value是否为空，若为空就将该种水果删去
                if (map.get(out) == 0)
                    map.remove(out);
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
