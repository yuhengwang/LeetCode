public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List < Integer> first = new ArrayList <Integer> ();
        List <List<Integer>> res= new ArrayList<List<Integer>> ();
        first.add(1);
        
        if(numRows ==1){
        
         res.add(first);
         return res;
        
        }
        Object [] previous = first.toArray();
        
        if(numRows > 1) {
        
        for(int i = 0; i < numRows; i ++) {
            int number = i+1;
            Integer [] temp = new Integer [number];
            temp[0] = 1;  // the first one is always 1
            temp[number -1] =1;  // last one...
            
            for( int j = 1; j < number -1 ; j++) {
                
                temp[j] = (int)previous[j] + (int)previous [j-1];
            }
            
            previous = temp.clone();
            
            List < Integer> ans =  Arrays.asList(temp);
            res.add(ans);
            
            
            
        }
            
        }
        
        return res;
        
    }
}


//
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List < Integer> row = new ArrayList <Integer> ();
        List <List<Integer>> res= new ArrayList<List<Integer>> ();
        
        for(int i=0; i < numRows ; i++) {
           
            row.add(1);
            
            for(int j=i-1; j>0;j--){
                row.set(j,row.get(j)+row.get(j-1));
            }
            
            
            res.add(new ArrayList <Integer>(row));
            
            
        }
        
        return res;
        
    }
}
