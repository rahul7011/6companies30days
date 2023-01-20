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
    private static int solve(TreeNode root,int toggle,HashMap<String,Integer>hm)
    {
        if(root==null)
        {
            return 0;
        }
        int check1=0,check2=0;
        String key=root+"<@>"+toggle;
        if(hm.containsKey(key)==true)
        {
            return hm.get(key);
        }
        if(toggle==0)
        {
            check1=solve(root.left,1,hm)+solve(root.right,1,hm)+root.val;
        }
        check2=solve(root.left,0,hm)+solve(root.right,0,hm);
        hm.put(key,Math.max(check1,check2));
        return Math.max(check1,check2);
    }
    public int rob(TreeNode root) {
        HashMap<String,Integer>hm=new HashMap<>();
        return solve(root,0,hm);
    }
}