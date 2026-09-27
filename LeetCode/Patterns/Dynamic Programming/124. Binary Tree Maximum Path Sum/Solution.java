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
class Solution
{
    int maxi = Integer.MIN_VALUE;

    public int func(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int lt = Math.max(0,func(root.left));
        int rt = Math.max(0,func(root.right));

        maxi = Math.max(maxi,(root.val+lt+rt));
        return root.val+(Math.max(lt,rt));
    }
    public int maxPathSum(TreeNode root) 
    {
        func(root);
        return maxi;
    }
}