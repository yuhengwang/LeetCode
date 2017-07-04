//leetcode 526
public class Solution {
    int num = 0;
    public int countArrangement(int N) {
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[N];
        dfs(temp, used, N, 1);
        return num;
    }
    public void dfs(List<Integer> temp, boolean [] used, int N, int index) {
        if (temp.size() == N) {
            num++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i - 1] && (i % index == 0 || index % i == 0)) {
                temp.add(i);
                used[i - 1] = true;
                dfs(temp, used, N, index + 1);
                used[temp.get(temp.size() - 1) - 1] = false;
                temp.remove(temp.size() - 1);
            }
        }
      
    }
}
