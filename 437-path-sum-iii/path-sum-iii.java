/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.HashMap;

class Solution {
    private int DFS(TreeNode node, long currSum, int target, HashMap<Long, Integer> prefixSumCount){
        if(node == null) return 0;
        currSum+=node.val;

        // Get the number of possible paths ending at the current node.
        int ctr = prefixSumCount.getOrDefault(currSum-target, 0);

        // Put the currSum into prefix for child nodes to find possible paths. 
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0)+1);

        // Traverse the left and right subtree of the current node.
        ctr += DFS(node.left, currSum, target, prefixSumCount);
        ctr += DFS(node.right, currSum, target, prefixSumCount);

        // Remove the currSum to prevent false paths. 
        prefixSumCount.put(currSum, prefixSumCount.get(currSum)-1);

        return ctr;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return DFS(root, 0L, targetSum, prefixSumCount);
    }
}