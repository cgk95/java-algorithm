package algorithm.GRAPH.DFS;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BOJ15666_N과M12 {
    static LinkedHashSet<String> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] input = new int[N];
        int[] output = new int[M];
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        // 연산
        answer = new LinkedHashSet<>();
        myDFS(input, output, visited, 0, M);
        answer.forEach(System.out::println);
    }

    private static void myDFS(int[] input, int[] output, int[] visited, int depth, int r) {
        if (depth == r) {
            int[] temp = new int[output.length];
            System.arraycopy(output, 0, temp, 0, temp.length);
            Arrays.sort(temp);

            StringBuilder sb = new StringBuilder();
            for (int num : temp) {
                sb.append(num).append(" ");
            }
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (visited[i] < r) {
                visited[i]++;
                output[depth] = input[i];
                myDFS(input, output, visited, depth + 1, r);
                visited[i]--;
            }
        }
    }
}
