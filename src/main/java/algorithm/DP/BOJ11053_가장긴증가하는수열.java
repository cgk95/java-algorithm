package algorithm.DP;

import java.util.Scanner;

// TODO :: dp,이진탐색 방법으로 각각 다시 풀어보기
public class BOJ11053_가장긴증가하는수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        int N = sc.nextInt();
        int[] input = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
            dp[i] = 1;
        }

        sc.close();
        // 연산
        int max = 1;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
