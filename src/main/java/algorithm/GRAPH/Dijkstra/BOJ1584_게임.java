package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1584_게임 {
    static int N, M;
    static int[][] graph = new int[501][501];
    static int[][] result = new int[501][501];
    static final int INF = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        getInitialInput();
        setUp();
        myDijkstra();
        // 출력
        if (result[500][500] < Integer.MAX_VALUE) {
            System.out.println(result[500][500]);
        } else {
            System.out.println(-1);
        }
    }

    private static void setUp() {
        for (int i = 0; i <= 500; i++) {
            Arrays.fill(result[i], INF);
        }
        result[0][0] = 0;
    }

    private static void myDijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.life > result[curr.x][curr.y]) {
                continue;
            }
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + curr.x;
                int ny = dy[k] + curr.y;
                if (0 <= nx && 0 <= ny && nx <= 500 && ny <= 500 && (result[nx][ny] > curr.life + graph[nx][ny]) && graph[nx][ny] < INF) {
                    pq.offer(new Node(nx, ny, curr.life + graph[nx][ny]));
                    result[nx][ny] = curr.life + graph[nx][ny];
                }
            }
        }
    }

    public static void getInitialInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputDanger(br);
        M = Integer.parseInt(br.readLine());
        inputDeath(br);
        br.close();
    }

    private static void inputDeath(BufferedReader br) throws IOException {
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    graph[x][y] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private static void inputDanger(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    graph[x][y] = 1;
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int x, y;
        int life;

        public Node(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
        }

        @Override
        public int compareTo(Node other) {
            return this.life - other.life;
        }
    }
}
