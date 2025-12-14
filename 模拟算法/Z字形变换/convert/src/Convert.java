public class Convert {
    public String convert(String s, int numRows) {
        // 通过下标直接访问字符

        // 处理边界情况
        if (numRows == 1) return s;

        int n = s.length(), d = 2 * numRows - 2;
        StringBuilder ret = new StringBuilder();

        // 1. 先处理第一行
        for (int i = 0; i < n; i += d) {
            ret.append(s.charAt(i));
        }

        // 2. 接着处理中间部分
        for (int k = 1; k < numRows - 1; k ++) {
            for (int i = k, j = d - i; i < n || j < n; i += d, j += d) {
                if (i < n) ret.append(s.charAt(i));
                if (j < n) ret.append(s.charAt(j));
            }
        }

        // 3. 再处理最后一行
        for (int i = numRows - 1; i < n; i += d) {
            ret.append(s.charAt(i));
        }

        // 4. 返回最终结果
        return ret.toString();
    }
}
