package paixu;
/*动态规划，01背包问题*/
public class BeiBaoWenTi {
    public static void main(String[] args) {
        int[] wight = {1,3,4,5};
        int[] value = {1,4,5,7};
        int totalWight = 7;
        int[][] dp = new int[wight.length][totalWight+1];
        for (int i=0;i<wight.length;i++){
            dp[i][0]=0;
        }
        for (int i=1;i< totalWight+1;i++){
            if (wight[0]<=i){
                dp[0][i] = value[0];
            }
            else {
                dp[0][i] = 0;
            }
        }
        for (int i=1;i< value.length;i++){
            for (int j=1;j< totalWight+1;j++){
                if (wight[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[wight.length-1][totalWight]);
    }
}
