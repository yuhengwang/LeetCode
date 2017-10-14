class Solution {
    public boolean isStrobogrammatic(String num) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(6,9);
        map.put(1,1);
        map.put(9,6);
        map.put(8,8);
        map.put(0,0);
        for (int i = 0; i < num.length() / 2 + 1; i++) {
            int n = Integer.parseInt(num.charAt(i) + "");
            int m = Integer.parseInt(num.charAt(num.length() - i - 1) + "");
            if (map.containsKey(n) && map.get(n) == m) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
