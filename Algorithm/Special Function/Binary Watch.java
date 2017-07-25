// the use of Integer.bitCount!!!
// we multiply hour by 64, is to left rotate it by 6 bits, 
// there are many other special function regarding to bit manipulation in Integer class
// check it!
// 

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                int count = Integer.bitCount(hour * 64 + minute); //* 64 rotate it to left by 6 bits
                if (count == num) {
                    res.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return res;
    }
}
