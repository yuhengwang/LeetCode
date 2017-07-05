public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIP(res, s, "", 0, 0);
        return res;
    }
    public void restoreIP(List<String> res, String s, String temp, int index, int count) {
        if (count > 4) {
            return;
        }
        if (s.length() == index && count == 4) {
            res.add(temp);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) {
                break;
            }
            String t = s.substring(index, index + i);
            if ((t.charAt(0) == '0' && t.length() > 1)|| (i == 3 && Integer.parseInt(t) >= 256)) break;
            if (temp.length() == 0) {
                restoreIP(res, s, t, index + i, count + 1);
            } else
                restoreIP(res, s, temp + "." + t, index + i, count + 1);
        }
    }
}
