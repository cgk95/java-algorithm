package algorithm.DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15650_N과M2 {
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        sc.close();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < numbers.length; i++) {
            myDFS(numbers, output, visited, 0, m);
        }
        //출력
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static void myDFS(int[] numbers, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(" ");
            }
            if (!answer.contains(sb.toString()) && checkAsc(sb.toString().split(" "))) {
                answer.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                myDFS(numbers, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }

    }

    private static boolean checkAsc(String[] target) {
        for (int i = 1; i < target.length; i++) {
            if (Integer.parseInt(target[i]) < Integer.parseInt(target[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
