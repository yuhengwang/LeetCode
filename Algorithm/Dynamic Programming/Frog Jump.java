// My Solution (not concise!)
We have two structure in state, one is to store whether the frog can jump to this position. Another is a hashmap, where key is the index
of the current position, and valule is list of ResultType, ResultType is to store last jump index and last jump units. Because there may be 
more than one way to jump to current position, we hence need to record them in a list.
public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    class ResultType {
        int lastIndex;
        int lastUnits;
        public ResultType(int lastIndex, int lastUnits) {
            this.lastIndex = lastIndex;
            this.lastUnits = lastUnits;
        }
    }
    public boolean canCross(int[] stones) {
        // Write your code here
        if (stones == null || stones.length == 0) {
            return false;
        }
        if (stones[0] != 0 && stones[1] != 1) {
            return false;
        }
        if (stones.length < 3) {
            return true;
        }
        //state whether the frog can jump to this stone
        boolean[] jump = new boolean[stones.length];
        //state all possible last jump index and jump units
        HashMap<Integer, List<ResultType>> history = new HashMap<>(); 
        //initialization
        jump[0] = true;
        jump[1] = true;
        for (int i = 0; i < stones.length; i++) {
            List<ResultType> his = new ArrayList<>();
            history.put(i, his);
        }
        history.get(0).add(new ResultType(0, 0));
        history.get(1).add(new ResultType(0, 1));
        //loop
       for (int i = 2; i < stones.length; i++) {
           int distance = stones[i];
           for (int j = 0; j < i; j++) {
               int difference = distance - stones[j];
               if (jump[j]) {
               List<ResultType> his = history.get(j);
               for (ResultType r : his) {
                   int maxJump = r.lastUnits + 1;
                   int minJump = r.lastUnits - 1;
                   if (maxJump >= difference && minJump <= difference) {
                       jump[i] = true;
                       //store history
                       history.get(i).add(new ResultType(j, difference));
                       break;
                   }
               }
               }
           }
       }
       //answer
       return jump[stones.length - 1];
    }
}
