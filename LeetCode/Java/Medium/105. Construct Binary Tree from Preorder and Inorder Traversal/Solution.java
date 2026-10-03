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
    public TreeNode func(int[] preorder, int[] inorder,int ps,int pe,int is,int ie,Map<Integer,Integer> mpp)
    {
      if(ps>pe || is>ie) return null;


      TreeNode new_node = new TreeNode(preorder[ps]);

      int index = mpp.get(preorder[ps]);
      int no_of_elements = index-is;
      new_node.left = func(preorder,inorder,ps+1,ps+no_of_elements,is,index-1,mpp);
      new_node.right = func(preorder,inorder,ps+no_of_elements+1,pe,index+1,ie,mpp);

      return new_node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
      Map<Integer,Integer> mpp = new HashMap<>();
      for(int i=0;i<inorder.length;i++)
      {
        mpp.put(inorder[i],i);
      }

      return func(preorder,inorder,0,preorder.length-1 , 0,inorder.length-1,mpp);
    }
}