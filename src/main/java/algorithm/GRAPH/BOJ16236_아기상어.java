package algorithm.GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16236_아기상어 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[][] board = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            board[i] = line;
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) { // 시작 위치 찾기
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 9) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[0] + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {

                }
            }
        }
    }
}
