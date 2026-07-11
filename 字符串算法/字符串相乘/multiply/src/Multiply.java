public class Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 1.先将字符串逆序
        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();

        // 2.无进位相乘再相加，将得数存到temp中
        int[] temp = new int[m+n-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i+j] += (n2[i]-'0') * (n1[j]-'0');
            }
        }

        // 3.进位处理：采用字符串高精度相加的策略
        int num = 0, t = 0;
        StringBuilder ret = new StringBuilder();
        while (num < m+n-1 || t != 0) {
            if (num < m+n-1) {
                t += temp[num++];
            }
            ret.append(t%10);
            t /= 10;
        }

        // 4.处理前导零情况
        while (ret.length()>1 && ret.charAt(ret.length()-1) == '0') {
            ret.deleteCharAt(ret.length()-1);
        }

        // 5.返回结果时注意反转
        return ret.reverse().toString();
    }
}
