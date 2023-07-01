package algorithm.GRAPH.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_게임맵최단거리 {
    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};
    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll(); // x,y
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];
                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[nx].length && !visited[nx][ny] && maps[nx][ny] != 0) {
                    maps[nx][ny] = maps[curr[0]][curr[1]] + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            return answer;
        } else {
            return maps[maps.length - 1][maps[0].length - 1];
        }
    }

    public static void main(String[] args) {
        Programmers_게임맵최단거리 sol = new Programmers_게임맵최단거리();
        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(sol.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
