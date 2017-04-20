// TreeSet remove need logn time complexity. use id to record the recentness.
public class LFUCache {
     class Node implements Comparable<Node>{
         int key;
         int frequency;
         int r;
         public Node (int key, int frequency, int r) {
             this.key = key;
             this.frequency = frequency;
             this.r = r;
         }
        public boolean equals(Object object) {return key==((Node) object).key;}
        public int hashCode() {return key;}
        public int compareTo(Node o) {return key==o.key?0:frequency==o.frequency?r-o.r:frequency-o.frequency;}
         
     }
    int size = -1;
    TreeSet<Node> queue;
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, Integer> keyValue = new HashMap<>();
    int id;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        size = capacity;
        id = 0;
        queue = new TreeSet<>(); 
        
    }

    public void set(int key, int value) {
        // Write your code here
        id++;
        Node current = new Node(key, 1, id);
        if (map.containsKey(key)) {
           update(key);
           keyValue.put(key, value);
            return;
        }
        if (keyValue.size() == size) {
            Node delete = queue.pollFirst();
            map.remove(delete.key);
            keyValue.remove(delete.key);
        }
        map.put(key, current);
        queue.add(current);
        keyValue.put(key, value);
        
    }


    public int get(int key) {
        id++;
        if (!map.containsKey(key)) {
            return -1;
        }
        update(key);
        return keyValue.get(key);
        
    }
  
    public void update(int key) {
        Node cur = map.get(key);
        int f = cur.frequency;
        queue.remove(cur);
        Node newNode = new Node(key, f + 1, id);
        map.put(key, cur);
        queue.add(newNode);
    }
}
//val to record key and value, counts to record key and appear times, and lists is to record the insertion order under same appear times
public class LFUCache {
    HashMap<Integer, Integer> val = new HashMap<>();
    HashMap<Integer, Integer> counts = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> lists = new HashMap<>();
    int capacity;
    int min = -1;
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        lists.put(1, new LinkedHashSet<Integer>());
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (val.containsKey(key)) {
            get(key);
            val.put(key, value);
            return;
        }
        if (val.size() == capacity) {
            int delete = lists.get(min).iterator().next();
            val.remove(delete);
            lists.get(min).remove(delete);
        }
        val.put(key, value);
        min = 1;
        counts.put(key, 1);
        lists.get(1).add(key);
    }

    public int get(int key) {
        // Write your code here
        
        if (val.containsKey(key)) {
            int count = counts.get(key);
            lists.get(count).remove(key);
            if (count == min && lists.get(count).size() == 0) {
                min++;
            }
            count++;
            counts.put(key, count);
            if (lists.get(count) == null) {
                lists.put(count, new LinkedHashSet<Integer>());
            }
            lists.get(count).add(key);
            return val.get(key);
        } else {
            return -1;
        }
    }
}
