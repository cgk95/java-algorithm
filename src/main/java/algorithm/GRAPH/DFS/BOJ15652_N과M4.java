package algorithm.GRAPH.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15652_N과M4 {
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int[] numbers = new int[n];
        int[] output = new int[m];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        myDFS(numbers, visited, output, 0, n, m);
    }

    private static void myDFS(int[] numbers, int[] visited, int[] output, int depth, int n, int r) {
        if (depth == r) {
            if (checkCondition(output)) {
                StringBuilder sb = new StringBuilder();
                for (int num : output) {
                    sb.append(num).append(" ");
                }
                System.out.println(sb);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] < r) {
                visited[i]++;
                output[depth] = numbers[i];
                myDFS(numbers, visited, output, depth + 1, n, r);
                visited[i]--;
            }
        }
    }

    private static boolean checkCondition(int[] output) {
        for (int idx = 1; idx < output.length; idx++) {
            if (output[idx] < output[idx - 1]) {
                return false;
            }
        }
        return true;
    }
}
