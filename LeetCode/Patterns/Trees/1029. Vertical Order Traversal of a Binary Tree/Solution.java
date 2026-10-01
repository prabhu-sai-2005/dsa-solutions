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
class Solution {
    class node {

        TreeNode n;
        int r;
        int c;

        node(TreeNode n, int r, int c) {
            this.n = n;
            this.r = r;
            this.c = c;
        }

    }

    public void func(TreeNode root, int r, int c, Map<Integer, Map<Integer, List<Integer>>> mpp) {
        if (root == null) {
            return;
        }
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(root, r, c));

        while (!q.isEmpty()) {
            node temp_node = q.peek();
            q.poll();

            TreeNode present_node = temp_node.n;
            int node_val = present_node.val;
            int node_r = temp_node.r;
            int node_c = temp_node.c;

            mpp.computeIfAbsent(node_c, lpc -> new TreeMap<>())
   .computeIfAbsent(node_r, lpr -> new ArrayList<>())
   .add(node_val);

            if (present_node.left != null)
                q.offer(new node(present_node.left, node_r + 1, node_c - 1));
            if (present_node.right != null)
                q.offer(new node(present_node.right, node_r + 1, node_c + 1));
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> mpp = new TreeMap<>();
        func(root, 0, 0, mpp);
        List<List<Integer>> fans = new ArrayList<>();

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> left1 : mpp.entrySet()) {
            List<Integer> temp = new ArrayList<>();

            for (Map.Entry<Integer, List<Integer>> left2 : left1.getValue().entrySet()) {
                temp.addAll(left2.getValue());
            }

            Collections.sort(temp);

            fans.add(temp);
        }

        return fans;

    }
}