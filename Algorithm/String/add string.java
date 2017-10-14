//similar to linkedlist add operation
class Solution {
    //12 + 321
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i >= 0 ? Integer.parseInt(num1.charAt(i) + "") : 0;
            int y = j >= 0 ? Integer.parseInt(num2.charAt(j) + "") : 0;
            sb.append( (x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            
        }
       
        return sb.reverse().toString();
    }
}
