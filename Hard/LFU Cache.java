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

