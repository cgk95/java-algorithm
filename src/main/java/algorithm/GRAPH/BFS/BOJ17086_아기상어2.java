package algorithm.GRAPH.BFS;

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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0) {
                    continue;
                }
                answer = Math.max(answer, searchClosestShark(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int searchClosestShark(int startX, int startY) {
        int[][] copyGraph = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyGraph[i] = Arrays.copyOf(graph[i], M);
        }

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    if (copyGraph[nx][ny] == 1) {
                        return curr.dist + 1;
                    }
                    q.offer(new Node(nx, ny, curr.dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return 0; // 상어를 찾지 못한 경우
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
