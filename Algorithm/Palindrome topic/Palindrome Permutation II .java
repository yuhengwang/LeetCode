One idea to do so is to generate only the first half of the palindromic string and to append its reverse string to itself to 
generate the full length palindromic string.Based on this idea, by making use of the number of occurences of the characters in 
s stored in map, we create a string st which contains all the characters of s but with the number of occurences of 
these characters in st reduced to half their original number of occurences in s.

In case of a string s with odd length, whose palindromic permutations are possible, one of the characters in s must be occuring 
an odd number of times. We keep a track of this character, ch, and it is kept separte from the string st. We again generate 
the permutations for st similarly and append the reverse of the generated permutation to itself, but we also place the character 
ch at the middle of the generated string. 
running time decrease from 290+ms to 11ms
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        boolean[] used = new boolean[s.length() / 2];
        //check whether it is suitable for permutation first
        if (!permute(s, map)) {
            return res;
        }
        char ch = 0;
        int k = 0;
        for (int i = 0; i < 128; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] % 2 == 1) {
                ch = (char)i;
            }
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char)i;
            }
        }
        //Arrays.sort(st); //because st already sort in ASCII order
        permutation(st, ch, "", used);
        return res;
    }

    public void permutation(char[] st, char ch, String temp, boolean[] used) {
        if (temp.length() == st.length) {
        //    System.out.println("ddd");
            res.add(temp + (ch == 0 ? "" : ch) + new StringBuffer(temp).reverse());
        } else {
             for (int i = 0; i < st.length; i++) {
                if (used[i] || (i > 0 && st[i] == st[i - 1] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                permutation(st, ch, temp + st[i], used);
                temp = temp.substring(0, temp.length());
                used[i] = false;
        }
        }
    }

    public boolean permute(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < 128 && count <= 1; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i) {
                    map[i]++;        
                }            
            }
            count += map[i] % 2;
        }
        return count <= 1;
    }
   
    //o(N)
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}











//we wildly generate all permutation, without considering they are palindrome or not
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] array = s.toCharArray();
        //check whether it is suitable for permutation first
        if (!permute(s)) {
            return res;
        }
        Arrays.sort(array);//nlogn
        permutation(array, res, used, "");
        return res;
    }
    public boolean permute(String s) {
        int count = 0;
        for (int i = 0; i < 128 && count <= 1; i++) {
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i) {
                    cnt++;        
                }            
            }
            count += cnt % 2;
        }
        return count <= 1;
    }
    public void permutation(char[] array, List<String> res, boolean[] used, String temp) {
   //     System.out.println(temp);
        if (temp.length() == array.length) {
            if (isPalindrome(temp)) {
                res.add(temp);
                return;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] || (i > 0 && array[i] == array[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            permutation(array, res, used, temp + array[i]);
            temp = temp.substring(0, temp.length());
            used[i] = false;
        }
    }
    //o(N)
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
