// notice: comparator type can be int[]..., this question is a extension of longest increasing sequence. We first sort the envelop width, if their
width are same, we then sort their height in descending order. And this can avoid recaculating the same width enevelop. Arrays.binarySearch have many overload functions,
when the target cannot be found in the given array, it will return -insertion point - 1, for example, if the array is empty, and we search for one number,
it will return -1, the insertion point would be 0. if we add 8, 9, 20, 15, the array would be 8--> 8, 9--> 8, 9, 20 --> 8, 9, 15 
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
       Arrays.sort(envelopes, new Comparator<int[]>(){
       public int compare(int[] o1, int[] o2) {
           if (o1[0] == o2[0]) {
               return o2[1] - o1[1];
           } else
               return o1[0] - o2[0];
           // it can also return 0, and 1
        }
    });
      //state: len to record the current longest increasing sequence, NlogN time complexity
       int dp[] = new int[envelopes.length];
       int len = 0;
       //loop
       for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
        if (index < 0) {
            index = -index - 1;
        }
        dp[index] = envelope[1];
        if (index == len) {
            len++;
        }
        }
        return len;
    }
   
}
