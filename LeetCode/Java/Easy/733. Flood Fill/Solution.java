class Solution 
{
    public void func_dfs(int[][] image, int pr, int pc, int target_color,int intial_color,int[][] fans,int[][] vst,int R ,int C)
    {
      vst[pr][pc]=1;
      fans[pr][pc]=target_color;

      int[] dr = {-1,0,1,0};
      int[] dc = {0,1,0,-1};

      for(int mv=0;mv<4;mv++)
      {
        int nr = pr+ dr[mv];
        int nc = pc + dc[mv];

        if(nr>=0 && nr<R && nc>=0 && nc<C && image[nr][nc]==intial_color && vst[nr][nc]!=1)
        {
          func_dfs(image,nr,nc,target_color,intial_color,fans,vst,R,C); 
        }
      }

      return;

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
      int R = image.length;
      int C = image[0].length;

      int[][] fans = new int[R][C];
      for(int i=0;i<R;i++)
      {
        for(int j=0;j<C;j++)
        {
           fans[i][j]=image[i][j];
        }
      }
      int[][] vst = new int[R][C];
      int intial_color = image[sr][sc];

      func_dfs(image,sr,sc,color,intial_color,fans,vst,R,C); 
      return fans;

        
    }
}