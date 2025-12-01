import java.util.HashMap;

public class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int n = nums.length, sum = 0, ret = 0;

        // 利用哈希表存储前缀和余数及下标位置
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0 , -1);    // 处理特殊情况：前缀和余数为0的，下标为-1

        for (int i = 0; i < n; i++) {
            // 计算当前位置的前缀和
            sum += (nums[i] == 0 ? -1 : 1);
            // 更新结果
            if (hash.containsKey(sum))
                ret = Math.max(ret, i - hash.get(sum));
            // 将该位置的前缀和以及下标存入哈希表中
            else
                hash.put(sum, i);
        }

        // 返回最终结果
        return ret;
    }
}
