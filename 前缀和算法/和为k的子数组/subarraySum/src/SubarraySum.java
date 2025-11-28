import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, ret = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();  // 使用哈希表来存放前缀和及出现次数<前缀和,出现次数>
        hash.put(0,1);  // 处理边界情况

        for (int i : nums) {
            sum += i;  // 计算当前位置的前缀和
            if (hash.containsKey(sum - k))  // 在哈希表中存放的前缀和([0,i-1]区间)中找是否有等于sum-k,并更新结果
                ret += hash.get(sum - k);
            hash.put(sum,hash.getOrDefault(sum,0) + 1);  // 将当前位置的前缀和存入哈希表中
        }

        // 返回最终结果
        return ret;
    }
}
