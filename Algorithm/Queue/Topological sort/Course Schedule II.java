special condition we need to consider, first: there is no available order, second, there is no prerequisite order, which means any combination
of the course is okay
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0) {
            while (numCourses-- > 0) {
                order[numCourses] = numCourses;
            }
            return order;
        }
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            matrix[p[1]][p[0]] = 1;
            indegree[p[0]]++;
        }
        //put 0 indegree into queue
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll().intValue();
            order[index++] = c;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[c][j] == 1) {
                    matrix[c][j] = 0;
                    if (--indegree[j] == 0) {
                        count++;
                        queue.offer(j);
                    }
                }
            }
        }
        return count == numCourses ? order : new int[]{};
    }
}
