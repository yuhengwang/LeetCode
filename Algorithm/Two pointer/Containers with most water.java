two pointers in opposite direction...
public class Solution {
    public int maxArea(int[] num) {
    int max = 0;
		if(num == null || num.length == 0)
			return max;
		int left = 0, right = num.length - 1;
		while(left < right){
			int water = Math.min(num[left], num[right])*(right-left);
			max = Math.max(water, max);
			if(num[left] < num[right])
				left++;
			else
				right--;
		}
	return max;
    }
}
