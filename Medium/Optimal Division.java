public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                sb.append("/(").append(nums[i]);
            } else {
                sb.append("/").append(nums[i]);
            }
        }
         return nums.length > 2 ? sb.append(")").toString() : sb.toString();
    }
}

//brute force, but without memory, repetive calculate same thing, not effetive
public class Solution {
    class T {
        float min_val, max_val;
        String min_s, max_s;
    }
    public String optimalDivision(int[] nums) {
        T res = optimal(nums, 0, nums.length - 1);
        return res.max_s;
    }
    public T optimal(int[] nums, int start, int end) {
        T t = new T();
        if (start == end) {
            t.min_val = nums[start];
            t.max_val = nums[end];
            t.min_s = "" + nums[start];
            t.max_s = "" + nums[end];
            return t;
        }
        t.min_val = Float.MAX_VALUE;
        t.max_val = Float.MIN_VALUE;
        for (int i = start; i < end; i++) {
            T left = optimal(nums, start, i);
            T right = optimal(nums, i + 1, end);
            if (t.min_val > left.min_val / right.max_val) {
                t.min_val = left.min_val / right.max_val;
                t.min_s = left.min_s + "/"  + (i + 1 != end ? "(" : "") +  right.max_s + (i + 1 != end ? ")" : "");
            }
            if (t.max_val < left.max_val / right.min_val) {
                t.max_val = left.max_val / right.min_val;
                t.max_s =  left.max_s + "/"  + (i + 1 != end ? "(" : "") + right.min_s + (i + 1 != end ? ")" : "");
            }
            
        }
        return t;
    }
}


// with memory
public class Solution {
    class T {
        float min_val, max_val;
        String min_s, max_s;
    }
    public String optimalDivision(int[] nums) {
        HashMap<String, T> memory = new HashMap<>();
        T res = optimal(nums, 0, nums.length - 1, memory);
        return res.max_s;
    }
    public T optimal(int[] nums, int start, int end, HashMap<String, T> memory) {
        String key = start + " " + end;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        T t = new T();
        if (start == end) {
            t.min_val = nums[start];
            t.max_val = nums[end];
            t.min_s = "" + nums[start];
            t.max_s = "" + nums[end];
            return t;
        }
        t.min_val = Float.MAX_VALUE;
        t.max_val = Float.MIN_VALUE;
        for (int i = start; i < end; i++) {
            T left = optimal(nums, start, i, memory);
            T right = optimal(nums, i + 1, end, memory);
            if (t.min_val > left.min_val / right.max_val) {
                t.min_val = left.min_val / right.max_val;
                t.min_s = left.min_s + "/"  + (i + 1 != end ? "(" : "") +  right.max_s + (i + 1 != end ? ")" : "");
             
            }
            if (t.max_val < left.max_val / right.min_val) {
                t.max_val = left.max_val / right.min_val;
                t.max_s =  left.max_s + "/"  + (i + 1 != end ? "(" : "") + right.min_s + (i + 1 != end ? ")" : "");
              
            }
            
        }
        memory.put(key, t);
        return t;
    }
}
