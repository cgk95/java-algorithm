package algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14940_쉬운최단거리 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] board = new int[N][M];
        int[][] answer = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Node start = new Node(-1, -1);

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(row[j]);
                if (board[i][j] == 2) {
                    start = new Node(i, j);
                }
            }
        }
        // 탐색
        Queue<Node> q = new LinkedList<>();
        if (start.equals(new Node(-1, -1))) {
            System.out.println("[EROOR] 출발지점이 주어지지 않음");
            return;
        }

        q.offer(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (0 <= nx && 0 <= ny && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == 1) {
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    answer[nx][ny] = answer[curr.x][curr.y] + 1;
                }
            }
        }
        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (answer[i][j] != 0) {
                    continue;
                }
                if (answer[i][j] == 0 && board[i][j] == 1) {// 원래 갈수 잇는 지역인데 도달하지 못했다면
                    answer[i][j] = -1;
                }

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//15 15
//        2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
//        1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
//        1 1 1 1 1 1 1 1 1 1 0 1 1 1 1