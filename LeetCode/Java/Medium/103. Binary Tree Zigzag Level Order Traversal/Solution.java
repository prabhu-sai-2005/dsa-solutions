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
    public void func(TreeNode root , List<List<Integer>> fans)
    {
       Queue<TreeNode> q = new ArrayDeque<>();
       q.offer(root);
       int flag = 0;

       while(!q.isEmpty())
       {
         int n=q.size();
         List<Integer> temp = new ArrayList<>();

         for(int i=0;i<n;i++)
         {
           TreeNode temp_node = q.peek();
           q.poll();
           temp.add(temp_node.val);

           if(temp_node.left!=null) q.offer(temp_node.left);
           if(temp_node.right!=null) q.offer(temp_node.right);
         }
         if(flag==0)
         {
          fans.add(temp);
          flag=1;
         }
         else if(flag==1)
         {
            Collections.sort(temp,Collections.reverseOrder());
           fans.add(temp);
           flag=0;
         }

       }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> fans = new ArrayList<List<Integer>>();
        if (root == null) return fans;
        func(root,fans);
        return fans;
    }
}