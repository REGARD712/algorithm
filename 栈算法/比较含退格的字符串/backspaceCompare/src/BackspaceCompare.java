public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        return deal(s).equals(deal(t));
    }

    public String deal(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (!ret.isEmpty()) {
                    ret.deleteCharAt(ret.length()-1);
                }
            }
        }
        return ret.toString();
    }
}
