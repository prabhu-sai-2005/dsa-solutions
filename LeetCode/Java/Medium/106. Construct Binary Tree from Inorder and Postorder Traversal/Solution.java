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
    public TreeNode func(int[] postorder, int[] inorder,int ps,int pe,int is,int ie,Map<Integer,Integer> mpp)
    {
      if(ps>pe || is>ie) return null;


      TreeNode new_node = new TreeNode(postorder[pe]);

      int index = mpp.get(postorder[pe]);
      int no_of_elements = index-is;
      new_node.left = func(postorder,inorder,ps,ps+no_of_elements-1,is,index-1,mpp);
      new_node.right = func(postorder,inorder,ps+no_of_elements,pe-1,index+1,ie,mpp);

      return new_node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
      Map<Integer,Integer> mpp = new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
        mpp.put(inorder[i],i);
      }

      return func(postorder,inorder,0,postorder.length-1 , 0,inorder.length-1,mpp);
        
    }
}