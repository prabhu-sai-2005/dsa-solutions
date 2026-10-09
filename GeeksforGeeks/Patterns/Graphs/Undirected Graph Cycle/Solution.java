class Solution 
{
    public boolean func_dfs(ArrayList<ArrayList<Integer>> adj,int[] vst,int present_node ,int parent_node)
    {
      vst[present_node] = 1;

      for(int it : adj.get(present_node))
      {
        if(vst[it]!=1)
        {
          if(func_dfs(adj,vst,it,present_node)==true) return true;
        }
        else if(vst[it]==1 && it!=parent_node)
        {
          return true;
        }
      }

      return false;
    }
    public boolean isCycle(int V, int[][] edges) 
    {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
          adj.add(new ArrayList<>());
        }

        int E = edges.length;
        for(int i=0;i<E;i++)
        {
          int u=edges[i][0];
          int v=edges[i][1];

          adj.get(u).add(v);
          adj.get(v).add(u);
        }

        int[] vst = new int[V];

        for(int i=0;i<V;i++)
        {
          if(vst[i]!=1)
          {
            if(func_dfs(adj,vst,i,-1)==true) return true;
          }
        }

        return false;





    }
}