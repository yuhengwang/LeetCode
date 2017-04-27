1.
首先，我们有两个鸡蛋，那么第一个鸡蛋一定是按照一定的间距来扔的，通过第一个鸡蛋找到的间距中再一个一个的试过去。
举个例子，假如当前我们要解决的问题是100层楼，那么假如我们一开始按照10作为间距的话，如果n是9的话，我们就要扔一次第一个鸡蛋，扔9次第二个鸡蛋，也就是需要10次，但这个明显不是最坏的情况，如果n是99的话，我们就需要扔10次第一个鸡蛋，扔9次第二个鸡蛋，那么需要19次。这种情况就是最坏的情况，现在再反过来想，我们一开始以10作为间距真的是最优的解吗，很明显如果我们是以等间距扔第一个鸡蛋的话我们每一个区间的最坏查询情况都是不相等的，最坏的查询情况肯定是最后一个区间的最后一个数。

2.
那么再想，如果我们能够让每一个区间的最坏查询次数都相等的话，最坏的查询就能够达到最优的方案，那么怎么才能达到这个条件呢。
仔细思考，查询到第二个区间的时候已经扔了一次第一个鸡蛋了，查询到第x个区间的时候已经扔了x-1次第一个鸡蛋了，所以显然如果我们等间距的话我们每一个区间的查询都要比前面一个区间多1次，所以我们可以每过一个区间把区间长度-1，这样就能够达到最佳的方案。
那么最大的那个区间怎么进行计算呢？
其实到这一步不难发现，这个最大区间就是我们要求的最坏的情况的查询数了。
n + (n-1) + (n-2)…… + 1 = N。
这样我们就可以用简单的循环来求得这个n。
public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (getSum(mid) > n) {
                end = mid;
            } else if (getSum(mid) < n) {
                start = mid;
            } else {
                start = mid;
            }
        }
        if (getSum(start) >= n)
            return Math.abs(getSum(start) - n) >= Math.abs(getSum(end) - n) ? end : start;
        else
            return end;
        
    }
    public long getSum(int n) {
        long res = 0;
        while (n > 0) {
            res += n;
            n--;
        }
        return res;
    }
}
