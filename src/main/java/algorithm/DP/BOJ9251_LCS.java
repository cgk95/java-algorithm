package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        br.close();
        char[] A = new char[first.length() + 1];
        char[] B = new char[second.length() + 1];
        setUpArrays(A, first);
        setUpArrays(B, second);
        int[][] dp = new int[A.length][B.length];
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] != B[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        System.out.println(dp[A.length - 1][B.length - 1]);
    }

    private static void setUpArrays(char[] arr, String target) {
        for (int i = 1; i <= target.length(); i++) {
            arr[i] = target.charAt(i - 1);
        }
    }
}
