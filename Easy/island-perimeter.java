public class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int perimeter=0;
        
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[i].length;j++){
                
               int numOfSides = 0;
                
                if(grid[i][j]==1){
                    
                    if(i-1<0)
                    numOfSides++;
                    else{
                        if(grid[i-1][j]==0)
                        numOfSides++;
                        
                    }
                    
                    
                    
                    if(j-1<0)
                    numOfSides++;
                      else{
                        if(grid[i][j-1]==0)
                        numOfSides++;
                        
                    }
                    
                    
                    
                    if(i+1>grid.length-1)
                    numOfSides++;
                      else{
                        if(grid[i+1][j]==0)
                        numOfSides++;
                        
                    }
                    
                    
                    
                    if(j+1>grid[i].length-1)
                    numOfSides++;
                      else{
                        if(grid[i][j+1]==0)
                        numOfSides++;
                        
                    }
                    
                    
                    
                    
                    
                }
                
                perimeter+=numOfSides;
            }
        }
        
        return perimeter;
        
        
        
        
    }
}


//another method 4*islands - 2*neighborhoods

public class Solution {
    public int islandPerimeter(int[][] grid) {
    
       int islands = 0;
       int neighborhoods=0;
       
       for(int i=0;i< grid.length; i++){
           for(int j=0;j<grid[i].length;j++){
               
               if(grid[i][j]==1){
                   
                   islands++;
                   
                   if(i<grid.length-1&&grid[i+1][j]==1)  neighborhoods++;
                   if(j<grid[i].length-1&&grid[i][j+1]==1)  neighborhoods++;
                   
               }
               
           }
           
           
           
       }
        
        
        
        return 4*islands-2*neighborhoods;
        
        
    }

}
