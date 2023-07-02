package algorithm.GRAPH.DFS;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ15663_N과M9 {
    static Set<String> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] input = new int[N];
        int[] output = new int[M];
        boolean[] visited = new boolean[N];
        answer = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(input);
        // 연산
        myPermutation(input, output, visited, 0, N, M);
        // 출력
        answer.forEach(System.out::println);
    }

    private static void myPermutation(int[] input, int[] output, boolean[] visited, int depth, int n, int r) {

        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int num : output) {
                sb.append(num).append(" ");
            }
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                myPermutation(input, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
