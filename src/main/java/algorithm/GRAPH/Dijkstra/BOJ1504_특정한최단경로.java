package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1504_특정한최단경로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int INF = 1_000_000_007;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        StringTokenizer input = new StringTokenizer(br.readLine());
        //-- 노드와 간선의 개수 입력 --//
        int N = Integer.parseInt(input.nextToken());
        int E = Integer.parseInt(input.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        //-- 간선 입력 --//
        for (int i = 0; i < E; i++) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(edge.nextToken());
            int b = Integer.parseInt(edge.nextToken());
            int c = Integer.parseInt(edge.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        //-- 꼭 거쳐야만 하는 노드 정보 입력 --//
        input = new StringTokenizer(br.readLine());
        int V1 = Integer.parseInt(input.nextToken());
        int V2 = Integer.parseInt(input.nextToken());
        //-- 다익스트라 경로탐색을 준비 --//
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        int[] result = new int[N + 1];
        Arrays.fill(result, INF);
        //-- V1을 먼저 방문하고 이후 V2, N을 차례로 방문하는 경우의 수 --//
        pq.offer(new Node(1, 0));
        dijkstra(pq, result);
        int route1 = INF;
        route1 = findRoute(N, V1, V2, pq, result, route1);

        //-- V2를 먼저 방문하고 이후 V1, N을 차례로 방문하는 경우의 수 --//
        Arrays.fill(result, INF);
        pq.offer(new Node(1, 0));
        dijkstra(pq, result);
        int route2 = INF;
        route2 = findRoute(N, V2, V1, pq, result, route2);

        //-- 둘 중 더 효율적인 경로를 출력 --//
        int answer = Math.min(route1, route2);
        if (answer < INF) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    private static int findRoute(int n, int v1, int v2, PriorityQueue<Node> pq, int[] result, int route) {
        if (result[v1] < INF) {
            route = result[v1];

            Arrays.fill(result, INF);
            pq.offer(new Node(v1, 0));
            dijkstra(pq, result);
            if (result[v2] < INF) {
                route += result[v2];

                Arrays.fill(result, INF);
                pq.offer(new Node(v2, 0));
                dijkstra(pq, result);
                if (result[n] < INF) {
                    route += result[n];
                } else {
                    route = INF;
                }
            } else {
                route = INF;
            }
        }
        return route;
    }

    private static void dijkstra(PriorityQueue<Node> pq, int[] result) {
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (result[curr.index] <= curr.dist) { // 이미 방문한 노드이므로
                continue;
            }
            result[curr.index] = curr.dist;

            for (Edge e : graph[curr.index]) {
                pq.offer(new Node(e.ends, curr.dist + e.cost));
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static class Edge {
        int ends;
        int cost;

        public Edge(int ends, int cost) {
            this.ends = ends;
            this.cost = cost;
        }
    }
}
