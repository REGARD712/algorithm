import java.util.HashMap;

public class SubarraysDivByK {
    public int subarraysDivByK(int[] nums, int k) {
        // 利用同余定理，找出i位置的前缀和sum[i]%k等于sum[x]%k
        // sum中存储前缀和，ret存储结果
        int n = nums.length, sum = 0, ret = 0;

        // 利用哈希表存储前缀和取余k的结果(即余数)
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0 % k, 1);     // 处理边界情况

        // 遍历数组
        for (int i : nums) {
            // 计算该位置的前缀和
            sum += i;
            // 利用修正公式求余数
            int temp = (sum % k + k) % k;
            // 判断该余数是否在哈希表中，若存在就更新结果
            //if (hash.containsKey(temp))
            //    ret += hash.get(temp);
            ret += hash.getOrDefault(temp,0);
            // 将该位置的前缀和存入哈希表中
            hash.put(temp, hash.getOrDefault(temp,0) + 1);
        }

        // 遍历完数组，返回结果
        return ret;
    }
}
