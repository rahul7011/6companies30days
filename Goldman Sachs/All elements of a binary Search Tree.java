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
    private static void updateStack(LinkedList<TreeNode>st)
    {
        if(st.size()==0)
        {
            return;
        }
        TreeNode root=st.removeLast();
        if(root.right!=null)
        {
            TreeNode node=root.right;
            while(node!=null)
            {
                st.addLast(node);
                node=node.left;
            }
        }
    }
    private static List<Integer>solve(LinkedList<TreeNode>st1,LinkedList<TreeNode>st2)
    {
        List<Integer>ans=new ArrayList<>();
        while(st1.size()!=0 && st2.size()!=0)
        {
            TreeNode left=st1.peekLast();
            TreeNode right=st2.peekLast();
            if(left.val<right.val)
            {
                ans.add(left.val);
                updateStack(st1);
            }else
            {
                ans.add(right.val);
                updateStack(st2);
            }
        }
        while(st1.size()!=0)
        {
            TreeNode left=st1.peekLast();
            ans.add(left.val);
            updateStack(st1);
        }
        while(st2.size()!=0)
        {
            TreeNode right=st2.peekLast();
            ans.add(right.val);
            updateStack(st2);
        }
        return ans;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<TreeNode>st1=new LinkedList<>();
        LinkedList<TreeNode>st2=new LinkedList<>();
        while(root1!=null)
        {
            st1.addLast(root1);
            root1=root1.left;
        }
        while(root2!=null)
        {
            st2.addLast(root2);
            root2=root2.left;
        }
        return solve(st1,st2);
    }
}