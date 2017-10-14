class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char[] temp = s.toCharArray();
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                //flip it
                temp[i] = '-';
                temp[i + 1] = '-';
                res.add(String.valueOf(temp));
            }
            
        }
        return res;
    }
}
