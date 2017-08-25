/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
    //find out the celebrity first
        int candidate = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        //test whether it is real celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
         return candidate;
    }
}
