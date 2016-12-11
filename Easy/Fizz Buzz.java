public class Solution {
    public List<String> fizzBuzz(int n) {
        
        
        
        List <String> answer = new ArrayList <String>();
        
        
        for(int i=1;i<=n;i++){
            
            answer.add(getString(i));
            
        }
        
        return answer;
        
    }
    
    
    public String getString ( int number){
       
       
        if(number%3==0&&number%5==0){
            return "FizzBuzz";
        }
       
       
        if(number%3==0)
        {
            return "Fizz";
        }
        if(number%5==0){
            return "Buzz";
        }
        
        return String.valueOf(number);
        
        
    }
}
