package algorithm.GRAPH.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967_트리의지름 {
    static int N, result, max_node;
    static ArrayList<Edge>[] nodes;

    public static void main(String[] args) {
        try {
            getInitialInput();
            myBFS(1); // 임의의 노두
            myBFS(max_node); // 임의의 노드에서 가장먼 노드
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(result);
        }
    }

    private static void myBFS(int idx) {
        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Node> deq = new ArrayDeque<>();
        deq.add(new Node(idx, 0));
        visited[idx] = true;
        int max_count = 0;
        while (!deq.isEmpty()) {
            Node curr = deq.poll();
            if (curr.count > max_count) {
                max_count = curr.count;
                max_node = curr.index;
            }
            for (Edge v : nodes[curr.index]) {
                if (!visited[v.end]) {
                    visited[v.end] = true;
                    deq.offer(new Node(v.end, curr.count + v.weight));
                }
            }
        }
        result = Math.max(result, max_count);
    }

    public static void getInitialInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[parent].add(new Edge(child, weight));
            nodes[child].add(new Edge(parent, weight));
        }
    }

    public static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
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
