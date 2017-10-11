greedy, we first extract the highest people, and their second element is their relative position, and then
we extract the second highest people, and insert them into the arraylist at the index of their second element.
in the end, we use ArrayList function toArray(T<T>..) to transform the output format.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null || people[0].length == 0) {
            return new int[][]{};
        }
        Arrays.sort(people,new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            }
        });
        List<int[]> res = new ArrayList<>();
        res.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(people);
    }
}
