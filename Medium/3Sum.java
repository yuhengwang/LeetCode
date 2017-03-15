public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            current.add(numbers[i]);
            helper(res, current, numbers, 0 - numbers[i], i, i + 1, 0);
            current = new ArrayList<>();
        }
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current, int[] numbers, int target, int index, int start, int times) {
        if (times > 2) {
            return;
        }
        if (target == 0 && times == 2) {
            res.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            if (i == index) {
                continue;
            }
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }
            current.add(numbers[i]);
            times++;
            helper(res, current, numbers, target - numbers[i], index, i + 1, times);
            times--;
            current.remove(current.size() - 1);
        }
        
    }
}
