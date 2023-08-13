package algorithm.GRAPH.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_리코쳇로봇 {
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};
    ArrayList<Integer> answerList = new ArrayList<>();
    int N, M;

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        for (int i = 0; i < N; i++) {
            String row = board[i];
            char[] charArray = row.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char col = charArray[j];
                if (col == 'R') {
                    myBFS(new Point(i, j, 0), board);
                    break;
                }
            }
        }
        if (answerList.size() > 1) {
            return answerList.get(1);
        }
        return answerList.get(0);
    }

    public void myBFS(Point start, String[] board) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[start.x][start.y] = true;
        answerList.add(-1);
        q.offer(start);

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (board[curr.x].charAt(curr.y) == 'G') {
                answerList.add(curr.count);
                break;
            }
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + curr.x;
                int ny = dy[k] + curr.y;
                boolean moved = false;
                while (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx].charAt(ny) != 'D') {
                    moved = true;
                    nx = nx + dx[k];
                    ny = ny + dy[k];
                }
                if (moved) {
                    nx -= dx[k];
                    ny -= dy[k];
                }
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && board[nx].charAt(ny) != 'D') {
                    q.offer(new Point(nx, ny, curr.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }


    }


    public static class Point {
        int x;
        int y;

        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;

        }
    }

}
