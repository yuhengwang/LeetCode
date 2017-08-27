 一条路径会先出来。 到达文件的时候，会出现。，此时再计算总路径。， s.lastIndexOf("\t")可以反映出该string在第几层。
 第一层是没有-1， 第二层是0， 第三层是1.
class Solution {
    public int lengthLongestPath(String input) {
        String[] path = input.split("\n");
        int[] stack = new int[path.length + 1];
        int maxLength = 0;
        for (String s : path) {
            int id = s.lastIndexOf("\t") + 1;
            int curLength = stack[id + 1] = stack[id] + s.length() - id + 1; 
            if (s.contains("."))    maxLength = Math.max(maxLength, curLength - 1);
        }
        return maxLength;
        
    }
}
