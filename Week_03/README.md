学习笔记

### 括号生成

```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
```

```
     static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n){
        generate(0, 0, n, "");
        return result;
    }

    private static void generate(int left,int right, int n, String s) {
        terminate
        if (left == n && right == n){
            result.add(s);
            System.out.println(s);
            return;
        }

        process current,left:(, right")"
        drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right){
            generate(left , right + 1, n, s +")");
        }
    }
```
Move Votes Top2解法
```
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        addingpar(res, "", n, 0);
        return res;
    }
    void addingpar(vector<string> &v, string str, int n, int m){
        if(n==0 && m==0) {
            v.push_back(str);
            return;
        }
        if(m > 0){ addingpar(v, str+")", n, m-1); }
        if(n > 0){ addingpar(v, str+"(", n-1, m+1); }
    }
};
```

官方题解
```

        static ArrayList[] cache = new ArrayList[100];
        public static List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generate(c))
                        for (String right: generate(n - 1 - c))
                            ans.add("(" + left + ")" + right);
            }
            cache[n] = ans;
            return ans;
        }
        public static List<String> generateParenthesis(int n) {
            return generate(n);
        }

```

### 爬楼梯
解法一：动态规划
```
public  int climbStairs(int n) {
    int[] cache = new int[n +1];
    if (n ==0)
      return 0;
    if (n == 1)
        return 1;
    if (n ==2)
        return 2;

    int[] dp = new int[n +1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i<= n; i++){
        dp[i] = dp[i - 2] + dp[i - 1];
    }
    return dp[n];
}
```

解法二：带缓存的递归
```

    public  int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return climbStairsRecur(0, n, cache);
    }

    private  int climbStairsRecur(int i, int n,int[] cache) {
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }

        if (cache[i] > 0){
            return cache[i];
        }

        cache[i]  = climbStairsRecur(i +1, n, cache) + climbStairsRecur(i + 2, n, cache);
        return cache[i];
    }
```
解法三：暴力解题
基本就是解法二这边去掉cache。但不建议，因为容易超时，时间复杂度是指数级的。

解法四：斐波那契数
Most Votes：
```
public int climbStairs(int n) {
     base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}
```
