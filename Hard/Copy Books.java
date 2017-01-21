public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if(pages == null || pages.length == 0) {
            return 0;
        }
        // write your code here
        int start = 0;
        int end = 0;
        for (int i = 0; i < pages.length; i++) {
            start = Math.max(start, pages[i]) == start ? start : pages[i];
            end += pages[i];
        }
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(numOfPerson(mid, pages) == k) {
                end = mid;
            } else if (numOfPerson(mid, pages) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
     
        if (numOfPerson(start, pages) <= k) {
            return start;
        }
       
        if (numOfPerson(end, pages) <= k ){
            return end;
        }
        return -1;
        
    }
    // for loop, try to avoid i-- in case of dead loop
    public int numOfPerson(int time, int [] pages) {
        int num = 1;
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            if(sum + pages[i] > time) {
                num++;
                sum = 0;
            }
            sum +=pages[i];
        }
        return num;
    }
}
