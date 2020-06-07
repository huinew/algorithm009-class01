package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
//     static List<String> result = new ArrayList<>();
//
//    public static List<String> generateParenthesis(int n){
//        generate(0, 0, n, "");
//        return result;
//    }
//
//    private static void generate(int left,int right, int n, String s) {
//        //terminate
//        if (left == n && right == n){
//            result.add(s);
//            System.out.println(s);
//            return;
//        }
//
//        //process current,left:(, right")"
//        //drill down
//        if (left < n) {
//            generate(left + 1, right, n, s + "(");
//        }
//        if (left > right){
//            generate(left , right + 1, n, s +")");
//        }
//    }

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
         generate(0, 0, n, new StringBuffer());
         return result;
    }

    private void generate(int left, int right, int n, StringBuffer stringBuffer) {
        if (stringBuffer.length() == 2 * n){
            result.add(stringBuffer.toString());
            return;
        }

        //process
        if (left < n){
            stringBuffer.append("(");
            generate(left + 1, right, n, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (right < left){
            stringBuffer.append(")");
            generate(left, right + 1, n, stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }


//
//        public static List<String> generateParenthesis(int n) {
//            List<String> ans = new ArrayList();
//            backtrack(ans, new StringBuilder(), 0, 0, n);
//            return ans;
//        }
//
//        public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
//            if (cur.length() == 2 *max) {
//                System.out.println(cur.toString());
//                ans.add(cur.toString());
//                return;
//            }
//
//            if (open < max) {
//                cur.append('(');
//                backtrack(ans, cur, open+1, close, max);
////                cur.deleteCharAt(cur.length() - 1);
//            }
//            if (close < open) {
//                cur.append(')');
//                backtrack(ans, cur, open, close+1, max);
////                cur.deleteCharAt(cur.length() - 1);
//            }
//        }



    public static void main(String[] args){
        generateParenthesis(3);
    }
}
