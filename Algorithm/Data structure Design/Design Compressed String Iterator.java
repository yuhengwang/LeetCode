//store the difference between the character and 'A', and store it in integer format
class StringIterator {
    Queue<int[]> queue = new LinkedList<>();
    public StringIterator(String compressedString) {
     //   queue.clear();
        for (int i = 0; i < compressedString.length(); i++) {
            //get num
            int j = i + 1;
         //   System.out.println("ee");
            while (j < compressedString.length() && compressedString.charAt(j) >= '0' && compressedString.charAt(j) <= '9') {
           //     System.out.println(j);
                j++;
            }
            int num = Integer.parseInt(compressedString.substring(i + 1, j));
            char c = compressedString.charAt(i);
            int[] element = new int[]{c - 'A', num};
       //     System.out.println(num);
         //   System.out.println(c);
            queue.offer(element);
            i = j - 1;
        }
    }
    
    public char next() {
        if (hasNext()) {
            int[] element = queue.peek();
            if (element[1] == 1) {
                queue.poll();
                
            } else {
                element[1]--;
            }
            return (char)(element[0] +'A');
        } 
            return ' ';
        
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
