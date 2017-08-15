The difference between call once and call multiple times is
Think that you have 4 chars "a, b, c, d" in the file, and you want to call your function twice like this:
1.read(buf, 1); // should return 'a'
2.read(buf, 3); // should return 'b, c, d'

All the 4 chars will be consumed in the first call. So the tricky part of this question is 
how can you preserve the remaining 'b, c, d' to the second call.

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
        //only when buffPtr is 0, read more word
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            //testing break while loop is because ptr > n or buffPtr > buffCnt
            if (buffPtr >= buffCnt) buffPtr = 0;
        }
        return ptr;
    }
}
