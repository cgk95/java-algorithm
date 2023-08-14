package algorithm.GRAPH.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_배달 {
    public int solution(int N, int[][] road, int K) {
        List<Edge>[] edges = new ArrayList[N + 1];
        makeGraph(N, road, edges);

        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        pq.offer(new Node(1, 0));
        int[] result = new int[N + 1];
        Arrays.fill(result, 500_000 * 2001);

        // dijkstra
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.dist >= result[curr.index]) {
                continue;
            }
            result[curr.index] = curr.dist;

            for (Edge e : edges[curr.index]) {
                pq.offer(new Node(e.ends, curr.dist + e.cost));
            }
        }

        // 출력
        int answer = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    private static void makeGraph(int N, int[][] road, List<Edge>[] edges) {
        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int[] arr : road) {
            edges[arr[0]].add(new Edge(arr[1], arr[2]));
            edges[arr[1]].add(new Edge(arr[0], arr[2]));
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

    public static class Node implements Comparable<Node> {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
