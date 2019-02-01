package algorithmProblems;

import java.lang.management.ManagementFactory;

public class TSP {
    public TSP(){}

    public int[][] slove(int[][] distance){
        int n = distance.length;
        int m = (int)Math.pow(2,n-1);
        int[][] dp = new int[n][m];

        for (int j=0;j<m;j++)
            for (int i=0;i<n;i++){
                int min = 10000;
                if (j==0)
                    min = distance[i][j];
                boolean flag = true;
                if (i!=0)
                    flag = (j&(1<<(i-1)))==0;

                for (int k=0;k<n-1&&j!=0&&flag;k++){
                    if ( ((j>>k)&1)!=0 ){
                        int tmp = j&(~(1<<k));
                        if (tmp==0)
                            min = Math.min(distance[i][k+1]+distance[k+1][0],min);
                        else
                            min = Math.min(distance[i][k+1]+dp[k+1][tmp],min);
                    }
                }
               dp[i][j] = min;
            }
        return dp;
    }

}
