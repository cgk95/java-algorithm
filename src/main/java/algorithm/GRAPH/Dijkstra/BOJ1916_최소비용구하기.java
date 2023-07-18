package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916_최소비용구하기 {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt((br.readLine()));
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, INF);
        for (int i = 0; i < M; i++) {
            StringTokenizer abc = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(abc.nextToken());
            int b = Integer.parseInt(abc.nextToken());
            int c = Integer.parseInt(abc.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        StringTokenizer target = new StringTokenizer(br.readLine());
        myDijkstra(Integer.parseInt(target.nextToken()));
        System.out.println(distance[Integer.parseInt(target.nextToken())]);
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int distance) {
            this.index = index;
            this.cost = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static void myDijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        distance[start] = 0;
        visited[start] = true;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            // 현재 꺼낸 노드로의 비용이 최단거리테이블의 값보다 크다면 이미 방문한 노드이므로 무시
            if (curr.cost > distance[curr.index]) {
                continue;
            }
            for (Node adj : graph.get(curr.index)) {
                // 해당 노드를 거쳐 다음 노드로 이동 할 떄의 값이 다음 이동노드의 최단거리 테이블값보다 작으면
                if (curr.cost + adj.cost < distance[adj.index]) {
                    distance[adj.index] = curr.cost + adj.cost;
                    // 갱신된 노드와 비용을 큐에 삽입
                    pq.offer(new Node(adj.index, distance[adj.index]));
                }
            }
        }

    }
}
