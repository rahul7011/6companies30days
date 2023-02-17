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
class Solution {
    private static int[] solve(TreeNode root){
        if(root==null)
        {
            return new int[]{0,0,0};
        }
        int[] left=solve(root.left);
        int[] right=solve(root.right);
        int sum=left[0]+right[0]+root.val;
        int count=left[2]+right[2];
        if(sum/(left[1]+right[1]+1)==root.val)
        {
            count++;
        }
        
        return new int[]{sum,left[1]+right[1]+1,count};
    }
    public int averageOfSubtree(TreeNode root) {
        return solve(root)[2];
    }
}