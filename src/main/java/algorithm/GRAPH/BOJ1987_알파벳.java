package algorithm.GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_알파벳 {
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {1, 0, -1, 0};
    static char[][] graph;
    static boolean[] visited;
    static int answer = 0;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        R = Integer.parseInt(input.nextToken());
        C = Integer.parseInt(input.nextToken());
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        // DFS
        visited = new boolean[26]; // -65
        visited[graph[0][0] - 65] = true;
        myDFS(new Node(0, 0), 1);
        // 출력
        System.out.println(answer);
    }

    private static void myDFS(Node node, int depth) {
        if (depth > answer) {
            answer = depth;
        }

        for (int k = 0; k < 4; k++) {
            int nx = node.x + dx[k];
            int ny = node.y + dy[k];
            if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[graph[nx][ny] - 65]) {
                visited[graph[nx][ny] - 65] = true;
                myDFS(new Node(nx, ny), depth + 1);
                visited[graph[nx][ny] - 65] = false;
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
