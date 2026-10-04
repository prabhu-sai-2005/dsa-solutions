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
    public void func(TreeNode root,List<Integer> fans)
    {

      if(root==null) return;

      TreeNode node = root;

      while(node!=null)
      {
        if(node.left==null)
        {
          fans.add(node.val);
          node=node.right;
        }
        else
        {
          TreeNode travel_node = node.left;

          while(travel_node.right!=null && travel_node.right!=node)
          {
            travel_node = travel_node.right;
          }

          if(travel_node.right==null)
          {
            travel_node.right = node;
            node = node.left;
          }
          else if(travel_node.right==node)
          {
            travel_node.right = null;
            fans.add(node.val);
            node=node.right;
          }
        }
      }
    }
    public List<Integer> inorderTraversal(TreeNode root) 
    {
      List<Integer> fans = new ArrayList<>();

      func(root,fans);

      return fans;
        
    }
}