package algorithm.GRAPH.BellmanFord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// TODO :: 다시 풀어보기
public class BOJ1865_웜홀 {
    static int N, M, W;

    static final int INF = 10_000 * 3001;

    static List<List<Edge>> nodes;

    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            int[] nmw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = nmw[0]; // 지점의 수
            M = nmw[1]; // 도로의 개수
            W = nmw[2]; // 웜홀의 개수

            nodes = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                nodes.add(new ArrayList<>());
            }
            getEdges(br);

            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bellmanFord() {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean isUpdated = false;
        // 모든 지점을 N-1번 순회
        for (int i = 1; i < N; i++) {
            isUpdated = false;
            for (int j = 1; j <= N; j++) {
                for (Edge v : nodes.get(j)) {
                    if (dist[v.end] > dist[j] + v.weight) {
                        dist[v.end] = dist[j] + v.weight;
                        isUpdated = true;
                    }
                }
            }
            // 더 이상 최단거리 초기화가 일어나지 않는다면 탈출
            if (!isUpdated) {
                break;
            }
        }

        // 정점 개수 - 1 까지 계속 업데이트가 발생한 경우
        // 정점 개수 번도 업데이트가 발생했다면 음수 사이클이 발생했음을 의미
        if (isUpdated) {
            for (int j = 1; j <= N; j++) {
                for (Edge v : nodes.get(j)) {
                    if (dist[v.end] > dist[j] + v.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void getEdges(BufferedReader br) throws IOException {
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 시작 지점
            int E = Integer.parseInt(st.nextToken()); // 도착 지점
            int X = Integer.parseInt(st.nextToken()); // 소요 시간
            nodes.get(S).add(new Edge(E, X));
            nodes.get(E).add(new Edge(S, X));

        }
        for (int j = 0; j < W; j++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            nodes.get(S).add(new Edge(E, -X));
        }
    }

    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

}
