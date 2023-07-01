package algorithm.GRAPH.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ21736_헌내기는친구가필요해 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int M = NM[1];
        String[][] map = new String[N][M];
        int[] doyeon = new int[2];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (map[i][j].equals("I")) {
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }
        // 탐색
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int answer = 0;
        q.offer(doyeon);
        visited[doyeon[0]][doyeon[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                if (0 <= nx && 0 <= ny && nx < N && ny < M && !visited[nx][ny] && !map[nx][ny].equals("X")) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if (map[nx][ny].equals("P")) {
                        answer++;
                    }
                }
            }
        }
        if (answer > 0) {
            System.out.println(answer);
        } else {
            System.out.println("TT");
        }
    }
}
