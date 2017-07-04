public class Solution {
    final String [] KEY = {"", "", "abc", "def", "ghi", "jkl" , "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combination(res, "", 0, digits);
        return res;
    }
    public void combination(List<String> res, String temp, int index, String digits) {
        if (temp.length() >= digits.length()) {
            res.add(temp);
            return;
        }
        String letter = KEY[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            combination(res, temp + letter.charAt(i), index + 1, digits);
        }
    }
}
