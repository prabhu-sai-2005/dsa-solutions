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
    class node
    {
      TreeNode n;
      int idx;

      node(TreeNode n,int idx)
      {
        this.n=n;
        this.idx=idx;
      }
    }
    public int func(TreeNode root)
    {
      Queue<node> q = new ArrayDeque<>();
      q.offer(new node(root,0));
      int fans = Integer.MIN_VALUE;

      while(!q.isEmpty())
      {
        int n=q.size();
        int min_idx=Integer.MAX_VALUE;
        int max_idx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
          node temp_node = q.peek();
          q.poll();

          TreeNode present_node=temp_node.n;
          int present_index = temp_node.idx;

          min_idx = Math.min(min_idx,present_index);
          max_idx = Math.max(max_idx,present_index);
          present_index = present_index - min_idx;

          if(present_node.left!=null) q.offer(new node(present_node.left,(present_index*2 +1)));
          if(present_node.right!=null) q.offer(new node(present_node.right,(present_index*2 +2)));
        }
        fans =  Math.max(fans,(max_idx-min_idx+1));
      }

      return fans;
    }
    public int widthOfBinaryTree(TreeNode root) 
    {
      return func(root);
    }
}