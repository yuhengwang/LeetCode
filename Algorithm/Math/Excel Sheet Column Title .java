//StringBuilder insert function
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char a = (char)('A' + --n % 26);
            sb.insert(0, a);
            n = n / 26;
        }
        return sb.toString();
    }
}
