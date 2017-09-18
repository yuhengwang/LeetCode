1 3 5 6
4 5 6
9 6
15
class Solution {
    boolean res = false;
    final double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for(int n : nums) arr.add((double) n);
        helper(arr);
        return res;
    }

    private void helper(List<Double> arr){
        if (res)    return;
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < eps) {
                res = true;
            }
            return;
        }
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                double n1 = arr.get(i);
                double n2 = arr.get(j);
                next.addAll(Arrays.asList(n1 + n2, n1 * n2, n1 - n2, n2 - n1));
                if (n1 != 0)    next.add(n2 / n1);
                if (n2 != 0)    next.add(n1 / n2);
                arr.remove(i);
                arr.remove(j);
                for (double n : next) {
                    arr.add(n);
                    helper(arr);
                    arr.remove(arr.size() - 1);
                }
     //j has to be first, otherwise out of index error
                arr.add(j, n2);
                arr.add(i, n1);
            }
        }
    }
}
