package dp;

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
//            System.out.println(findLcs(str1, str1.length(), str2, str2.length()));
            System.out.println(findLcs2(str1,str2));
        }
    }

    //算法实现(迭代)
    public static int findLcs(String A, int n, String B, int m){
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

    //算法实现(递归)
    public static int findLcs2(String A,String B){
        if (A.length() == 0 || B.length() == 0){
            return 0;
        }
        if (A.charAt(0) == B.charAt(0)){
            return 1+findLcs2(A.substring(1),B.substring(1));
        }else{
            return Math.max(findLcs2(A,B.substring(1)),findLcs2(A.substring(1),B));
        }
    }
}
