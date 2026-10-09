class Solution 
{
    public void func(ArrayList<ArrayList<Integer>> adj , int[] vst , ArrayList<Integer> fans,int present_node)
    {
      fans.add(present_node);
      vst[present_node]=1;

      for(int it : adj.get(present_node))
      {
        if(vst[it]!=1)
        {
          func(adj,vst,fans,it);
        }
      }

      return;
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
      int V = adj.size();
      int[] vst = new int[V];
      ArrayList<Integer> fans = new ArrayList<>();

      func(adj,vst,fans,0);
      return fans;
    }
}