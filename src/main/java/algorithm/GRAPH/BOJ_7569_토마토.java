package algorithm.GRAPH;

import algorithm.Application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569_토마토 implements Application {
    static Scanner sc = new Scanner(System.in);
    static int[][][] tomatoBox;
    static int[][][] visited;
    static Queue<int[]> q;
    static final int[] dx = {-1, 0, 1, 0, 0, 0};
    static final int[] dy = {0, 1, 0, -1, 0, 0};
    static final int[] dz = {0, 0, 0, 0, -1, 1};
    static int m, n, h;
    static int nx, ny, nz;

    static boolean checkBorder(int z, int y, int x) {
        return 0 <= z && z < h && 0 <= y && y < n && 0 <= x && x < m;
    }

    static int myBfs() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 6; k++) {
                nx = curr[2] + dx[k];
                ny = curr[1] + dy[k];
                nz = curr[0] + dz[k];
                if (checkBorder(nz, ny, nx)) {
                    if (tomatoBox[nz][ny][nx] == 0 && visited[nz][ny][nx] == 0) {
                        tomatoBox[nz][ny][nx] = tomatoBox[curr[0]][curr[1]][curr[2]] + 1;
                        q.add(new int[]{nz, ny, nx});
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < h; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (tomatoBox[k][j][i] == 0) {
                        return -1;
                    }
                    ans = Math.max(ans, tomatoBox[k][j][i]);
                }
            }
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        tomatoBox = new int[h][n][m];
        visited = new int[h][n][m];
        q = new LinkedList<>();
        for (int c = 0; c < h; c++) {
            for (int b = 0; b < n; b++) {
                for (int a = 0; a < m; a++) {
                    tomatoBox[c][b][a] = sc.nextInt();
                    visited[c][b][a] = 0;
                    if (tomatoBox[c][b][a] == 1) {
                        q.add(new int[]{c, b, a}); // 토마토가 들어있는 칸이면 큐에 입력
                        visited[c][b][a] = 1;
                    }
                }
            }
        }
        System.out.println(myBfs());
    }
}

//    public static void main(String[] args) {
//        List<Integer> mnh = map(Arrays.asList(sc.nextLine().split(" ")), Integer::parseInt);
//        List<List<Integer>> bottom=new ArrayList<>();
//        List box=new ArrayList<>();
//        for (int n = 0; n < mnh.get(1); n++) {
//            List<Integer> line = map(
//                    Arrays.asList(sc.nextLine().split(" ")),
//                    Integer::parseInt
//            );
//            bottom.add(line);
//        }
//    }
//    public static <T,R> List<R> map(List<T> list,Function<T,R> f){
//        List<R> result = new ArrayList<>();
//        for (T t : list) {
//            result.add(f.apply(t));
//        }
//        return result;
//    }
