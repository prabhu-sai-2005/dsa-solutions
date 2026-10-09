class Solution 
{
    public void func_dfs(ArrayList<ArrayList<Integer>> adj , int[] vst,int present_node)
    {
      vst[present_node]=1;

      for(int it : adj.get(present_node))
      { 
        if(vst[it]!=1)
        {
          func_dfs(adj,vst,it);
        }
      }

      return;

    }
    public int findCircleNum(int[][] isConnected) 
    {
        int fans=0;
        int n = isConnected.length ;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
          adj.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++)
        {
          for(int j=0;j<isConnected[i].length;j++)
          {
            if(isConnected[i][j]==1 && i!=j)
            {
              adj.get(i+1).add(j+1);
            }
          }
        }

        int[] vst = new int[n+1];

        for(int i=1;i<=n;i++)
        {
          if(vst[i]!=1) //unvisted
          {
            fans++;
            func_dfs(adj,vst,i);
          }
        }

        return fans;
    }
}