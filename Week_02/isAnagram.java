package com.example.leetcode;

import java.util.Arrays;

public class isAnagram {
    public boolean isAnagram1(String s, String t) {
        char[] count = new char[26];

        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length();i++){
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count){
            if (i != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
    public static void main(String[] args){
        System.out.println(isAnagram2("car", "rac"));
    }
}
