package algorithm.GREEDY;

public class Programmers_섬연결하기 {
    public int solution(int n, int[][] costs) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 99999;
                }
            }
        }
        for (int[] arr : costs) {
            int start = arr[0], end = arr[1], cost = arr[2];
            graph[start][end] = graph[end][start] = cost;
        }
        int weight = 0; // 가중치
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && graph[i][j] > graph[i][k] + graph[k][j]) { // 바로 연결이 안되어 있어서 다른 노드를 들렀다 간 경우
                        weight += graph[i][k]; // 나중에 빼줄 비용 업데이트
                    }
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int answer = 0;
        for (int j = 0; j < graph[0].length - 1; j++) {
            answer += graph[0][j];
        }
        return answer - weight;
    }
}
