public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        if (seqs == null || org == null || seqs.length == 0) {
            return false;
        }
        
        
        HashMap<Integer, Set<Integer>> keyValue = new HashMap<>();
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        for (int i : org) {
            keyValue.put(i, new HashSet<Integer>());
            indegrees.put(i, 0);
        }
        int count = 0;
        for (int i = 0; i < seqs.length; i++) {
            count += seqs[i].length;
            if (seqs[i].length >= 1 && (seqs[i][0] < 0 || seqs[i][0] > org.length)) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                if (seqs[i][j] < 0 || seqs[i][j] > org.length) {
                    return false;
                }
                    if (keyValue.get(seqs[i][j - 1]).add(seqs[i][j]))
                    indegrees.put(seqs[i][j], indegrees.get(seqs[i][j]) + 1);
            }
        }
        if (count < org.length) {
            return false;
        }
      //  HashMap<Integer, Integer> indegrees = new HashMap<>();
        // for (Integer key : keyValue.keySet()) {
        //     Set<Integer> set = keyValue.get(key);
        //     for (Integer neighbor : set) {
        //         if (indegrees.containsKey(neighbor)) {
        //             indegrees.put(neighbor, indegrees.get(neighbor) + 1);
        //         } else {
        //             return false;
        //         }
        //     }
        // }
     
       
        // int size = 0;
        // ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : indegrees.keySet()) {
            if (indegrees.get(key) == 0) {
                queue.offer(key);
              //  res.add(key);
             //   size++;
            }
        }
        int cnt = 0;
        while (queue.size() == 1) {
            Integer cur = queue.poll();
            cnt++;
            for (Integer neighbor : keyValue.get(cur)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return cnt == org.length;
    //     if (size > 1 && org.length > 1) {
    //         return false;
    //     }
       
    //     while (!queue.isEmpty()) {
    //         Integer cur = queue.poll();
    //       //  System.out.println(cur);
    //         size = 0;
    //         if (keyValue.get(cur) == null ) {
    //             break;
    //         }
    //         for (Integer neighbor : keyValue.get(cur)) {
    //         //    System.out.println(neighbor);
    //             indegrees.put(neighbor, indegrees.get(neighbor) - 1);
    //             if (indegrees.get(neighbor) == 0) {
    //                 queue.offer(neighbor);
    //                 res.add(neighbor);
    //                 size++;
    //             }
    //         }
    //         if (size > 1 && org.length > 1) {
    //             return false;
    //         }
    //     }
    //     int index = 0;
    //  //   System.out.println(res);
    //     if (org.length != res.size()) {
    //         return false;
    //     }
    //     for (Integer a : res) {
    //         if (org[index++] == a) {
                
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    }
}
