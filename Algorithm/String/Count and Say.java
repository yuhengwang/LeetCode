class Solution {
    public String countAndSay(int n) {
        StringBuilder prev = null;
        StringBuilder curr = new StringBuilder("1");
        int index = 0;
        while (++index < n) {
            prev = curr;
            curr = new StringBuilder();
            int count = 1;
            char say = prev.charAt(0);
            for (int i = 1; i < prev.length(); i++) {
                if (say == prev.charAt(i)) {
                    count++;
                } else {
                    curr.append(String.valueOf(count));
                    curr.append(say);
                    count = 1;
                    say = prev.charAt(i);
                }
            }
            //if the string end is 111, it will jump out of the loop without appending, so we append it here
            curr.append(String.valueOf(count));
            curr.append(say);
            
        }
        return curr.toString();
    }
}
