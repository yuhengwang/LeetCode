class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long ans = 0;
        int num = key.length;
        long result = 0;
        for (int i = 0; i < num; i++) {
               ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
        }
        return (int)ans;
    }
}
