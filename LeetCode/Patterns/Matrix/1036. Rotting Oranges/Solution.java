class Solution 
{

    public int orangesRotting(int[][] grid) 
    {
      int R = grid.length;
      int C = grid[0].length;
      int fans=0;
      int fresh=0;

      int[][] vst = new int[R][C];
      Queue<int[]> q = new ArrayDeque<>();

      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
          if(grid[i][j]==2)
          {
            vst[i][j]=1;
            q.offer(new int[]{i,j});
          }
          else if(grid[i][j]==1)
          {
            fresh++;
          }
        }
      }

      if(fresh==0) return 0;

        while(!q.isEmpty() && fresh>0)
        {
          int n=q.size();

          for(int i=0;i<n;i++)
          {
            int[] temp_node = q.poll();
            int pr = temp_node[0];
            int pc = temp_node[1];
            

            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};

            for(int mv=0;mv<4;mv++)
            {
              int nr=pr+dr[mv];
              int nc=pc+dc[mv];

              if(nr>=0 && nr<R && nc>=0 && nc<C && grid[nr][nc]==1 && vst[nr][nc]!=1)
              {
                vst[nr][nc]=1;
                fresh--;
                q.offer(new int[]{nr,nc});
              }
            }
          }
          fans++;
        }

        return fresh == 0 ? fans : -1;
      

       
    }
}