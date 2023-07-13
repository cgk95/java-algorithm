package algorithm.GRAPH.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404_플로이드 {
    static int N, M;
    static int[][] graph;

    public static void main(String[] args) {
        try {
            getInitialInput();
            myFloyd();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 출력하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] < 100_001 * N) {
                        System.out.printf("%d ", graph[i][j]);
                        continue;
                    }
                    System.out.print("0 ");
                }
                System.out.println();
            }
        }
    }

    private static void myFloyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }
    }


    public static void getInitialInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], 100_001 * N);
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }
    }
}
