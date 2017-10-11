class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)   return true;
        int[] step = new int[2];
        //up, down --> 0 left, right --> 1
        char[] array = moves.toCharArray();
        for (int i = 0; i < moves.length(); i++) {
            if (array[i] == 'U') {
                step[0]++;
            }
            if (array[i] == 'D') {
                step[0]--;
            }
            if (array[i] == 'L') {
                step[1] ++;
                
            }
            if (array[i] == 'R') {
                step[1]--;
            }
        }
        return step[0] == 0 && step[1] == 0;
    }
}
