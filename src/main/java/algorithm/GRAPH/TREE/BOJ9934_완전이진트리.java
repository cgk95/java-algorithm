package algorithm.GRAPH.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ9934_완전이진트리 {
    static ArrayList<Integer>[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        level = new ArrayList[K];
        for (int i = 0; i < level.length; i++) {
            level[i] = new ArrayList<>();
        }
        int[] order = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        myDFS(order, 0, order.length, 0);
        for (List<Integer> list : level) {
            for (int n : list) {
                System.out.printf(n+" ");
            }
            System.out.println();
        }
    }

    private static void myDFS(int[] order, int start, int end, int depth) {
        int mid = (start + end) / 2;
        if (mid <= start || mid >= end) {
            level[depth].add(order[mid]);
            return;
        }
        myDFS(order, start, mid - 1, depth + 1);
        level[depth].add(order[mid]);
        myDFS(order, mid + 1, end, depth + 1);

    }
}
