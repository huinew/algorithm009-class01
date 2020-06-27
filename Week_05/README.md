学习笔记
#### 买卖股票的最佳时机2
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii

```
 public int maxProfit(int[] prices) {
    if (prices.length <= 1){
        return 0;
    }
    
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++){
        if (prices[i] > prices[i - 1])
            maxProfit += (prices[i] - prices[i - 1]);
    }
    return maxProfit;
}
```

#### 跳跃游戏
https://leetcode-cn.com/problems/jump-game
在国际站官方题解里面，跳跃游戏给出了经典的动态规划类的解法，原文如下：https://leetcode.com/articles/jump-game/

解答动态规划类题目的四个步骤：

1. Start with the recursive backtracking solution
2. Optimize by using a memoization table (top-down3 dynamic programming)
3. Remove the need for recursion (bottom-up dynamic programming)
4. Apply final tricks to reduce the time / memory complexity

回溯法：
```
public class Solution {
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
}
```
时间复杂度 O(2^n)，空间复杂度O（n）。这种写法非常容易超时

##### 精选写法 python
```
class Solution:
    def canJump(self, nums) :
        max_i = 0       #初始化当前能到达最远的位置
        for i, jump in enumerate(nums):   #i为当前位置，jump是当前位置的跳数
            if max_i>=i and i+jump>max_i:  #如果当前位置能到达，并且当前位置+跳数>最远位置  
                max_i = i+jump  #更新最远能到达位置
        return max_i>=i
```
复杂度：时间复杂度 O(n)，空间复杂度 O(1)。