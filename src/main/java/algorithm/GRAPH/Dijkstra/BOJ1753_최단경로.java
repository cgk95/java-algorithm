package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753_최단경로 {
    static int V, E, K;
    static List<List<Node>> graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        getInitialInput();
        myDijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    private static void myDijkstra(int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (result[curr.index] < curr.distance) {
                continue;
            }
            for (Node node : graph.get(curr.index)) {
                if (node.distance + curr.distance < result[node.index]) {
                    result[node.index] = node.distance + curr.distance;
                    pq.offer(new Node(node.index, result[node.index]));
                }
            }
        }

    }


    public static void getInitialInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V = input[0];
        E = input[1];
        K = Integer.parseInt(br.readLine());

        result = new int[V + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[K] = 0;

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
        }


    }

    public static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node ohter) {
            return this.distance - ohter.distance;
        }

    }

}
