
/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution 
{
    public boolean isLeaf(Node mvr)
    {
        if(mvr.left == null && mvr.right == null) return true;

        return false;
    }

    public void add_left_bound(Node root, ArrayList<Integer> fans)
    {
        if(root==null) return;

        Node mvr = root;

        while(mvr != null && isLeaf(mvr) == false)
        {
            fans.add(mvr.data);
            if(mvr.left!=null) mvr = mvr.left;
            else mvr=mvr.right;
        }
    }

    public void add_leaf_nodes(Node mvr, ArrayList<Integer> fans)
    {
        if(isLeaf(mvr) == true)
        {
            fans.add(mvr.data);
            return;
        }

        if(mvr.left != null)
        {
            add_leaf_nodes(mvr.left, fans);
        }

        if(mvr.right != null)
        {
            add_leaf_nodes(mvr.right, fans);
        }

        return;
    }

    public void add_right_bound(Node root, ArrayList<Integer> fans)
    {
      if(root==null) return;
        List<Integer> temp = new ArrayList<>();
        Node mvr = root;

        while(mvr != null && isLeaf(mvr) == false)
        {
            temp.add(mvr.data);
            if(mvr.right!=null) mvr = mvr.right;
            else mvr=mvr.left;
        }

        Collections.reverse(temp);

        for(int it : temp)
        {
            fans.add(it);
        }
    }

    public void func(Node root, ArrayList<Integer> fans)
    {
        fans.add(root.data);
        
        if(isLeaf(root))
               return;
               
               
        add_left_bound(root.left, fans);
        add_leaf_nodes(root, fans);
        add_right_bound(root.right, fans);

        return;
    }

    public ArrayList<Integer> boundaryTraversal(Node root) 
    {
        ArrayList<Integer> fans = new ArrayList<>();

        if(root == null) return fans;

        func(root, fans);

        return fans;
    }
}

