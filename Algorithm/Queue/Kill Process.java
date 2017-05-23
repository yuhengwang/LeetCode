//leetcode 582
使用hashmap来记录父过程的数字及其对应的index。
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ppid.get(i), list);
            } else {
                map.get(ppid.get(i)).add(i);
            }
        }
        List<Integer> toKill = new ArrayList<>();
        toKill.add(kill);
        Queue<Integer> killing = new LinkedList<>();
        killing.offer(kill);
        while (!killing.isEmpty()) {
            int size = killing.size();
            for (int i = 0; i < size; i++) {
                int n = killing.poll();
                 if (map.containsKey(n)) {
                    List<Integer> killList = map.get(n);
                    for (int k : killList) {
                        toKill.add(pid.get(k));
                        killing.offer(pid.get(k));
                    }
                }
            }
        }
        return toKill;
    }
}
