package algorithm.DP;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1890_점프 {
    static int[][] board;
    static int[][] dp;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        board = new int[N][];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        if (board[0][0] == 0) { // 가장 왼쪽 위 지점이 움직일 수 없는 점이라면
            System.out.println(0);
            return;
        }
        dp = new int[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) { // 갈 필요 없는 곳은 중단해서 계산량 줄이기
                    continue;
                }
                int nextStepSize = board[i][j];
                if (nextStepSize == 0) {
                    continue;
                }
                if (i + nextStepSize < N) {
                    dp[i + nextStepSize][j] += dp[i][j];
                }
                if (j + nextStepSize < N) {
                    dp[i][j + nextStepSize] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);

    }


}


