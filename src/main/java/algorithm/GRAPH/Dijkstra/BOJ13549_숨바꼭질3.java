package algorithm.GRAPH.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int K = input[1];
        final int INF = 100_000;
        int[] dist = new int[2 * INF + 2];
        Arrays.fill(dist, INF + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Node::compareTo);
        pq.offer(new Node(N, 0));
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.index == K) {
                System.out.println(curr.dist);
                break;
            }
            if (curr.index * 2 <= 2 * INF + 1) {
                if (dist[curr.index * 2] > curr.dist) {
                    pq.offer(new Node(curr.index * 2, curr.dist));
                    dist[curr.index * 2] = curr.dist;
                }
            }
            if (curr.index + 1 <= 2 * INF + 1) {
                if (dist[curr.index + 1] > curr.dist + 1) {
                    pq.offer(new Node(curr.index + 1, curr.dist + 1));
                    dist[curr.index + 1] = curr.dist + 1;
                }
            }
            if (curr.index - 1 >= 0) {
                if (dist[curr.index - 1] > curr.dist + 1) {
                    pq.offer(new Node(curr.index - 1, curr.dist + 1));
                    dist[curr.index - 1] = curr.dist + 1;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
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
