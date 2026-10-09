class Solution 
{
    public void func_dfs(char[][] grid,int[][] vst,int pr,int pc,int R,int C)
    {
      vst[pr][pc]=1;

      int[] dr = {-1,0,1,0};
      int[] dc = {0,1,0,-1};

      for(int mv=0;mv<4;mv++)
      {
        int nr = pr+dr[mv];
        int nc = pc+dc[mv];

        if(nr>=0 && nr<R && nc>=0 && nc<C && vst[nr][nc]!=1 && grid[nr][nc]=='1')
        {
            func_dfs(grid,vst,nr,nc,R,C);
        }
      }

      return;

      
    }
    public int numIslands(char[][] grid) 
    {
        int R = grid.length;
        int C = grid[0].length;
        int fans=0;

        int[][] vst = new int[R][C];

        for(int i=0;i<R;i++)
        {
          for(int j=0;j<C;j++)
          {
            if(vst[i][j]!=1 && grid[i][j]=='1')
            {
              fans++;
              func_dfs(grid,vst,i,j,R,C);
            }
          }
        }

        return fans;


    }
}