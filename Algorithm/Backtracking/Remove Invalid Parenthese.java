cOWe all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
 The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.

To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). Thus, we restrict ourself to remove the first ) in a series of concecutive )s.

After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
 For this, we keep tracking the last removal position and only remove ‘)’ after that.

Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
 The answer is: do the same from right to left.
 However a cleverer idea is: reverse the string and reuse the code! Here is the final implement in Java.
//
public class Solution {
   public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});
    return ans;
}

public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
    for (int stack = 0,  i = last_i; i < s.length(); i++) {
        if (s.charAt(i) == par[0]) stack++;
        if (s.charAt(i) == par[1]) stack--;
        if (stack >= 0) continue;
        //the () balance is broken, and we have one more ')'
        //remove the first occurence of ')'
        for (int j = last_j; j <= i; j++) {
            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par); 
                // j is smaller than i, but we can remove ) or ( before i, but to calculate whether the string is balanced
                //we need to start calculate from the new i
            }
        }
        return;
    }
    String reverse = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') {
        remove(reverse, ans, 0, 0, new char[]{')', '('});
    } else {
        ans.add(reverse);
    }
}
}


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
