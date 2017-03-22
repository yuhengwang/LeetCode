public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        Arrays.sort(numbers);
        int difference = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int residue = target - numbers[i];
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                if (numbers[low] + numbers[high] == residue) {
                    return target;
                } else if (numbers[low] + numbers[high] > residue) {
                    int sum = numbers[low] + numbers[high] + numbers[i];
                    if (Math.abs(sum - target) < difference) {
                        difference = Math.abs(sum - target);
                        result = sum;
                    }
                    high--;
                } else {
                    int sum = numbers[low] + numbers[high] + numbers[i];
                    if (Math.abs(sum - target) < difference) {
                        difference = Math.abs(sum - target);
                        result = sum;
                    }
                    low++;
                }
            }
           
        }
        return result;
    }
}
