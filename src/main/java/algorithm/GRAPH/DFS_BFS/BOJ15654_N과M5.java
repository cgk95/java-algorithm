package algorithm.GRAPH.DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15654_N과M5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N];
        boolean[] visited = new boolean[N];
        int[] output = new int[M];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(num);
        myPemutation(num, visited, output, 0, N, M);
    }

    private static void myPemutation(int[] arr, boolean[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int num : output) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                myPemutation(arr, visited, output, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
