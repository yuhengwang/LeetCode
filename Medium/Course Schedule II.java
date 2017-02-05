public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int [] findOrder = new int[numCourses];
        int[] indegree = new int[numCourses];
        List [] edges = new ArrayList[numCourses];  // get all next-level courses
        for (int i = 0;i < numCourses; i++)
            edges[i] = new ArrayList<Integer>();
        // caculate indegree
         for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]] ++ ;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // put all 0 indegree into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
          //  System.out.println("key: " + i);
            if (indegree[i] == 0) {
                queue.offer(i);
            }
            
        }
        // bfs
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
          //  System.out.println("course: " + course);
            findOrder[count] = course;
            count ++;
            int size = edges[course].size();
            for (int i = size - 1; i >=0; i--) {
                int a= (int)edges[course].get(i);
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.offer(a);
                   // findOrder[index++] = a;
                }
            }
            
        }
        if (numCourses != count)
        return new int[0];
        else
        return findOrder;
    }
  
}
