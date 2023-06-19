package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        int[][] graph = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        // 그래프 입력
        getGraph(br, N, graph);
        // 누적합을 저장하는 dp 테이블 초기화
        setDP(N, graph, dp);
        // 출력 :: 누적합에서 포함되지 않는 부분 빼주고 겹치는 부분을 다시 더해서 보정해주기
        printTestCase(br, M, dp);
    }

    private static void getGraph(BufferedReader br, int N, int[][] graph) throws IOException {
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void printTestCase(BufferedReader br, int M, int[][] dp) throws IOException {
        for (int tc = 0; tc < M; tc++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st2.nextToken());
            int y1 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());
            System.out.println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]);
        }
    }

    private static void setDP(int N, int[][] graph, int[][] dp) {
        dp[1][1] = graph[1][1];
        for (int i = 2; i < N + 1; i++) {
            dp[1][i] = dp[1][i - 1] + graph[1][i];
            dp[i][1] = dp[i - 1][1] + graph[i][1];
        }
        // dp 테이블 채우기
        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < N + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + graph[i][j] - dp[i - 1][j - 1];
            }
        }
    }
}
