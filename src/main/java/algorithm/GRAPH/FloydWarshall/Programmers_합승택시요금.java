package algorithm.GRAPH.FloydWarshall;

import java.util.Arrays;

public class Programmers_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        final int INF = 100_000 * (n - 1) * n / 2 + 1;
        for (int[] arr : graph) {
            Arrays.fill(arr, INF);
        }

        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int answer = graph[s][a] + graph[s][b];
        for (int i = 1; i < n + 1; i++) {
            if (i == a) {
                answer = Math.min(answer, graph[i][s] + graph[i][b]);
            } else if (i == b) {
                answer = Math.min(answer, graph[i][s] + graph[i][a]);
            } else {
                answer = Math.min(answer, graph[i][s] + graph[i][a] + graph[i][b]);
            }
        }
        return answer;
    }
}
