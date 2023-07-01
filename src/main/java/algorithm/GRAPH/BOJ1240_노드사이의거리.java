package algorithm.GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1240_노드사이의거리 {
    private static int[] distance;
    static ArrayList<int[]>[] graph;
    private static final int INF = Integer.MAX_VALUE;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;

    public static void main(String[] args) throws IOException {
        // 노드의 개수와 알고 싶은 관계의 수 입력 받기
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        // N-1 개의 줄에 간선 정보 입력 받기
        inputEdgeInfo(br, N);
        // 알고 싶은 노드간의 거리 계산
        for (int tc = 0; tc < M; tc++) {
            String[] target = br.readLine().split(" ");
            int start = Integer.parseInt(target[0]);
            int end = Integer.parseInt(target[1]);
        }
    }

    private static void inputEdgeInfo(BufferedReader br, int N) throws IOException {
        for (int edge = 0; edge < N - 1; edge++) {
            String[] inputEdge = br.readLine().split(" ");
            int a = Integer.parseInt(inputEdge[0]);
            int b = Integer.parseInt(inputEdge[1]);
            int cost = Integer.parseInt(inputEdge[2]);
            // 연결된 간선과 비용 입력;
            graph[a].add(new int[]{b, cost});
        }
    }

    private static void myDijkstra(int start) {
    }
}
