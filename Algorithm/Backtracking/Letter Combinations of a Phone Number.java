//we can use an array of string to do the mapping work, the first method is recursive, classic dfs method. The second method use FIFO queue, 
//similar to bfs
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



public class Solution {
    final String [] KEY = {"", "", "abc", "def", "ghi", "jkl" , "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String ans = "";
        res.add(ans);
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                String letter = KEY[x];
                for (int j = 0; j < letter.length(); j++) {
                    res.add(t + letter.charAt(j));
                }
            }
        }
        return res;
    }
}
