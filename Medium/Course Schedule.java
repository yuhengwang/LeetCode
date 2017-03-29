public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        HashMap<Integer, Set<Integer>> courses = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                indegrees.put(prerequisites[i][j], 0);
            }
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (courses.containsKey(prerequisites[i][1])) {
                if (courses.get(prerequisites[i][1]).add(prerequisites[i][0])) {
                    indegrees.put(prerequisites[i][0], indegrees.get(prerequisites[i][0]) + 1);
                }
            } else {
                Set<Integer> lists = new HashSet<>();
                lists.add(prerequisites[i][0]);
                courses.put(prerequisites[i][1], lists);
                indegrees.put(prerequisites[i][0], indegrees.get(prerequisites[i][0]) + 1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.offer(course);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (courses.get(cur) == null) {
                continue;
            }
            
            for (Integer sub : courses.get(cur)) {
                indegrees.put(sub, indegrees.get(sub) - 1);
                if (indegrees.get(sub) == 0) {
                    queue.offer(sub);
                }
            }
        }
        for (int value : indegrees.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
