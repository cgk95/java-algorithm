package algorithm.GRAPH.FloydWarshall;

public class Programmers_순위 {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] edge : results) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = -1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_순위 sol = new Programmers_순위();
        System.out.println(sol.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
