public class Solution {
    public int[] countBits(int num) {
        int [] result = new int[num + 1];
        int offset = 1;
        for(int index = 1; index < num + 1; index++) {
            if (offset * 2 == index) {
                offset = offset * 2;
            }
      //  System.out.println("index: "+index+" offset: "+offset);
        result[index] = result[index - offset] + 1;
        
        }
        return result;
    }
}
