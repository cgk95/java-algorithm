package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1238_파티 {
    static int N, M, X, answer, home;
    static final int INF = 100_000_001;

    static List<Edge>[] nodes;
    static int[] result;

    public static void main(String[] args) throws IOException {
        getInit();
        myDijkstra(X);
        int[] goBack = result;
        for (int i = 1; i < N + 1; i++) {
            myDijkstra(i);
            goBack[i] += result[X];
        }
        for (int i = 1; i < N + 1; i++) {
            if (answer < goBack[i]) {
                answer = goBack[i];
            }
        }
        System.out.println(answer);
    }

    private static void getInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nmx[0];
        M = nmx[1];
        X = nmx[2];

        nodes = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Edge(b, c));
        }
    }

    private static void myDijkstra(int X) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        result = new int[N + 1];
        Arrays.fill(result, INF);
        pq.offer(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.costs > result[curr.index]) {
                continue;
            }
            if (result[curr.index] > curr.costs) {
                result[curr.index] = curr.costs;
            }
            for (Edge e : nodes[curr.index]) {
                pq.offer(new Node(e.ends, curr.costs + e.cost));
            }
        }
    }

    private static class Edge {
        int ends;
        int cost;

        public Edge(int end, int cost) {
            this.ends = end;
            this.cost = cost;
        }
    }

    private static class Node implements Comparable<Node> {
        int index;
        int costs;

        public Node(int index, int costs) {
            this.index = index;
            this.costs = costs;
        }

        @Override
        public int compareTo(Node o) {
            return this.costs - o.costs;
        }
    }

}
