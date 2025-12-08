public class ModifyString {
    // 版本一：1. 使用两个变量存储左右字符；2. 除了两个变量所存字符之外的字母都可以用来替换（使用 StringBuilder ）
    public String modifyString1(String s) {
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char pre = ch, next = ch;
            if (i != 0) {
                pre = ret.charAt(i - 1);
            }
            if (i != n - 1) {
                next = s.charAt(i + 1);
            }
            if (ch == '?') ret.append(exchangeChar(pre, next));
            else ret.append(ch);
        }
        return ret.toString();
    }
    private char exchangeChar (char pre, char next) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if ((ch != pre) && (ch != next)) return ch;
        }
        return ' ';
    }

    // （效率更快）版本二：1. 将字符串转化为字符数组，以便修改和访问元素；2. 通过下标访问左右字符，判断边界情况
    public String modifyString(String s) {
        char[] sarr = s.toCharArray();
        int n = sarr.length;
        for (int i = 0; i < n; i++) {
            if (sarr[i] == '?') {
                // 进行替换
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if ((i == 0 || ch != sarr[i - 1]) && (i == n - 1 || ch != sarr[i + 1])) {
                        sarr[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(sarr);
        // return new String(sarr);
    }
}
