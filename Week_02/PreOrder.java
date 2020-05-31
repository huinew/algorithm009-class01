package com.example.leetcode;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

        List<Integer> result = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root!=null){
                result.add(root.val);
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
            return result;
        }

}
