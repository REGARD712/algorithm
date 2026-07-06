public class AddBinary {
    public String addBinary(String a, String b) {
        int ptr1 = a.length()-1, ptr2 = b.length()-1, temp = 0;
        StringBuilder ret = new StringBuilder();

        while (ptr1 >= 0 || ptr2 >= 0 || temp != 0) {
            if (ptr1 >= 0) {
                temp += a.charAt(ptr1) - '0';
                ptr1--;
            }
            if (ptr2 >= 0) {
                temp += b.charAt(ptr2) - '0';
                ptr2--;
            }
            ret.append((char)((temp % 2) + '0'));
            temp /= 2;
        }

        return ret.reverse().toString();
    }
}

class AddBinary2 {
    public String addBinary(String a, String b) {
        int ptr1 = a.length()-1, ptr2 = b.length()-1, temp = 0;
        StringBuilder ret = new StringBuilder();

        while (ptr1 >= 0 || ptr2 >= 0 || temp != 0) {
            if (ptr1 >= 0) {
                temp += a.charAt(ptr1) - 48;
                ptr1--;
            }
            if (ptr2 >= 0) {
                temp += b.charAt(ptr2) - 48;
                ptr2--;
            }
            ret.append(temp % 2);
            temp /= 2;
        }

        return ret.reverse().toString();
    }
}