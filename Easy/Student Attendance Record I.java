public class Solution {
    public boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }
        int numL = 0;
        int numA = 0;
        boolean flag = false;
        char[] arrays = s.toCharArray();
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 'A') {
                numA++;
            }
            if (arrays[i] == 'L' && flag) {
                numL++;
            } else if (arrays[i] == 'L') {
                numL = 1;
                flag = true;
            } else {
                flag = false;
                numL = 0;
            }
            if (numA > 1 || numL > 2) {
                return false;
            }
            
        }
        return true;
        
    }
}
