for the integer operation, it is not recommended that we transfer the int array to string, it may have overflow problem.

class Solution {
    public int[] plusOne(int[] digits) {
        //change int[] to a int
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }
        //string to int transformation may encounter overflow problem
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] num = new int[digits.length + 1];
        num[0] = 1;
        return num;
    }
}
