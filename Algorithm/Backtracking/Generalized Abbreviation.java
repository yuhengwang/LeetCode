// we need to decide whether we need to abbreviate the character or not, it is better to change the sb to the orginal state, but in this question,
// only change back to original state after the first dfs is okay.
USEFULL PATTERN:
int len = sb.length();
...
sb.setLength(len);

public class Solution {
    // whether the current character should be abbreviated or not, 1111 cannot happen, but 4.
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word, 0, 0);
        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, String word, int i, int k) {
        if (i == word.length()) {
            if (k != 0) 
                sb.append(k);
           // System.out.println("answer is: " + sb.toString());
            res.add(String.valueOf(sb));
        } else {
        // if the current character is abbrevated
            int len = sb.length();
            dfs(res, sb, word, i + 1, k + 1);
            sb.setLength(len);
        // if the current character is kept
            if (k != 0)
                sb.append(k);
            sb.append(word.charAt(i));
            dfs(res, sb, word, i + 1, 0);   
        }
        
    }
}
