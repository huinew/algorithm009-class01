package com.example.leetcode;

public class ClimbStairs {

    public static int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return climbStairsRecur(0, n, cache);
    }

    private static int climbStairsRecur(int i, int n,int[] cache) {
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }

        if (cache[i] > 0){
            return cache[i];
        }

        return climbStairsRecur(i +1, n, cache) + climbStairsRecur(i + 2, n, cache);
    }

    public static void main(String[] args){
        System.out.println(climbStairs(4));
    }
}
