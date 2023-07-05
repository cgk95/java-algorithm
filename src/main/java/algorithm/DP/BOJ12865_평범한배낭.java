package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nk.nextToken());
        int K = Integer.parseInt(nk.nextToken());
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) { // 각 짐 마다
            StringTokenizer wv = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(wv.nextToken());
            int value = Integer.parseInt(wv.nextToken());
            for (int j = 1; j <= K; j++) { // 배낭에 넣을 수 있는 최대 무게까지 순회하며
                if (weight <= j) { // 짐을 넣을 수 있는 무게이고
                    if (dp[i - 1][j - weight] > 0) { // 더 넣을 수 있다면
                        dp[i][j] = Math.max(dp[i - 1][j - weight] + value, dp[i - 1][j]);
                    } else { // 더 넣을 수 없다면
                        dp[i][j] = Math.max(dp[i - 1][j], value);
                    }
                } else { // 지금 짐을 넣을 수 없다면
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        br.close();
        System.out.println(dp[N][K]);
    }
}
//for (int w = 0; w <= K; w++) {
//        if (w - weight > 0) {
//        dp[i][w] = Math.max(dp[i - 1][w - weight] + value, dp[i][w]);
//        } else {
//        dp[i][w] = dp[i - 1][w];
//        }
//        }

// else {
//         dp[i][W] = dp[i - 1][W];
//         }