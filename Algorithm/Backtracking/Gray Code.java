public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        boolean[] dict = new boolean[(int)Math.pow(2, n)];
        String first = "";
        for (int i = 0; i < n; i++) {
            first += '0';
        }
        res.add(0);
        dict[0] = true;
        dfs(n, res, first,dict);
        return res;
    }
    public void dfs(int n, List<Integer> res, String digit,boolean[] dict) {
        if (res.size() == Math.pow(2, n)) {
            return;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            // select one position to change the bit from 0 to 1 or from 1 to 0
            String result = "";
            String bit = "";
            if (digit.charAt(i) == '0') {
                bit = "1";
            } else {
                bit = "0";
            }
            if (i == 0) {
                result = bit + digit.substring(1);
            } else {
                result = digit.substring(0, i) + bit + digit.substring(i + 1);
            }
            
            //if the digit already exist
            if (dict[transformToDigit(result)]) {
                continue;
            }
            res.add(transformToDigit(result));
            dict[transformToDigit(result)] = true;
            dfs(n, res, result, dict);
        }
    }
    public int transformToDigit(String digit) {
        int power = 0;
        int res = 0;
        for (int i = digit.length() - 1; i >= 0; i--) {
            res += (int)(Math.pow(2, power) * Character.getNumericValue(digit.charAt(i)));
            power++;
        }
        return res;
    }
}
