public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int j=0;
        for(int i=0;i<g.length;i++){
            
            if(j>s.length-1){
                break;
            }
            
           if(g[i]<=s[j])
              {
                  num++;
                  j++;
                  
              }
              
              else{
                  j++;i--;
              }
           
           
            
          
        }
        
        return num;
        
    }
}
