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
class pair {
    TreeNode node;
    int x;
    int y;

    pair(TreeNode node, int x, int y) 
    {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution 
{
    public void func(TreeNode root , Map<Integer, List<Integer>> mpp)
    {
      if(root==null) return;

      Queue<pair> q = new ArrayDeque<>();
      q.offer(new pair(root, 0, 0));

      while(!q.isEmpty())
      {
        pair temp_node = q.peek();
        q.poll();
        TreeNode present_node = temp_node.node;
        int r=temp_node.x;
        int c=temp_node.y;

        mpp.computeIfAbsent(c, k -> new ArrayList<>()).add(present_node.val);

        if(present_node.left!=null) q.offer(new pair(present_node.left , r+1 , c-1));
        if(present_node.right!=null) q.offer(new pair(present_node.right , r+1 , c+1));
  
      }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
      List<List<Integer>> fans = new ArrayList<>();
      Map<Integer, List<Integer>> mpp = new TreeMap<>();

      func(root,mpp);

      for(Map.Entry<Integer, List<Integer>> it : mpp.entrySet())
      {
        Collections.sort(it.getValue());
        fans.add(it.getValue());
      }

      return fans;
        
    }
}