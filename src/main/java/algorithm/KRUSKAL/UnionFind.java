package algorithm.KRUSKAL;

import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 6}, {1, 3, 3}, {1, 4, 1}, {2, 5, 4}, {3, 4, 2}, {3, 5, 5}, {4, 5, 7}};
        int[] parent = new int[graph.length + 1];
        int total = 0;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(graph, (o1, o2) -> o2[2] - o1[2]);
        for (int[] ints : graph) {
            if (findParent(parent, ints[0]) != findParent(parent, ints[1])) {
                total += ints[2];
                unionParent(parent, ints[0], ints[1]);
            }
        }
        System.out.println(total);
    }

    private static int findParent(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return findParent(parent, parent[i]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        int a_parent = findParent(parent, a);
        int b_parent = findParent(parent, b);
        if (a_parent < b_parent) {
            parent[b_parent] = a_parent;
        } else {
            parent[a_parent] = b_parent;
        }
    }
}
