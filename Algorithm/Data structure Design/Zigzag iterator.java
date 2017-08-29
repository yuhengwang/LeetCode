public class ZigzagIterator {
    ArrayList<Integer> l = new ArrayList<>();
    int i = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int index = 0;
        int size1 = v1.size();
        int size2 = v2.size();
        while (index < Math.min(size1, size2)) {
            l.add(v1.get(index));
            l.add(v2.get(index));
            index++;
        }
        while (index < size1)   l.add(v1.get(index++));
        while (index < size2)   l.add(v2.get(index++));
    }

    public int next() {
        int n =  l.get(0);
        l.remove(0);
        return n;
        
    }

    public boolean hasNext() {
        return l.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
