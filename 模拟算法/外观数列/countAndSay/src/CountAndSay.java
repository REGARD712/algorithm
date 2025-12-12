public class CountAndSay {
    public String countAndSay(int n) {
        String ret = "1";
        int len = ret.length();

        for (int i = 0; i < n - 1; i++) {
            // 利用双指针划分相同数字
            int left = 0, right = 0;
            StringBuilder temp = new StringBuilder();

            while (right < len) {
                while (right < len && ret.charAt(left) == ret.charAt(right)) right ++;
                // 计算相同数字的长度并记录
                temp.append(Integer.toString(right - left));
                temp.append(ret.charAt(left));

                // 移动双指针
                left = right;
            }

            // 更新 ret
            ret = temp.toString();
            len = ret.length();
        }

        // 返回最终结果
        return ret;
    }
}
