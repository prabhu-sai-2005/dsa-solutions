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
    public int left_most_height(TreeNode root)
    {
      int ht=0;

      while(root!=null)
      {
        ht++;
        root=root.left;
      }

      return ht;

    }
    public int right_most_height(TreeNode root)
    {
      int ht=0;

      while(root!=null)
      {
        ht++;
        root=root.right;
      }

      return ht;

    }
    public int func(TreeNode root)
    {
      if(root==null)
      {
        return 0;
      }

      int lt = left_most_height(root);
      int rt = right_most_height(root);

      if(lt==rt)
      {
        return ((int)Math.pow(2,lt)-1);
      }
      else
      {
        return 1+(func(root.left))+(func(root.right));
      }

    }
    public int countNodes(TreeNode root) 
    {
      return func(root);
        
    }
}