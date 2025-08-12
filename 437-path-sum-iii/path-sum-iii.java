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
    private int DFS(TreeNode node, long currSum, int target, HashMap<Long, Long> prefixSumCount){
        if(node == null) return 0;
        currSum+=node.val;

        // Get the number of possible paths
        long ctr = prefixSumCount.getOrDefault(currSum-target, 0L);

        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0L)+1L);

        ctr += DFS(node.left, currSum, target, prefixSumCount);
        ctr += DFS(node.right, currSum, target, prefixSumCount);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum)-1L);
        if (prefixSumCount.get(currSum) == 0) {
            prefixSumCount.remove(currSum);
        }

        return (int)ctr;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1L);
        return DFS(root, 0L, targetSum, prefixSumCount);
    }
}