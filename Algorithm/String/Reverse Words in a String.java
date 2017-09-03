//same idea for the II, but there is more leading and trailing space between the word, we need to consider.
This method has O(1) space complexity, no stringbuilder, trim and split
public class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
       //reverse the whole String
        reverse(array, 0, s.length() - 1);
        //reverse each word
        reverseWord(array);
        //reverse the last word
        return cleanSpace(array);
    }
    public void reverse(char[] array, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char c = array[i];
            array[i] = array[j];
            array[j] = c;
        }
    }
    public String cleanSpace(char[] array) {
        int i = 0;
        int j = 0;
        int n = array.length;
        while (j < n) {
            while (j < n && array[j] == ' ') j++;  //skip space
            while (j < n && array[j] != ' ')    array[i++] = array[j++]; //copy non-space word
            while (j < n && array[j] == ' ') j++;  //skip space
            //check whether array is finished scanning
            if (j < n)
                array[i++] = ' ';
        }
        return String.valueOf(array).substring(0, i);
    }
    public void reverseWord(char[] array) {
        int i = 0;
        int j = 0;
        int n = array.length;
        while (i < n) {
            while (i < j || i < n && array[i] == ' ')   i++;
            while (j < i || j < n && array[j] != ' ')   j++;
            reverse(array, i, j - 1);
        }
        
    }
}
