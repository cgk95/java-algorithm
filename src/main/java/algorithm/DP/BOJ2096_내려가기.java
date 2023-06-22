package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ladder = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            ladder[i][0] = Integer.parseInt(row.nextToken());
            ladder[i][1] = Integer.parseInt(row.nextToken());
            ladder[i][2] = Integer.parseInt(row.nextToken());
        }

        dpMax[0][0] = ladder[0][0];
        dpMax[0][1] = ladder[0][1];
        dpMax[0][2] = ladder[0][2];
        dpMin[0][0] = ladder[0][0];
        dpMin[0][1] = ladder[0][1];
        dpMin[0][2] = ladder[0][2];
        for (int i = 1; i < N; i++) {
            dpMax[i][0] = ladder[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMax[i][1] = ladder[i][1] + Math.max(dpMax[i - 1][2], Math.max(dpMax[i - 1][0], dpMax[i - 1][1]));
            dpMax[i][2] = ladder[i][2] + Math.max(dpMax[i - 1][2], dpMax[i - 1][1]);

            dpMin[i][0] = ladder[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
            dpMin[i][1] = ladder[i][1] + Math.min(dpMin[i - 1][2], Math.min(dpMin[i - 1][0], dpMin[i - 1][1]));
            dpMin[i][2] = ladder[i][2] + Math.min(dpMin[i - 1][2], dpMin[i - 1][1]);
        }
        System.out.printf("%d %d", Arrays.stream(dpMax[N - 1]).max().orElseThrow(),
                Arrays.stream(dpMin[N - 1]).min().orElseThrow());
    }

}
