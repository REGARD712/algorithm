import java.util.HashMap;

public class MinNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // 使用哈希表存储五个字母出现的情况
        HashMap<Character,Integer> hash = new HashMap<>();
        hash.put('c',0); hash.put('r',0); hash.put('o',0); hash.put('a',0); hash.put('k',0);

        // 遍历字符串统计字母出现情况
        for (int i = 0; i < croakOfFrogs.length(); i ++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                if (hash.get('k') != 0) {
                    hash.put('k', hash.get('k') - 1);
                    hash.put(ch, hash.get(ch) + 1);
                } else {
                    hash.put(ch, hash.get(ch) + 1);
                }
            } else {
                if (i != 0) {
                    // 找前一个字符
                    char prech = findPreCh(ch);
                    if (hash.get(prech) != 0) {
                        // 前一个字符存在
                        hash.put(prech, hash.get(prech) - 1);
                        hash.put(ch, hash.get(ch) + 1);
                    } else {
                        // 前一个字符不存在
                        return -1;
                    }
                }
            }
        }

        // 返回结果
        if(checkRestZero(hash)) return hash.get('k');
        else return -1;
    }

    private boolean checkRestZero(HashMap<Character, Integer> hash) {
        return hash.get('a') == 0 && hash.get('c') == 0 && hash.get('o') == 0 && hash.get('r') == 0;
    }

    private char findPreCh(char ch) {
        if (ch == 'r') return 'c';
        else if (ch == 'o') return 'r';
        else if (ch == 'a') return 'o';
        else if (ch == 'k') return 'a';
        return ' ';
    }
}
