class Solution {
    //List<List<String>> addAll (List<List<STring>>)
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> res = new ArrayList<>();
                res.add(s);
                map.put(key, res);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> v : map.values()) {
            res.add(v);
        }
        return res;
    }
}
