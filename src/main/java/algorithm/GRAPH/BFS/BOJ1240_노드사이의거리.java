package algorithm.GRAPH.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1240_노드사이의거리 {
    static int N, M, result;
    static List<Edge>[] tree;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        getInit();
        for (int i = 0; i < M; i++) {
            StringTokenizer target = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(target.nextToken());
            int end = Integer.parseInt(target.nextToken());
            myBFS(new Node(start, 0), end);
            System.out.println(result);
        }
    }

    public static void getInit() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[a].add(new Edge(b, w));
            tree[b].add(new Edge(a, w));
        }
    }

    public static class Edge {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void myBFS(Node start, int end) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(start);
        visited[start.index] = true;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.index == end) {
                result = curr.count;
                break;
            }
            for (Edge e : tree[curr.index]) {
                if (!visited[e.end]) {
                    q.offer(new Node(e.end, e.cost + curr.count));
                    visited[e.end] = true;
                }
            }
        }
    }

    public static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
