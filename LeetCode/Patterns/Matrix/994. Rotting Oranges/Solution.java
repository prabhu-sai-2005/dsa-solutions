class Solution 
{
    public int func_dfs(int[][] grid,int[][] vst,int sr,int sc,int R,int C,int fans)
    {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr,sc});
        //vst[sr][sc]=1;

        while(!q.isEmpty())
        {
          int n=q.size();

          for(int i=0;i<n;i++)
          {
            int[] temp_node = q.poll();
            int pr = temp_node[0];
            int pc = temp_node[1];
            vst[pr][pc]=1;

            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};

            for(int mv=0;mv<4;mv++)
            {
              int nr=pr+dr[mv];
              int nc=pc+dc[mv];

              if(nr>=0 && nr<R && nc>=0 && nc<C && grid[nr][nc]==1 && vst[nr][nc]!=1)
              {
                q.offer(new int[]{nr,nc});
              }
            }
          }
          fans++;
        }

        return fans-1;

    }
    public int orangesRotting(int[][] grid) 
    {
      int R = grid.length;
      int C = grid[0].length;

      int[][] vst = new int[R][C];

      int fans=0;
      int sr=-1;
      int sc=-1;
      
      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
          if(grid[i][j]==2)
          {
            sr=i;
            sc=j;
          }
        }
      }
      if(sr==-1 && sc==-1) return -1;

      int rans = func_dfs(grid,vst,sr,sc,R,C,fans);

      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
          if(vst[i][j]!=1 && grid[i][j]==1)
          {
            return -1;
          }
        }
      }

      return rans;  
    }
}