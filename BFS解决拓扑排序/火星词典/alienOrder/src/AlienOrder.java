import java.util.*;

/**
 * https://leetcode.cn/problems/Jf1JuT/
 *
 * @ClassName: AlienOrder
 * @Author: JacksonLee
 * @Date: 2026/10/11
 */
public class AlienOrder {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Integer> in = new HashMap<>(); // 记录入度值
        // 初始化,将words中所有单词的字符记录下来,入度均为0
        for (String s : words) {
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                in.put(c, 0);
            }
        }

        // 遍历,收集信息
        int len = words.length;
        for (int i = 0; i < len; i++) {
            char[] word = words[i].toCharArray();
            for (int j = i+1; j < len; j++) {
                char[] nextWord = words[j].toCharArray();
                int n1 = word.length, n2 = nextWord.length;
                // 比较两个字符串
                int n = Math.min(n1, n2);
                int k = 0;
                for (; k < n; k++) {
                    char a = word[k], b = nextWord[k];
                    if (a != b) {
                        // a在b之前,即：a -> b
                        if (!edges.containsKey(a)) {
                            edges.put(a, new HashSet<>());
                        }
                        if (!edges.get(a).contains(b)) { // 防止重复
                            edges.get(a).add(b);    // 存入邻接表
                            in.put(b, in.get(b)+1); // 更新b的入度值
                        }
                        // 有一个字符不相同后面就不继续比较了
                        break;
                    }
                }
                // 细节问题
                if (k == n2 && k < n1) {
                    // 不合法
                    return "";
                }
            }
        }

        // 拓扑排序
        Queue<Character> queue = new LinkedList<>();
        // 把入度为0的字符加入队列
        for (char ch : in.keySet()) {
            // 找到入度值为0的字符
            if (in.get(ch) == 0) {
                // 放入队列
                queue.offer(ch);
            }
        }
        // 层序遍历
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            char top = queue.poll(); // 取出队首元素
            ans.append(top);
            for (char ch : edges.getOrDefault(top, new HashSet<>())) {
                // 将与队首元素相连的字符的入度值减一
                in.put(ch, in.get(ch)-1);
                // 判断减一之后的入度值是否为0,若为0则加入队列
                if (in.get(ch) == 0) {
                    queue.offer(ch);
                }
            }
        }

        // 判断是否还有入度不为0的字符,若有就返回空字符串,否则返回结果
        for (char ch : in.keySet()) {
            if (in.get(ch) != 0) {
                // 返回空字符串
                return "";
            }
        }
        // 返回结果
        return ans.toString();
    }
}
