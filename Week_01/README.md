算法学习笔记
## 方法论

## 算法训练笔记

### Q1：move zero
解法一：遍历数组，用双指针法，一个变量存储第一个遇到的非0数字下标，另一个遍历存储当前所遇到的0数字下标。将这两个位置所指向的数字进行交换
时间复杂度：O(n),空间复杂度O(1)
```

```

解法二：遍历数组，也是用双指针法，只不过是将非0数字放到前面，并计算这些非0数字的个数。遍历完后再起一个for循环，将数组末尾的0填充上
时间复杂度：O(n)，空间复杂度O(1)
```
 // 记录为0的下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
```

解法三：新起一个辅助数组，初始化为0，遍历第一个数组，将非0数字都拷到新数组里即可
时间复杂度：O(n)，空间复杂度O(n)
由于题目说必须在原数组上操作，不能拷贝额外的数组，所以解法三被放弃。

### Q2:盛最多水的容器
自己的思考：
解法一：枚举，(x-y) * heigh_diff,计算出里面最大的值
这样的时间复杂度是O（n²）
解法二：用双指针夹逼法，就是左边界和右边界往中间收敛，每次只取高度最高的那个杆来移动，当然左边界不能超过右边界。
这样的实际复杂度是O（n）

MOST VOTES题解TOP3：

https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation

这个是python解法，按其思路改造了Java版本的，非常清晰，时间复杂度O(n)，空间复杂度O（1）：
```
int maxArea(int[] height){
    int i = 0; 
    int j = height.length - 1;
    int area = 0;
    while (i < j){
        area = Math.max(area, (j - i) * Math.min(height[i], height[j]);
        height[i] < height[j]? i++ : j--;
    }
    return area;
}
```
在此基础上出了一个性能优化版：
```
public int maxArea(int[] height) {
    int max=0, left=0, right=height.length-1;
    while (left < right) {
        int area = (right-left) * Math.min(height[left], height[right]);
        max = Math.max (max, area);
        
        if (height[left] < height[right]) {
            int i = left;
            while (height[left] <= height[i] && left < right) left++;
        } else {
            int j = right;
            while (height[j] >= height[right] && left < right) right--;
        }
    }
    
    return max;
}
```
### Q3:爬楼梯
解法一：这个第一感觉就是跟斐波那契很像，基本公式就是f(n) = f(n-1)+f(n-2)，可以用个数组来存储
基本是O（logN）

解法二：直接用三个中间变量来存储

### Q4:两数之和
解法一：暴力解法，因为一个target只有一个结果，最暴力的做法就是遍历。时间复杂度O（n²）
```
    //伪代码
    for (i = 0; i < nums.length; i++){
        for (j = i + 1; j < nums.length; j++){
           if  -target == nums[i] + nums[j]
           array[0] = i, array[1] = j;
        }
    }
```
解法二：一遍哈希表
进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素
```
    Map<Integer, Integer> map = new HashMap <Integer, Integer>(nums.length);

    for (int j = 0; j < nums.length; j++){
        int element = target - nums[j];
        if (map.containsKey(element) ){
            return new int[]{map.get(element),j};
        }
        map.put(nums[j], j);
    }
   return null;
```
解法三：两遍哈希表
for循环两次，先将所有元素都放进去后，再用target减去首个被减数，然后查找结果是否在map里。时间复杂度O(n)，空间复杂度也是O（n）
```
public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

```

Most Votes Top3:

https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution

## 课后作业

### 用最新的api改写Deque的示例代码
package com.example.leetcode.homework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeDemo {

    public static void main(String[] args){
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("first input");
        deque.addFirst("second input");
        deque.addFirst("third input");

        System.out.println(deque);

        String topElement = deque.peek();
        System.out.println(topElement);
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque);

    }
}

### 分析Queue的源码

