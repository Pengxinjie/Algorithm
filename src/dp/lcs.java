package dp;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Pengxinjie
 * @DATE 2021/5/9 - 13:04
 */
public class lcs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine().toLowerCase();
            String str2 = scanner.nextLine().toLowerCase();
            System.out.println(findLCS(str1, str1.length(), str2, str2.length()));
        }
    }

    //算法实现
    public static int findLCS(String A,int n,String B,int m){
        //构建表
        int[][] dp = new int[n+1][m+1];
        //初始化表
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = 0;
            }
        }

        //根据递推式写代码
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
