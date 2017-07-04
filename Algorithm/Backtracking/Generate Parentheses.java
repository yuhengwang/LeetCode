//we use dfs to solve the problem, where open record the number of (, and close record the number of ). 
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, n, "");
        return res;
    }
    public void dfs(List<String> res, int open, int close, int max, String temp) {
        if (temp.length() == max * 2) {
            res.add(temp);
            return;
        }
        if (open < max) {
            dfs(res, open + 1, close, max, temp + '(');
        }
        if (close < open) {
            dfs(res, open, close + 1, max, temp + ')');
        }
    }
}
