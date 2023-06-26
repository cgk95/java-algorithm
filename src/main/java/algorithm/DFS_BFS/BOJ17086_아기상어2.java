package algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086_아기상어2 {
    static int N;
    static int M;
    static int[][] graph;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();
        int answer = Integer.MIN_VALUE;
        // 각 아기상어들의 안전 거리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 1) { // 상어가 아니면
                    continue;
                }
                // 상어를 발견하면
                answer = Math.max(answer, searchClosestShark(new Node(i, j, 0)));
            }
        }
        System.out.println(answer);

    }

    private static int searchClosestShark(Node node) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(node);
        visited[node.x][node.y] = true;
        graph[node.x][node.y] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (graph[curr.x][curr.y] == 1) {
                return curr.dist;
            }
            for (int k = 0; k < 8; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (0 <= nx && 0 <= ny && nx < N && ny < M && !visited[nx][ny]) {
                    q.offer(new Node(nx, ny, curr.dist + 1));
                    visited[nx][ny] = true;
                }
            }

        }
        graph[node.x][node.y] = 1;
        return Integer.MIN_VALUE;
    }

    static class Node {
        int x;
        int y;

        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
