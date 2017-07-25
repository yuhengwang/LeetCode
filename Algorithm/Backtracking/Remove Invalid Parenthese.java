//classic method, reuse the method of validParenthese, but I used set for remove duplicate, which increase time complexity
public class Solution {
    int min = Integer.MAX_VALUE;
    public boolean validParenthese(String s) {
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            }
            if (s.charAt(i) == ')') {
                if (stack.empty() || stack.pop() != ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> res = new HashSet<>();
        dfs(s, 0, 0, new StringBuilder(), res);
        return new ArrayList<String>(res);
    }
    public void dfs(String s, int index, int changed, StringBuilder sb, HashSet<String> res) {
        if (changed > min) {
            return;
        }
        if (index == s.length()) {
            if (validParenthese(sb.toString())) {
                if (changed <= min) {
                    res.add(sb.toString());
                    min = changed;
                }   
            }
            return;
        } else {
            //keep this character
            int len = sb.length();
            sb.append(s.charAt(index));
            dfs(s, index + 1, changed, sb, res);
            sb.setLength(len);
            
            //remove this character
            dfs(s, index + 1, changed + 1, sb, res);
            
        }
    }
}
