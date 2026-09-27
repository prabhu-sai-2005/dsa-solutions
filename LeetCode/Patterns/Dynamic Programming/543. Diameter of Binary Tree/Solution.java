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
    int maxi=Integer.MIN_VALUE;

    public int func(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }

        int lt = func(root.left);
        int rt = func(root.right);

        maxi=Math.max(maxi,(lt+rt));
        return 1+Math.max(lt,rt);
        
    }
    public int diameterOfBinaryTree(TreeNode root) 
    {
        func(root);
        return maxi;
        
        
    }
}