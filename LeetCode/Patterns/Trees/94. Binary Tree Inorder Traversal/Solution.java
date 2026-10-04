
import java.util.ArrayList;

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
        func(root.left,fans);
        fans.add(root.val);
        func(root.right,fans);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> fans  = new ArrayList<>();
        func(root,fans);
        return fans;
    }
}