package algorithm.DP;

import java.util.Arrays;

public class Programmers_땅따먹기 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        System.arraycopy(land[0], 0, dp[0], 0, dp[0].length);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // 자기 열을 제외한 dp의 최댓값
                dp[i][j] = maxDP(dp, i, j) + land[i][j];
            }
        }

        return Arrays.stream(dp[land.length - 1])
                .max()
                .orElseThrow()
                ;
    }

    public int maxDP(int[][] dp, int currRow, int currCol) {
        int result = 0;
        for (int j = 0; j < dp[currRow].length; j++) {
            if (j == currCol) continue;
            result = Math.max(dp[currRow - 1][j], result);
        }
        return result;
    }

    public static void main(String[] args) {
        Programmers_땅따먹기 sol = new Programmers_땅따먹기();
        System.out.println(sol.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }
}
