package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap <Integer, Integer>(nums.length);

       for (int i  = 0; i < nums.length; i++){
           map.put(nums[i], i);
       }

       for (int j = 0; j < nums.length; j++){
           int element = target - nums[j];
           if (map.containsKey(element) && map.get(element) != j){
               return new int[]{j, map.get(element)};
           }
       }
       return null;
    }

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int[] result = twoSum(nums, 6);
        for (int num : result){
            System.out.println(num);
        }
    }
}
