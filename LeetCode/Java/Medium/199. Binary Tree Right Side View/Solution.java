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
      int r;

      node(TreeNode n,int r)
      {
        this.n=n;
        this.r=r;
      }

    }
    public void func(TreeNode root,Map<Integer,Integer>  mpp)
    {
      if(root==null) return;

      Queue<node> q=new ArrayDeque<>();
      q.offer(new node(root,0));

      while(!q.isEmpty())
      {
          node temp_node = q.peek();
          q.poll();

          TreeNode present_node = temp_node.n;
          int present_node_val = present_node.val;
          int r = temp_node.r;

          mpp.put(r,present_node_val);

          if(present_node.left!=null) q.offer(new node(present_node.left,r+1));
          if(present_node.right!=null) q.offer(new node(present_node.right,r+1));

      }
    }
    public List<Integer> rightSideView(TreeNode root) 
    {
        Map<Integer,Integer>  mpp = new TreeMap<>();
        func(root,mpp);

        List<Integer> fans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> it : mpp.entrySet())
        {
          fans.add(it.getValue());
        }

        return fans;


    }
}