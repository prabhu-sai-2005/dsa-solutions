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
    class node
    {
      TreeNode present_node;
      TreeNode parent_node;

      node(TreeNode present_node,TreeNode parent_node)
      {
        this.present_node=present_node;
        this.parent_node=parent_node;
      }
    }
    public void func1(TreeNode root,Map<TreeNode,TreeNode> mpp)
    {
      Queue<node> q = new ArrayDeque<>();
      q.offer(new node(root,null));

      //mpp.put(root,null);

      while(!q.isEmpty())
      {
        node temp_node = q.peek();
        q.poll();

        TreeNode present_child_node=temp_node.present_node;
        TreeNode present_parent_node=temp_node.parent_node;

        mpp.put(present_child_node,present_parent_node);

        if(present_child_node.left!=null) q.offer(new node(present_child_node.left,present_child_node));
        if(present_child_node.right!=null) q.offer(new node(present_child_node.right,present_child_node));
      }

    }
    public void func2(TreeNode target, int k,Map<TreeNode,TreeNode> mpp,Set<TreeNode> st,List<Integer> fans)
    {
      Queue<TreeNode> q = new ArrayDeque<>();
      q.offer(target);
      st.add(target);

      while(k>0)
      {
        int n=q.size();
        for(int i=0;i<n;i++)
        {
          TreeNode node = q.peek();
          q.poll();

          TreeNode parent_node = mpp.get(node);
          if(parent_node != null && st.contains(parent_node)==false) q.offer(parent_node);
          if(node.left!=null && (st.contains(node.left)==false)) q.offer(node.left);
          if(node.right!=null && (st.contains(node.right)==false)) q.offer(node.right);
        }
        k--;
      }

      while(!q.isEmpty())
      {
        TreeNode temp_node = q.peek();
        q.poll();

        fans.add(temp_node.val);
      }


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        Map<TreeNode,TreeNode> mpp =  new HashMap<>();
        func1(root,mpp);
        Set<TreeNode> st=new HashSet<>();
        List<Integer> fans = new ArrayList<>();
        func2(target,k,mpp,st,fans);

        return fans;
    }
}