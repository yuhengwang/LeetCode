The important thing is to consider all edge cases while thinking this problem through, including: negative integer, possible overflow, etc.

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        //construct the integer part
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        //check the negative
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        //store the long number and its corresponding index
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.toString().length());
            }
        }
        return sb.toString();
    }
}
