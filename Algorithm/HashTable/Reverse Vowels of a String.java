Be careful about the boundary situation. !!! while (start < end), NOT while (start <= end)
class Solution {
    public String reverseVowels(String s) {
        //record its index
        //get all vowel out
        HashSet<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !set.contains(array[start])) start++;
            while (start < end && !set.contains(array[end])) end--;
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
            
        }
        return String.valueOf(array);
    }
}
