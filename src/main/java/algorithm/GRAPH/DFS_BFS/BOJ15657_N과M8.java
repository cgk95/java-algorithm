package algorithm.GRAPH.DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657_N과M8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] visited = new int[N];
        int[] out = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        myPermutation(arr, out, visited, 0, N, M);
    }

    private static void myPermutation(int[] arr, int[] out, int[] visited, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            if (checkCond(out)) {
                for (int num : out) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] < r) {
                visited[i]++;
                out[depth] = arr[i];
                myPermutation(arr, out, visited, depth + 1, n, r);
                visited[i]--;
            }
        }
    }

    private static boolean checkCond(int[] out) {
        for (int i = 1; i < out.length; i++) {
            if (out[i] < out[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
