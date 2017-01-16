public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List <Integer> res = new ArrayList <Integer> ();
        for (int i = 0; i < rowIndex + 1; i++) {
            System.out.println("i: "+i);
            res.add(1);
            for(int j = i - 1; j > 0; j--) {
                System.out.println("j: "+j);
                res.set(j,res.get(j)+res.get(j-1));
            }
        }
        
        return res;
      
    }
}
