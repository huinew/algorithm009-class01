package com.example.leetcode;

public class MinPath {
    public static int minPathSum(int[][] grid) {

        int i = grid.length;
        int j = grid[0].length;

        int[][] path = new int[i--][j--];
        path[i][j] = grid[i][j];

        for (; j >0; j--){
            for (i = grid[0].length - 1; i > 0; i--){

                    path[i - 1][j] = grid[i - 1][j] + path[i][j];
                    path[i][j - 1] = grid[i][j - 1] + path[i][j];
            }
        }

        // if (i == 0 && j==0){
        return path[1][0] > path[0][1]?path[1][0]  + grid[0][0]: path[0][1] + grid[0][0];
        // }

    }
    public static void main(String[] args) {
        int[][] test = {{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(test);
    }
}
