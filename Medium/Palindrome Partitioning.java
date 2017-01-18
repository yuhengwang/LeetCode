public class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<List<String>> ();
        List<String> current = new ArrayList<String> ();
        
        helper(s,current,res,0);
        return res;
        
        
    }
    
    
    
    public void helper(String s, List<String> current, List<List<String>> res,int start) {
        
        if(start == s.length()){
            res.add(new ArrayList<String>(current));
        }
        else{
        for(int i = start; i < s.length() ;i ++) {
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start,i+1));
                helper(s,current,res,i+1);
                current.remove(current.size()-1);
            }
            
            
        }
            
        }
        
        
    }
    
    public boolean isPalindrome(String curr, int start, int end) {
      while(start < end) {
          if(curr.charAt(start++) != curr.charAt(end--)) return false;
      }
        
        return true;
        
        
    }
}
