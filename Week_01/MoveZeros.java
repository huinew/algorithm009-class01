package com.example.leetcode;

import java.util.ArrayList;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
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
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 12, 0};
        int[] nums2 = {0, 1, 0, 3, 12};
        int[] nums3 = {0, 0};
        int[] nums4 = {1, 0, 3};
        int[] nums9 = {1, 2, 3};
        int[] nums5 = {1, 0};
        int[] nums6 = {0, 1};
        int[] nums7 = {0, 4, 0, 1};
        int[] nums8 = {};
        moveZeroes(nums2);
        for (int num : nums2
        ) {
            System.out.println(num);
        }
    }

}
