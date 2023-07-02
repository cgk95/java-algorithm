package algorithm.GRAPH.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_가장먼노드 {
    public int solution(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Node> nodeList = new ArrayList<>();
            graph.add(nodeList);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(new Node(v, 1));
            graph.get(v).add(new Node(u, 1));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        // 우선순위 큐 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        // 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.index;
            int d = node.dist;
            if (d > dist[u]) {
                continue;
            }
            for (Node adj : graph.get(u)) {
                int v = adj.index;
                int w = adj.dist;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        int maxCount = 0;
        for (int i = 1; i < dist.length; i++) {
            maxCount = Math.max(maxCount, dist[i]);
        }
        int answer = 0;
        for (int cnt : dist) {
            if (maxCount == cnt) {
                answer++;
            }
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}

