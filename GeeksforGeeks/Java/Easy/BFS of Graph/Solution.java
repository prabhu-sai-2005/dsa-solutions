class Solution 
{
    public ArrayList<Integer> func(ArrayList<ArrayList<Integer>> adj , int[] vst , ArrayList<Integer> fans)
    {
      Queue<Integer> q = new ArrayDeque<>();
      q.offer(0);
      vst[0] = 1;

      while(!q.isEmpty())
      {
        int node = q.peek();
        q.poll();
        fans.add(node);

        for(int it : adj.get(node))
        {
          if(vst[it]!=1)
          {
            q.offer(it);
            vst[it]=1;
          }
        }
      }

      return fans;


    }
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        int n=adj.size();
        int[] vst = new int[n];
        ArrayList<Integer> fans = new ArrayList<>();

        return func(adj,vst,fans);


    }
}