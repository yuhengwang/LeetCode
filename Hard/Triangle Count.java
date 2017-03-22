public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(S);
        for (int i = 2; i < S.length; i++) {
            int largest = S[i];
            int low = 0;
            int high = i - 1;
            for (low = 0; low < i - 1; low++) {
                int temp = low;
                high = i - 1;
           // System.out.println("low" + low + "high" + high);
            while (low < high) {
                if (S[low] + S[high] > largest) {
             //       System.out.println(S[low] + "\t" + S[high] + "\t" + largest);
                    count ++;
                    high--;
                } else {
                    break;
                }
            }
            low = temp;
            }
            
            
        }
        return count;
    }
}
