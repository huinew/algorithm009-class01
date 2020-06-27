package com.example.leetcode;

import java.util.Arrays;

public class ShareBuscuit {
    public static int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;

        int i,j;
        i = j = 0;
        int res = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while(i < gLen && j < sLen){
            if (s[j] >= g[i]){
                res++;
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array1  = {1,2,3};
        int[] array2 = {1,1};
        findContentChildren(array1, array2);
    }
}
