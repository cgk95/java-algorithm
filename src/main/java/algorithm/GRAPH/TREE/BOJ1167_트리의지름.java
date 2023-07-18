package algorithm.GRAPH.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167_트리의지름 {
    static int V, maxLenNode, answer;
    static List<Edge>[] nodes;

    public static void main(String[] args) throws IOException {
        getInit();
        myBFS(1);
        myBFS(maxLenNode);
        System.out.println(answer);
    }

    private static void getInit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        nodes = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                nodes[start].add(new Edge(next, weight));
            }
        }
    }

    public static void myBFS(int start) {
        ArrayDeque<Node> deq = new ArrayDeque<>();
        boolean[] visited = new boolean[V + 1];
        deq.offer(new Node(start, 0));
        visited[start] = true;
        int max_count = 0;

        while (!deq.isEmpty()) {
            Node curr = deq.poll();

            if (curr.count > max_count) {
                max_count = curr.count;
                maxLenNode = curr.index;
            }

            for (Edge e : nodes[curr.index]) {
                if (!visited[e.end]) {
                    deq.offer(new Node(e.end, curr.count + e.weight));
                    visited[e.end] = true;
                }
            }
        }
        answer = Math.max(answer, max_count);
    }

    protected static class Edge {
        int end;
        int weight;

        Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    protected static class Node {
        int index;
        int count;

        Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
