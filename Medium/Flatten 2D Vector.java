public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
       hasNext();
       return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
      
    }

    @Override
    public void remove() {
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
