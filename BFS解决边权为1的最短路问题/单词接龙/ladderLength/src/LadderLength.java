import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: LadderLength
 * @Author: JacksonLee
 * @Date: 2026/9/12
 * @Description: https://leetcode.cn/problems/word-ladder/description/
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordListHash = new HashSet<>(wordList);

        // 边界情况
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordListHash.contains(endWord)) {
            return 0;
        }

        // 初始化
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> visit = new HashSet<>();
        queue.offer(beginWord);
        visit.add(beginWord);
        char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int count = 1;

        // 层序遍历
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- != 0) {
                String top = queue.poll();
                int n = top.length();
                for (int i = 0; i < n; i++) {
                    for (char character : characters) {
                        String newWord = top.substring(0, i) + character + top.substring(i + 1, n);
                        if (wordListHash.contains(newWord) && !visit.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return count;
                            }
                            queue.offer(newWord);
                            visit.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
