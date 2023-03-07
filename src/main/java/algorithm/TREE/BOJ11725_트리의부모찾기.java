package algorithm.TREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11725_트리의부모찾기 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> tree;
    static Queue<Integer> q;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        int N = sc.nextInt();
        sc.nextLine();
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        parent[1] = 1;

        tree = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            for (int node : tree.get(curr)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.offer(node);
                    parent[node] = curr;
                }
            }
        }
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}
