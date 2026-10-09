class Solution 
{
    public void func(int[][] mat,int[][] fans,int[][] vst,int R,int C)
    {
       Queue<int[]> q = new ArrayDeque<>();
       
       for(int i=0;i<R;i++)
       {
        for(int j=0;j<C;j++)
        {
          if(mat[i][j]==0)
          {
            vst[i][j]=1;
            q.offer(new int[]{i,j,0});
          }
        }
       }

       while(!q.isEmpty())
       {
         int[] temp_node = q.poll();

         int pr=temp_node[0];
         int pc=temp_node[1];
         int pd=temp_node[2];
         fans[pr][pc]=pd;

         int[] dr={-1,0,1,0};
         int[] dc={0,1,0,-1};

         for(int mv=0;mv<4;mv++)
         {
          int nr=pr+dr[mv];
          int nc=pc+dc[mv];

          if(nr>=0 && nr<R && nc>=0 && nc<C && vst[nr][nc]!=1 && mat[nr][nc]==1)
          {
            vst[nr][nc]=1;
            q.offer(new int[]{nr,nc,pd+1});
          }
         }
       }

       return ;



    }
    public int[][] updateMatrix(int[][] mat) 
    {
        int R = mat.length;
        int C=mat[0].length;
        
        int[][] vst = new int[R][C];
        int[][] fans = new int[R][C];

        func(mat,fans,vst,R,C);

        return fans;


        


        
    }
}