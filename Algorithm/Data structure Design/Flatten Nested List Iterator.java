When we design a data structure, we should first think which additional data structre
can be used to implement this funciton. Stack, Queue, HashMap, so on

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
       for (int i = nestedList.size() - 1; i >= 0; i--) {
           stack.push(nestedList.get(i));
       }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        //jump out of the while loop only when we have at least one integer!
        while (!stack.isEmpty()) {
            NestedInteger n = stack.peek();
            if (n.isInteger()) {
                return true;
            }
        //it is a list, we need to flatten it
            stack.pop();
            List<NestedInteger> l = n.getList();
            for (int i = l.size() - 1; i >= 0; i--) {
                stack.push(l.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
