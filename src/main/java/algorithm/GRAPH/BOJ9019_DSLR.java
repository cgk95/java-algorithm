package algorithm.GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// TODO :: 다시 풀기 , BFS로 그리디한 문제 푸는 법
public class BOJ9019_DSLR {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            Solution(br.readLine().split(" "));
            T--;
        }
        br.close();
    }

    private static void Solution(String[] str) { // 1234 to 3412
        int input = Integer.parseInt(str[0]), target = Integer.parseInt(str[1]);
        String[] command = new String[10000];
        Arrays.fill(command, "");
        boolean[] visited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>(); // BFS는 최소도달비용이 보장되는 알고리즘이므로
        visited[input] = true;

        queue.offer(input);
        while (!queue.isEmpty() && !visited[target]) {
            int curr = queue.poll();
            int nextD = funcD(curr);
            int nextS = funcS(curr);
            int nextL = funcL(curr);
            int nextR = funcR(curr);

            if (!visited[nextD]) {
                queue.offer(nextD);
                visited[nextD] = true;
                command[nextD] = command[curr] + "D";
            }
            if (!visited[nextS]) {
                queue.offer(nextS);
                visited[nextS] = true;
                command[nextS] = command[curr] + "S";
            }

            if (!visited[nextL]) {
                queue.offer(nextL);
                visited[nextL] = true;
                command[nextL] = command[curr] + "L";
            }

            if (!visited[nextR]) {
                queue.offer(nextR);
                visited[nextR] = true;
                command[nextR] = command[curr] + "R";
            }
        }
        System.out.println(command[target]);
    }


    private static int funcD(int input) {
        return input * 2 % 10_000;
    }

    private static int funcS(int input) {
        int temp = input - 1;
        if (temp < 0) {
            return 9999;
        } else {
            return temp;
        }
    }

    private static int funcL(int input) { // 왼쪽에서 꺼내서 오른쪽에 추가
        return (input % 1000) * 10 + input / 1000;
    }

    private static int funcR(int input) { // 오른쪽에서 꺼내서 왼쪽에 추가
        return (input % 10) * 1000 + input / 10;
    }

}
