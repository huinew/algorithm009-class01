package com.example.leetcode;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }
}
