package algorithm.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026_적록색약 {
    static String[][] grid;
    static int N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        grid = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = sc.nextLine().split("");
            System.arraycopy(row, 0, grid[i], 0, N);
        }
        System.out.printf("%d %d", countArea(), countWeaknessArea());
    }

    private static int countArea() {
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) { // 방문하였다면 다음 글자로
                    continue;
                }
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + curr[0];
                        int ny = dy[k] + curr[1];
                        if (0 <= nx && 0 <= ny && nx < N && ny < N
                                && !visited[nx][ny]
                                && grid[nx][ny].equals(grid[curr[0]][curr[1]])) {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    private static int countWeaknessArea() {
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) { // 방문하였다면 다음 글자로
                    continue;
                }
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + curr[0];
                        int ny = dy[k] + curr[1];
                        if (0 <= nx && 0 <= ny && nx < N && ny < N
                                && !visited[nx][ny]
                                && checkDiff(grid[curr[0]][curr[1]], grid[nx][ny])) {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    private static boolean checkDiff(String prev, String curr) {
        if (prev.equals("R") || prev.equals("G")) { //  적록
            return !curr.equals("B");
        } else { // 파랑
            return curr.equals("B");
        }
    }
}
