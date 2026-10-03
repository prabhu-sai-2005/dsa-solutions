/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public TreeNode func(TreeNode root, TreeNode p, TreeNode q)
    {
      if(root==null)
      {
        return null;
      }

      if(root==p || root==q)
      {
        return root;
      }

      TreeNode lt = func(root.left,p,q);
      TreeNode rt = func(root.right,p,q);

      if(lt!=null && rt!=null)
      {
        return root;
      }
      else if(lt!=null && rt==null)
      {
        return lt;
      }
      else if(lt==null && rt!=null)
      {
        return rt;
      }
      else //if(lt==null && rt==null)
      {
        return null;
      }
      
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
      return func(root,p,q);
        
    }
}