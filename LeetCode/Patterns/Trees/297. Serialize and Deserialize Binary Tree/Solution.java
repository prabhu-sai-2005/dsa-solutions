/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
      StringBuilder data = new StringBuilder();
      if(root==null)
      {
        return data.toString();
      }

      Queue<TreeNode> q = new LinkedList<>();
      q.offer(root);

      while(!q.isEmpty())
      {
        TreeNode temp_node=q.peek();
        q.poll();

        if(temp_node!=null)
        {
          data.append(Integer.toString(temp_node.val) + ',');
          q.offer(temp_node.left);
          q.offer(temp_node.right);
        }
        else if(temp_node==null)
        {
          data.append("#,");
        }
      }

      return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {

      if(data.length()==0) return null;
      String[] parts = data.split(",");
      int i=0;

      TreeNode root_node = new TreeNode(Integer.parseInt(parts[i]));
      i++;
      Queue<TreeNode> q= new ArrayDeque<>();
      q.offer(root_node);

      while(!q.isEmpty())
      {
        TreeNode temp_node = q.poll();

        if(!parts[i].equals("#"))
        {
          temp_node.left = new TreeNode(Integer.parseInt(parts[i]));
          i++;
          q.offer(temp_node.left);
        }
        else
        {
          temp_node.left = null;
          i++;
        }

        if(!parts[i].equals("#"))
        {
          temp_node.right = new TreeNode(Integer.parseInt(parts[i]));
          i++;
          q.offer(temp_node.right);
        }
        else
        {
          temp_node.right = null;
          i++;
        }


      }

      return root_node;



      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));