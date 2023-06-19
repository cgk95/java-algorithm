package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];
            int[][] dp = new int[2][N];
            for (int i = 0; i < 2; i++) {
                sticker[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if (N == 1) {
                System.out.println(Math.max(dp[0][0], dp[1][0]));
                continue;
            }
            dp[0][1] = sticker[0][1] + dp[1][0];
            dp[1][1] = sticker[1][1] + dp[0][0];
            if (N == 2) {
                System.out.println(Math.max(dp[0][1], dp[1][1]));
                continue;
            }
            // 연산
            for (int i = 2; i < N; i++) {
                // 0
                dp[0][i] = dp[1][i - 1] > dp[1][i - 2] ? sticker[0][i] + dp[1][i - 1] : sticker[0][i] + dp[1][i - 2];
                // 1
                dp[1][i] = dp[0][i - 1] > dp[0][i - 2] ? sticker[1][i] + dp[0][i - 1] : sticker[1][i] + dp[0][i - 2];
            }
            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
