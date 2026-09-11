import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

/**
 * @ClassName: MinMutation
 * @Author: JacksonLee
 * @Date: 2026/9/11
 * @Description: https://leetcode.cn/problems/minimum-genetic-mutation/
 */
public class MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankHash = new HashSet<>(Arrays.asList(bank));

        // 边界情况
        if (startGene.equals(endGene)) {
            return 0;
        }
        if (!bankHash.contains(endGene)) {
            return -1;
        }

        // 初始化
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> visit = new HashSet<>();
        queue.offer(startGene);
        visit.add(startGene);
        char[] characters = { 'A', 'C', 'G', 'T' };
        int count = 0;

        // 层序遍历
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- != 0) {
                String top = queue.poll();
                int n = top.length();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 4; j++) {
                        String newGene = top.substring(0, i) + characters[j] + top.substring(i + 1, n);
                        if (bankHash.contains(newGene) && !visit.contains(newGene)) {
                            if (newGene.equals(endGene)) {
                                return count;
                            }
                            queue.offer(newGene);
                            visit.add(newGene);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
