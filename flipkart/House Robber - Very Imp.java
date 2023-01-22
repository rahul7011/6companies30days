/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // private static int solve(TreeNode root, int toggle, HashMap<String, Integer>
    // hm) {
    // if (root == null) {
    // return 0;
    // }
    // int check1 = 0, check2 = 0;
    // String key = root + "<@>" + toggle;
    // if (hm.containsKey(key) == true) {
    // return hm.get(key);
    // }
    // if (toggle == 0) {
    // check1 = solve(root.left, 1, hm) + solve(root.right, 1, hm) + root.val;
    // }
    // check2 = solve(root.left, 0, hm) + solve(root.right, 0, hm);
    // hm.put(key, Math.max(check1, check2));
    // return Math.max(check1, check2);
    // }

    // public int rob(TreeNode root) {
    // HashMap<String, Integer> hm = new HashMap<>();
    // return solve(root, 0, hm);
    // }

    //=============Better=============================
    private static int[] solve(TreeNode root) {
        if (root == null) {
            // [0]: for robbing current position
            // [1]: for not robbing current position
            return new int[2];
        }
        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int[] check = new int[2];
        // with rob
        check[0] = root.val + left[1] + right[1];
        // without rob
        check[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return check;
    }
