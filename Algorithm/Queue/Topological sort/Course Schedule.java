//instead of using HashMap<Integer, Integer> to track indegree, we can use int[], and we build int[][] matrix to track the prerequiste and
after class information
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //special condition
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) {
            return true;
        }
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];  //pre--> course
        for (int[] p : prerequisites) {
            matrix[p[0]][p[1]] = 1;
            indegree[p[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int c = queue.poll().intValue();
            for (int i = 0; i < matrix[c].length; i++) {
                if (matrix[c][i] == 1) {
                    matrix[c][i] = 0;
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
