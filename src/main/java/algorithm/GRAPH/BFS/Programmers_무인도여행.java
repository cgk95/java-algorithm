package algorithm.GRAPH.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Programmers_무인도여행 {
    final int[] dx = {0, 0, 1, -1};
    final int[] dy = {1, -1, 0, 0};
    boolean[][] visited;

    public int[] solution(String[] maps) {
        List<Integer> island = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    island.add(myBFS(maps, new int[]{i, j}));
                }
            }
        }

        return island.isEmpty() ? new int[]{-1} : island.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public int myBFS(String[] maps, int[] start) {
        int sum = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            sum += Integer.parseInt(String.valueOf(maps[curr[0]].charAt(curr[1])));

            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];

                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[nx].length() && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}
