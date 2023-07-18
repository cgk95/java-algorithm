package algorithm.GRAPH.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_아이템줍기 {
    char[][] graph;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        graph = new char[101][101];
        for (int[] ints : rectangle) {
            int x1 = ints[0];
            int y1 = ints[1];
            int x2 = ints[2];
            int y2 = ints[3];
            draw(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }
        return myBFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private void draw(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (graph[j][i] == '1') {
                    continue;
                }
                graph[j][i] = '1';
                if (i == x1 || i == x2 || j == y1 || j == y2) { // 테두리인 경우
                    graph[j][i] = '2';
                }
            }
        }
    }

    private int myBFS(int x, int y, int targetX, int targetY) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new Integer[]{y, x, 0});

        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            int currY = curr[0];
            int currX = curr[1];
            int currCount = curr[2];
            if (currY == targetY && currX == targetX) { // 도착 시
                return currCount / 2;
            }

            for (int k = 0; k < 4; k++) {
                int nextX = currX + dx[k];
                int nextY = currY + dy[k];
                if (nextY < 0 || nextX < 0 || nextY >= graph.length || nextX >= graph[0].length) {
                    continue;
                }
                if (visited[nextY][nextX] || graph[nextY][nextX] != '2') { // 방문 하였거나 테두리가 아닌 경우
                    continue;
                }
                q.offer(new Integer[]{nextY, nextX, ++currCount});
                visited[nextY][nextX] = true;
            }
        }
        return 0;
    }
}
