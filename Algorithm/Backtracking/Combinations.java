//basic format of combination,lc 77, we select the first number in the list first, and we will only select the number whose index
// is larger than the first index to avoid redundancy
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            temp.add(i);
            dfs(n, k, res, temp, i + 1);
            temp = new ArrayList<>();
        }
        return res;
    }
    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> temp, int index) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
           temp.add(i);
           dfs(n, k, res, temp, i + 1); 
           temp.remove(temp.size() - 1);
        }
    }
    
}
