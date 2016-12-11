public class Solution {
    
    
    public char findTheDifference(String s, String t) {
        
     char [] listS = s.toCharArray();
     char [] listT = t.toCharArray();
     
     Arrays.sort(listS);
     Arrays.sort(listT);
     
     for(int i=0;i<listS.length;i++){
         
         if(listS[i]!=listT[i])
         
         return listT[i];
         
         
     }
     
     return listT[t.length()-1];
     
     
     
    }
    
    
}
