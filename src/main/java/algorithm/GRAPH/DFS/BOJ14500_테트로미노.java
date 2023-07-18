package algorithm.GRAPH.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14500_테트로미노 {

    private static final int[] dx = {0, 1, 0, -1};  // 북 동 남 서
    private static final int[] dy = {1, 0, -1, 0};

    private static boolean[][] visited;
    private static int[][] board;
    private static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N][M];

        for (int n = 0; n < N; n++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (M >= 0) System.arraycopy(row, 0, board[n], 0, M);
        }

        answer = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ㅗㅜㅏㅓ 연산
                myFunc(i, j);
                // 나머지 연산
                visited[i][j] = true;
                myDFS(i, j, 0, board[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }

    static void myDFS(int x, int y, int moveCount, int sum) {
        if (moveCount == 3) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + x;
            int ny = dy[k] + y;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            myDFS(nx, ny, moveCount + 1, sum + board[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void myFunc(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int rangeSum = board[x][y];
            int count = 0;
            for (int choose = 0; choose < 4; choose++) {
                if (k == choose) {
                    continue;
                }
                int nx = dx[choose] + x;
                int ny = dy[choose] + y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                rangeSum += board[nx][ny];
                count++;
            }
            if (count == 3) {
                answer = Math.max(answer, rangeSum);
            }
        }
    }
}
