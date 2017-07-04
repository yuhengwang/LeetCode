public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack <Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            }
            if (s.charAt(i) == '[') {
                stack.push(']');
            }
            if (s.charAt(i) == '{') {
                stack.push('}');
            }
            if (s.charAt(i) == ')') {
                if (stack.empty() || stack.pop() != ')') {
                    return false;
                }
            }
             if (s.charAt(i) == ']') {
                if (stack.empty() || stack.pop() != ']') {
                    return false;
                }
            }
             if (s.charAt(i) == '}') {
                if (stack.empty() || stack.pop() != '}') {
                    return false;
                }
            }
        }
        return true && stack.empty();
    }
}
