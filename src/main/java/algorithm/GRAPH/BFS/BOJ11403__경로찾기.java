package algorithm.GRAPH.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class BOJ11403__경로찾기 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Node> arr;
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();
        sc.nextLine();
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new Node(i, new ArrayList<>(Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList())
            )));
        }

        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = findWay(i, j);
            }
        }

        for (int[] ans : answer) {
            for (int num : ans) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    private static int findWay(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N];

        q.offer(arr.get(start));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.edge.get(end) == 1) {
                return 1;
            }
            for (int vertex = 0; vertex < N; vertex++) {
                if (curr.edge.get(vertex) == 1 && !visited[vertex]) {
                    q.offer(arr.get(vertex));
                    visited[vertex] = true;
                }
            }
        }
        return 0;
    }

    static class Node {
        int index;
        ArrayList<Integer> edge;

        public Node(int index, ArrayList<Integer> edge) {
            this.index = index;
            this.edge = edge;
        }
    }
}
