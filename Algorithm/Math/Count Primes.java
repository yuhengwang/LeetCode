class Solution {
    public int countPrimes(int n) {
    //initially all number is prime
        boolean[] Prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
        //because 2 is prime, we know it, so starting from 2
            if (!Prime[i]) {
                count++;
            }
            //when we can a prime number, we found all its multiple less than n, and 
            //set them as non-prime
            for (int j = 2; j * i < n; j++) {
                Prime[j * i] = true;
            }
        }
        return count;
    }
}
